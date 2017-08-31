$(document).ready(function(){
	
	var areaNo = 0;
	
	$("#areaGrid").jqGrid({
		url: 'area/getListByAllWithPage.mvc',
		datatype: "json",
		mtype:"GET",
		styleUI:'Bootstrap',
		colModel: [
			{ label: '名称', name: 'name', width: 150 },
			{ label: '地址', name: 'aaddress', width: 200 },
			{ label: '开发商', name: 'developer', width: 100 },
			{ label: '入住日期', name: 'startDate', width: 100}
		],
		viewrecords: true, // show the current page, data rang and total records on the toolbar
		autowidth:true,
		height: 400,
		rowNum: 4,
		rowList:[2,4,6,8],
		jsonReader:{
			root:"list",
			page:"page",
			total:"totalPage",
			records:"totalCount",
			id:"no"
		},
		pager: "#areaGridPage",
		onSelectRow:function(id){
			areaNo = parseInt(id);
		}
	});
	
	
	$("div#operation a").on("click",function(event){
		event.preventDefault();
		var ope = $(this).text();
		if(ope == "增加"){
			$("#ModalLabel").html("新增小区");
			$("#modelbody").load("area/add.html",function(){
				
				$("#areaSubmit").on("click",function(){
					
					//利用jquery validate插件
					$("#areaAddForm").validate({
						rules:{
							name:{
								required:true,
								minlength:4,
								remote:{
									url:"area/checkNameExist.mvc",
									type:"post"
								}
							}
						},
						messages:{
							name:{
								required:"请填写小区名称",
								minlength:"小区名称不能少于四个字符",
								remote:"小区名称已经存在"
							}
						}
					});
					
					//利用jquery form 插件
					$("#areaAddForm").ajaxForm(function(data) { 
						if(data.code == "200"){
							 BootstrapDialog.alert({title:"提示",message:data.msg});
							 $("#areaGrid").trigger("reloadGrid");
							 $("#areaModal").modal("hide");
						}else{
							 BootstrapDialog.alert({title:"提示",message:"添加失败"});
						}
		            });					
				});
				
				$("#areaCancel").on("click",function(){
					$("#areaModal").modal("hide");
					//getPageInfo(rows,page);
				});			
			});
			$("#areaModal").modal("show");
		}else if(ope == "修改"){
			if(buildingTypeNo==0){
				 BootstrapDialog.alert({title:"提示",message:"请选择要修改的建筑类型"});
				return;
			}else{
				$("#ModalLabel").html("修改建筑类型");
				$("#modelbody").load("area/modify.html",function(){
					$.getJSON("buildingtype/get.mvc",{typeNo:buildingTypeNo},function(data){
						$("#buildingTypeName").val(data.name);
					});
					
					$("#buildingTypeSubmit").on("click",function(){
						var typeName = $("#buildingTypeName").val();
						if(typeName == null||typeName==''){
							$("#nameMessage").html("建筑类型不能为空");
							$("#nameMessage").css("color","red");
						}else{
							$("#nameMessage").html("");
							$.post("area/modify.mvc",{no:buildingTypeNo,name:typeName},function(data){
								if(data.code == "200"){
									BootstrapDialog.alert({title:"提示",message:data.msg});
									getPageInfo(rows,page);
									$("#buildingTypeModal").modal("hide");
								}else{
									$("#nameMessage").html("");
									 BootstrapDialog.alert({title:"提示",message:"修改失败"});
								}
							});						
						}
						
						buildingTypeNo = 0;
					});
					
					$("#buildingTypeCancel").on("click",function(){
						$("#buildingTypeModal").modal("hide");
						getPageInfo(rows,page);
					});	
					
				});
				$("#buildingTypeModal").modal("show");
			}
		}else if(ope == "删除"){
			if(buildingTypeNo==0){
				 BootstrapDialog.alert({title:"提示",message:'请选择要删除的建筑类型'});
				return;
			}
			$.get("area/checkCanDelete.mvc",{typeNo:buildingTypeNo},function(canDeleteResult){
				if(canDeleteResult.msg == "N"){
					//不能删
					 BootstrapDialog.alert({title:"提示",message:"不能删除"});
				}else{				
					 BootstrapDialog.confirm({title:"提示",message:"确认删除吗",type:"type-danger"},function(deleteChoice){
						 if(deleteChoice){
							$.get("area/delete.mvc",{no:buildingTypeNo},function(deleteResult){
								if(deleteResult.code == "200"){
									 BootstrapDialog.alert({title:"提示",message:"删除成功"});
									 getPageInfo(rows,page);
								}
							});
						}
					 });
				}
			});
		}else if(ope == "查看"){
			if(areaNo==0){
				 BootstrapDialog.alert("请选择要查看的小区");
				return;
			}else{
				$("#ModalLabel").html("小区详情");
				$("#modelbody").load("area/detail.html",function(){
					$.getJSON("area/selectAreaWithPhoto.mvc",{areaNo:areaNo},function(data){
					    $("#name").html(data.name);
			            $("#aaddress").html(data.aaddress);
			            $("#developer").html(data.developer);
			            $("#totalBuildingArea").html(data.totalBuildingArea);
			            $("#totalUserArea").html(data.totalUserArea);
			            $("#totalPackArea").html(data.totalPackArea);
			            $("#totalHome").html(data.totalHome);
			            $("#totalPack").html(data.totalPack);
			            $("#totalHouse").html(data.totalHouse);
			            $("#startDate").html(data.startDate);
			            if(data.photo != null){
			            	//如果是图片，直接显示，如果是其他文件，提供下载功能
			            	if(data.photoContentType.indexOf("image") >= 0){
			            		$("#fujian").html("<img src='upload/"+data.photoFileName+"' width='80px' height='80px' />");
			            	}else{
			            		$("#fujian").html("<a href='area/downPhoto.mvc?areaNo="+areaNo+"'>下载</a>")
			            	}
			            }
					});
					
					$("#areaCancel").on("click",function(){
						$("#areaModal").modal("hide");
					});					
				});
				$("#areaModal").modal("show");
			}
		}else if(ope == "导入数据"){
			$("#ModalLabel").html("导入数据");
			$("#modelbody").load("area/import.html",function(){
				
				//利用jquery form 插件
				$("#importForm").ajaxForm(function(data) { 
					if(data.code == "200"){
						 BootstrapDialog.alert({title:"提示",message:data.msg});
						 $("#areaModal").modal("hide");
					}else{
						 BootstrapDialog.alert({title:"提示",message:"导入失败"});
					}
	            });	
				
				$("#areaCancel").on("click",function(){
					$("#areaModal").modal("hide");
				});	
			});
			$("#areaModal").modal("show");
		}else if(ope == "导出数据"){
			$("#ModalLabel").html("导出数据");
			$("#modelbody").load("area/export.html",function(){
			
				$("#areaCancel").on("click",function(){
					$("#areaModal").modal("hide");
				});	
			});
			$("#areaModal").modal("show");
		}else{}
		return;
	})
	
});