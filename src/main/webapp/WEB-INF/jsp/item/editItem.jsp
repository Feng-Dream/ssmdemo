<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
</head>
<body>
	<form action="item/editItemSubmit.action" method="post" enctype="multipart/form-data">
		<c:if test="${null != allErrors}">
			<!--显示错误信息-->
			<c:forEach items="${allErrors}"	var="error">
				<div style="color: red">${error}</div>
			</c:forEach>
		</c:if>
		<input type="hidden" name="id" value="${item.id}">
		修改商品信息:
		<table width="300">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="${item.name }"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${item.price }"></td>
			</tr>
			<tr>
				<td>商品生产日期</td>

				<td><input type="text" name="createtime" value="<fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td>
					<c:if test="${item.pic != null }">
						<img src="/pic/${item.pic }" width="100" height="100"/>
						<br/>
					</c:if>
					<input type="file" name="itemPic" />
				</td>
			</tr>
			<tr>
				<td>商品详情</td>
				<td><textarea name="detail" cols="30" rows="3">${item.detail}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="修改"></td>
			</tr>
		</table>
	</form>
</body>
</html>