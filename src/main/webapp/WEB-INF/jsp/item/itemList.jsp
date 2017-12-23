<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>itemList</title>
</head>
<body>
    <form action="item/findItemList.action" method="post">查询
        查询条件：
        <table style="width: 100%">
            <tr>
                <td style="text-align: center;">商品名称：<input name="itemCustom.name"></td>
                <td style="text-align: center;">商品类型：
                    <select>
                        <c:if test="${null != itemtypes}">
                            <c:forEach items="${itemtypes}" var="itemtype">
                                <option value="${itemtype.key}">${itemtype.value}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </td>
                <td style="text-align: center;"></td>
            </tr>
            <tr>
                <th width="25%">id</th>
                <th width="25%">name</th>
                <th width="25%">price</th>
                <th width="25%">操作</th>
            </tr>
            <c:if test="${items != null }">
                <c:forEach items="${items }" var="item">
                    <tr>
                        <td style="text-align: center;">${item.id }</td>
                        <td style="text-align: center;">${item.name }</td>
                        <td style="text-align: center;">${item.price }</td>
                        <td style="text-align: center;"><a href="item/editItem.action?id=${item.id}">修改</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </form>
</body>
</html>