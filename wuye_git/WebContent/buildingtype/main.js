$(document).ready(function(){
	var rows = 5;
	var page = 1;
	var totalPage = 0;
	var totalCount = 0;
	
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
		});
	}
});