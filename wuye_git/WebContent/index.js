$(document).ready(function(){
//	var mainContent = $("div#page-wrapper");
//	$("ul.nav-second-level li a").on("click",function(event){
//		var href = $(this).attr("href");
//		if(href != "#"){
//			mainContent.load(href);
//		}
//		//禁止对象的默认行为
//		event.preventDefault();
//	});
	
	$.jgrid.defaults.styleUI = 'Bootstrap';

	$("div#maincontent").css("height","500px");
	
	$.getJSON("user/getfromsession.mvc",function(userdata){
		if(userdata.result=="N"){
			location.href="login.html";
		}
		else{
			loginUser=userdata.user;
			$("span#loginusername").html(loginUser.name);
			
			//取得模块列表
			$.getJSON("module/list/all.mvc",function(moduleData){
				
				for(var i=0;i<moduleData.length;i++){
					$("ul[id='side-menu']").append("<li id='m"+moduleData[i].no+"'><a class='active' href='#'>"+moduleData[i].name+"<span class='fa arrow'></span></a><ul class='nav nav-second-level' ></ul></li>");
				}
				//取得用户的功能列表，显示功能点击菜单
				var userfunctions=loginUser.functions;
				for(var i=0;i<userfunctions.length;i++){
					$("li[id='m"+userfunctions[i].module.no+"'] ul").append("<li><a href='"+userfunctions[i].url+"'>"+userfunctions[i].name+"</a></li>");
				}
				//初始化伸缩菜单
				$("ul[id='side-menu']").metisMenu();
				
				
				$("ul.nav-second-level li a").on("click",function(event){
					var href=$(this).attr("href");
					if(href!="#"){
						$("div#maincontent").load(href,function(){
							
						});
					}
					event.preventDefault();
				});
				
				
			});	
		}
	});
	//点击注销处理
	$("a#logoutLink").on("click",function(){
		$.getJSON("user/logout.mvc",function(logoutdata){
			location.href="login.html";
		});
	});
});