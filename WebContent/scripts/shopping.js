function deleteCart(cid) {
	$.ajax({
		url:"doAction?action=deleteCart",
		type:"POST",
		data:"cid="+cid,
		success:function(msg){
			if(msg==1){
				alert("删除成功");
				//需要将自身这条记录删除
				$("#product_"+cid).remove();
			}else{
				alert("删除失败");
			}
		},
		error:function(){
			alert("请求失败");
		}
	});
}



function alterCount(cid) {
//	window.location.href="alterQuantity?"+cid+"_"+$("#"+cid).val()
	var flag = false;
	$.ajax({
		url : "doAction?action=changeCartCount",// 请求的servlet地址
		async : false,
		type : "POST",// 请求方式
		data : "cid="+cid+"&count="+$("#"+cid).val(),// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(msg) {
			if(msg==1){
				flag = true;
			}else{
				alert("操作失败!");
				window.location.href="doAction?action=showCart";
			}
			//$("#cartCount").html(total);
		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {

		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!");
		}// 响应失败后执行的回调方法
	});
	return flag;
}


//-按钮事件
function reduce(id){
	var stock=$("#hpStock"+id).val()
	if($("#"+id).val()==1){
		$("#"+id).val(1)
	}else if($("#"+id).val()>=2){
		//获取原先值
		var old=$("#"+id).val();
		$("#"+id).val(parseInt(old)-1);
		var flag = alterCount(id);
		if(flag){			
			$("#hpStock"+id).val(stock + 1);
			$("#old_"+id).val($("#"+id).val());
		}
	}
	
}

//+按钮事件
function increase(id){
	
	var stock=$("#hpStock"+id).val()//获得库存
	var old=$("#"+id).val()//获得原来的数量
	if(parseInt(stock)>=1){
		$("#"+id).val(parseInt(old)+1);
		var flag = alterCount(id);
		if(flag){			
			$("#hpStock"+id).val(stock-1);
			$("#old_"+id).val($("#"+id).val());
		}
	}else{
		alert("您选择的数量超过库存!");
	}
	
}



function checkStock(id){
	var stock=$("#hpStock"+id).val();//获得库存
	var trueOld = $("#old_"+id).val();//原来的数量
	var old=$("#"+id).val();//获得修改后的值
	var check = /^-?[1-9]{1}[0-9]{0,4}d*$/;
	var change = parseInt(old)-parseInt(trueOld);
	if(check.test(old)==false){
		alert("输入有误!");
		window.location.href="doAction?action=showCart";
	}else if(change>parseInt(stock)){
		alert("您选择的数量超过库存!");
		window.location.href="doAction?action=showCart";
	}else if(parseInt(old)<1){
		alert("输入有误!");
		window.location.href="doAction?action=showCart";
	}else{
		var flag = alterCount(id);
		if(flag){			
			$("#hpStock"+id).val(stock-change);
			$("#old_"+id).val($("#"+id).val());
		}
	}
}




function buttonTest(id) {
	alert("测试id="+id)
}


function checkCart(){
	var flag = false;
	$.ajax({
		url:"doAction?action=checkCart",// 请求的servlet地址
		type:"POST",// 请求方式
		dataType:"text",// 设置返回数据类型
		async:false,
		success:function(msg) {
			if(msg==1){
				flag = true;
			}else{				
				flag = false;
				alert("您的购物车空空如也,赶快去挑选商品吧!");
			}
			
		}
	});
	return flag;
}








