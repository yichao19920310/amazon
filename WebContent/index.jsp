
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊-首页</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	
	<div id="middle">
		<div class="p_left">
			<!--商品分类-->
			<%@ include file="index_product_sort.jsp"%>
			<!--商品分类结束-->

			<div class="pre_look">
				<h3>最近浏览</h3>
				<dl>
					<%-- 倒序行不通...<c:set var="startIndex" value="${fn:length(historyMap)-1 }"></c:set> 
					<c:forEach items="${historyMap}" var="temp" end="3" varStatus="status">
						<dt>
							<img style="width: 54px; height: 54px;" src="${historyMap[startIndex-status.index].value.hp_file_name }" />
						</dt>
						<dd>
							<a href="doAction?action=productView&pId=${historyMap[startIndex-status.index].value.hp_id }">${historyMap[startIndex - status.index].value.hp_name }</a>
						</dd>
					</c:forEach> --%>
					<c:forEach items="${historyMap}" var="temp" end="3">
						<dt>
							<img style="width: 54px; height: 54px;" src="${temp.value.hp_file_name }" />
						</dt>
						<dd>
							<a href="doAction?action=productView&pId=${temp.value.hp_id }">${temp.value.hp_name }</a>
						</dd>
					</c:forEach>
				
				</dl>
			</div>
		</div>

		<div class="p_center">
			<div id="wrapper">
				<div id="focus">
					<ul>
						<li><a href="#"><img src="images/T1.jpg" /></a></li>
						<li><a href="#"><img src="images/T2.jpg" /></a></li>
						<li><a href="#"><img src="images/T3.jpg" /></a></li>
						<li><a href="#"><img src="images/T4.jpg" /></a></li>
						<li><a href="#"><img src="images/T5.jpg" /></a></li>
					</ul>
				</div>
			</div>
			<div class="p_list">
				<div class="p_info">
					<img src="images/icon_sale.png"/>商品列表 
				</div>
			</div>
			<ul class="product2">
				<c:if test="${requestScope.searchPager.recordCount==0}">
					<h4>找不到您搜索的商品！</h4>
				</c:if>
				<c:set value="${requestScope.pList}" var="products"></c:set>
				<c:forEach items="${products}" var="p">
					<li>
						<dl>
							<dt>
								<a href="doAction?action=productView&pId=${p.hp_id }" target="_self"><img
									src="${p.hp_file_name }" /></a>
							</dt>
							<dd class="title">
								<a href="doAction?action=productView&pId=${p.hp_id}" target="_self">${p.hp_name }</a>
							</dd>
							<dd class="price">￥${p.hp_price}</dd>
						</dl>
					</li>

				</c:forEach>


			</ul>

			<!--分页-->
			<div class="pager">
				<c:if test="${!empty requestScope.pager}">
					<ul>
						<ul>
							<li><a href="doAction?page=${pager.prevPage }&cate=${param.cate}&hpcId=${param.hpcId}" id="lastPage" onmousedown="lastPage()">上一页</a></li>
							<c:forEach items="${requestScope.pager.groupList}" var="pl">
								<!-- 当前页不需要超链接，其他需要做成超链接 -->
								<c:if test="${pl==pager.currentPage }">
									<li>${pl}</li>
								</c:if>
								<c:if test="${pl!=pager.currentPage }">
									<li><a href="doAction?page=${pl}&cate=${param.cate}&hpcId=${param.hpcId}">${pl}</a></li> 
								</c:if>
							</c:forEach>
						<li><a href="doAction?page=${pager.nextPage}&cate=${param.cate}&hpcId=${param.hpcId}" id="nextPage" onmousedown="nextPage()">下一页</a></li>
					</ul>
				</ul>
				</c:if>
				
				<c:if test="${!empty requestScope.searchPager && requestScope.searchPager.recordCount!=0}">
					<ul>
						<ul>
							<li><a href="query?page=${searchPager.prevPage }&qname=${param.qname}" id="lastPage" onmousedown="lastPage()">上一页</a></li>
							<c:forEach items="${requestScope.searchPager.groupList}" var="pl">
								<!-- 当前页不需要超链接，其他需要做成超链接 -->
								<c:if test="${pl==searchPager.currentPage }">
									<li>${pl}</li>
								</c:if>
								<c:if test="${pl!=searchPager.currentPage }">
									<li><a href="query?page=${pl }&qname=${param.qname}">${pl}</a></li> 
								</c:if>
							</c:forEach>
							<li><a href="query?page=${searchPager.nextPage }&qname=${param.qname}" id="nextPage" onmousedown="nextPage()">下一页</a></li>
						</ul>
					</ul>
				</c:if>
				<input type="hidden" id="totalPage1"
					value="${requestScope.pager.pageCount}" /> 
				<input type="hidden" id="currentPage1"
					value="${requestScope.pager.currentPage}" />				
				<input type="hidden" id="totalPage"
					value="${requestScope.searchPager.pageCount}" /> 
				<input type="hidden" id="currentPage"
					value="${requestScope.searchPager.currentPage}" />
			</div>
		</div>

		<div id="p_right">
			<%@ include file="index_news.jsp"%>
			<%@ include file="hotproduct.jsp"%>
		</div>
	</div>

	<div id="foot">Copyright © 2016 上海海文 All Rights Reserved.</div>
</body>
</html>


