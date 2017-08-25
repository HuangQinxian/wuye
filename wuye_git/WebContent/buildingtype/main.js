$(document).ready(function(){
	var rows = 5;
	var page = 1;
	var totalPage = 0;
	var totalCount = 0;
	var buildingTypeNo = 0;
	
	var tbody = $("#buildingTypeTable tbody");
	
	getPageInfo(rows,page);
	
	$("ul.pagination li a").on("click",function(event){
		event.preventDefault();
		var href = $(this).attr("href");
		if(href=="first"){
			if(page > 1){
				getPageInfo(rows,1);
			}
		}else if(href == "previous"){
			if(page > 1){
				getPageInfo(rows,page-1);
			}
		}else if(href == "next"){
			if(page < totalPage){
				getPageInfo(rows,page+1);
			}
		}else{
			if(page != totalPage){
				getPageInfo(rows,totalPage);
			}
		}
		return;
	});
	
	function getPageInfo(nrows,npage){
		$.get('buildingtype/getListByAllWithPage.mvc',{rows:nrows,page:npage},function(data){
			var list = data.list;
			page = data.page;
			totalPage = data.totalPage;
			totalCount = data.totalCount;
			tbody.html("");
			for(var i = 0; i < list.length; i++){
				tbody.append("<tr><td>"+list[i].no+"</td><td>"+list[i].name+"</td></tr>");
			}
			$("#buildingTypeTable tbody tr").on("click",function(event){
				$("#buildingTypeTable tbody tr").css("background-color","white");
				$(this).css("background-color","rgb(51, 122, 183)");
				buildingTypeNo = parseInt($(this).find("td:first").html());
			});
		});
	}
	
	$("div#operation a").on("click",function(event){
		event.preventDefault();
		var ope = $(this).text();
		if(ope == "增加"){
			$("#ModalLabel").html("新增建筑类型");
			$("#modelbody").load("buildingtype/add.html",function(){
				$("#buildingTypeSubmit").on("click",function(){
					var typeName = $("#buildingTypeName").val();
					if(typeName == null||typeName==''){
						$("#nameMessage").html("建筑类型不能为空");
						$("#nameMessage").css("color","red");
					}else{
						$("#nameMessage").html("");
						$.post("buildingtype/add.mvc",{name:typeName},function(data){
							if(data.code == "200"){
								 BootstrapDialog.alert({title:"提示",message:data.msg});
								getPageInfo(rows,1);
								$("#buildingTypeModal").modal("hide");
							}else{
								$("#nameMessage").html("");
								 BootstrapDialog.alert({title:"提示",message:"添加失败"});
							}
						});						
					}
				});
				
				$("#buildingTypeCancel").on("click",function(){
					$("#buildingTypeModal").modal("hide");
					getPageInfo(rows,page);
				});	
				
			});
			$("#buildingTypeModal").modal("show");
		}else if(ope == "修改"){
			if(buildingTypeNo==0){
				 BootstrapDialog.alert({title:"提示",message:"请选择要修改的建筑类型"});
				return;
			}else{
				$("#ModalLabel").html("修改建筑类型");
				$("#modelbody").load("buildingtype/modify.html",function(){
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
							$.post("buildingtype/modify.mvc",{no:buildingTypeNo,name:typeName},function(data){
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
			$.get("buildingtype/checkCanDelete.mvc",{typeNo:buildingTypeNo},function(canDeleteResult){
				if(canDeleteResult.msg == "N"){
					//不能删
					 BootstrapDialog.alert({title:"提示",message:"不能删除"});
				}else{				
					 BootstrapDialog.confirm({title:"提示",message:"确认删除吗",type:"type-danger"},function(deleteChoice){
						 if(deleteChoice){
							$.get("buildingtype/delete.mvc",{no:buildingTypeNo},function(deleteResult){
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
			if(buildingTypeNo==0){
				 BootstrapDialog.alert("请选择要查看的建筑类型");
				return;
			}else{
				$("#ModalLabel").html("查看建筑类型");
				$("#modelbody").load("buildingtype/detail.html",function(){
					$.getJSON("buildingtype/get.mvc",{typeNo:buildingTypeNo},function(data){
						$("#buildingTypeName").html(data.name);
					});
					
					$("#buildingTypeCancel").on("click",function(){
						$("#buildingTypeModal").modal("hide");
						getPageInfo(rows,page);
					});					
				});
				$("#buildingTypeModal").modal("show");
			}
		}else{}
		return;
	})
});