
//上一页方法
function lastPage() {
	var totalPage1 = $("#totalPage1").val();	
	var totalPage = $("#totalPage").val();	
	if(""==totalPage1){
		var pageNo = parseInt($("#currentPage").val());	
		if (pageNo == 1) {
			alert("已经是第一页了!");
			return false;
		} 
	}else{
		var pageNo1 = parseInt($("#currentPage1").val());	
		if (pageNo1 == 1) {
			alert("已经是第一页了!");
			return false;
		} 
	}
	
	
}
// 下一页方法
function nextPage() {

	var totalPage1 = $("#totalPage1").val();	
	var totalPage = $("#totalPage").val();	
	if(""==totalPage1){
		var pageNo = parseInt($("#currentPage").val());	
		if (pageNo == parseInt(totalPage)) {
			alert("已经是最后一页了!");
			return false;
		}		 
	}else{
		var pageNo1 = parseInt($("#currentPage1").val());	
		if (pageNo1 == parseInt(totalPage1)) {
			alert("已经是最后一页了!");
			return false;
		}		 
	}
	
}

function queryProducts() {
	var qname = $("#qname").val();
	if (qname == null) {
		alert("请输入想要搜索的商品名!");
	} else {
		window.location.href = "query?qname=" + qname;

	}

}

