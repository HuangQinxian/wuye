/**
 * 系统操作员管理主控制JS
 */
$(function(){
	var no=null;
	
	//显示系统操作员表格
	$("#feeTypeGrid").jqGrid({
		url: 'feetype/list/page.mvc',
		datatype: "json",
		mtype:"GET",
		styleUI:'Bootstrap',
		colModel: [
			{ label: '收费编号', name: 'no', width: 150 },
			{ label: '收费类型', name: 'name', width: 200 },	
		],
		viewrecords: true, // show the current page, data rang and total records on the toolbar
		autowidth:true,
		height: 370,
		rowNum: 10,
		rowList:[10,15,20],
		jsonReader:{
			root:"list",
			page:"page",
			total:"pageCount",
			records:"count",
			id:"no"
		},
		pager: "#feeTypeGridPager",
		multiselect:false,
		onSelectRow:function(id){
			no=id;
		},
		loadComplete:function(errordata){
			if(errordata.msg){
				BootstrapDialog.alert({title:"提示",message:errordata.msg});
			}
		}
	});
	//点击增加处理
	$("a#feeTypeAddLink").on("click",function(){
		$("#modelbody").load("feetype/add.html",function(){
			$("#ModalLabel").html("增加系统模块");
			
			//验证
			$("form#feeTypeAddForm").validate({
				rules:{
					name:{required:true}
					
				},
				messages:{
					name:{
						required:"收费类型不能为空"
					}
				}
				
			});
			//拦截用户增加
			$("form#feeTypeAddForm").ajaxForm(function(data){
				if(data.code=="200"){
					$("#feeTypeGrid").trigger("reloadGrid");
					BootstrapDialog.alert({title:"提示",message:data.msg});
				}else{
					BootstrapDialog.alert({title:"提示",message:"收费类型添加失败"});
				}
				
				$('#feeTypeInfoModal').modal("hide");
			});
			//点击取消按钮处理
			$("button[type='reset']").on("click",function(){
				$('#feeTypeInfoModal').modal("hide");
			});
		});
		$('#feeTypeInfoModal').modal("show");
		
	});
	//点击修改处理
	$("a#moduleModifyLink").on("click",function(){
		if(no==null){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的系统模块"});
		}
		else{
			
			
			$("#modelbody").load("module/modify.html",function(){
				var moduleName = null;
				$.getJSON("module/get.mvc",{moduleNo:no},function(moduleById){
					moduleName = moduleById.name;
					
					$("#moduleName").val(moduleName);
					$("#no").val(no);
					
					$("#ModalLabel").html("系统模块修改");
					
					//验证
					$("form#moduleAddForm").validate({
						rules:{
							name:{required:true}
							
						},
						messages:{
							name:{
								required:"模块名称不能为空"
							}
						}
					});
					//拦截用户修改表单提交
					$("form#moduleModifyForm").ajaxForm(function(data){
						if(data.code=="200"){
							$("#moduleGrid").trigger("reloadGrid");
						}
						
						BootstrapDialog.alert({title:"提示",message:data.msg});
						$('#ModuleInfoModal').modal("hide");
					});
					$("button[type='reset']").on("click",function(){
						$('#ModuleInfoModal').modal("hide");
					});
				});
			});
			$('#ModuleInfoModal').modal("show");
		}
	});
	
	//点击删除处理
	$("a#moduleDeleteLink").on("click",function(){
		if(no==null){
			BootstrapDialog.alert({title:"提示",message:"请选择要删除的系统模块"});
		}
		else{
			$.getJSON("module/checkcandelete.mvc",{no:no},function(data){
				if(data.code=="200"){
					
					BootstrapDialog.confirm({
						title:"删除确认",
						message:"您确认要删除此模块么?",
						callback:function(result){
							if(result){
								$.post("module/delete.mvc",{no:no},function(data){
									if(data.code=="200"){
										no=null;
										$("#moduleGrid").trigger("reloadGrid");
									}
									BootstrapDialog.alert({title:"提示",message:data.msg});
								});
							}
						}
					});
					
				}
				else{
					BootstrapDialog.alert({title:"警告",message:data.msg});
				}
			});
		}
	});
	
	//点击查看处理
	$("a#userViewLink").on("click",function(){
		if(userid==null){
			BootstrapDialog.alert({title:"提示",message:"请选择要查看的操作员"});
		}
		else{
			$("#ModalLabel").html("查看系统模块");
			$("#modelbody").load("userinfo/view.html",function(){
				
				$.getJSON("user/get.mvc",{userid:userid},function(userdata){
					if(userdata!=null){
						$("span#userid").html(userdata.userid);
						$("span#username").html(userdata.name);
						$("span#usersex").html(userdata.sex);
						if(userdata.functions!=null){
							for(var i=0;i<userdata.functions.length;i++){
								$("span#userfunctions").append(" "+userdata.functions[i].name+" " );
							}
						}
					}
				});
				
				$("button[type='reset']").on("click",function(){
					$('#UserInfoModal').modal("hide");
				});
				
			});
			$('#UserInfoModal').modal("show");
		}
	});
	
});