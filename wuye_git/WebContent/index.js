$(document).ready(function(){
	var mainContent = $("div#page-wrapper");
	$("ul.nav-second-level li a").on("click",function(event){
		var href = $(this).attr("href");
		if(href != "#"){
			mainContent.load(href);
		}
		//禁止对象的默认行为
		event.preventDefault();
	});
});