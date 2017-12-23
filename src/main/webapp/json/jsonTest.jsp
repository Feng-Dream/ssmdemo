<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/18
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Json数据交互测试</title>
    <base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        //请求json，输出json
        function requestJson() {
            console.log("开始");
            $.ajax({
                type: 'post',
                url: 'requestJson.action',
                contentType: 'application/json;charset=utf-8',
                //数据格式是json串
                data: '{"name":"数码相机","price":66666}',
                success: function (data) {//返回json结果
                    alert(data.name + " " + data.price);
                },
                error: function () {
                    alert("请求错误");
                },
                dataType: 'json'
            });
            console.log("结束");
        }

        //请求key/value,输出json
        function responseJson() {
            console.log("开始");
            $.ajax({
                type: 'post',
                url: 'responseJson.action',
                //contentType: 'application/json;charset=utf-8',
                //数据格式是key/value
                data: 'name=苹果笔记本电脑&price=99999',
                success: function (data) {//返回json结果
                    alert(data.name + " " + data.price);
                },
                error: function () {
                    alert("请求错误");
                },
                dataType: 'json'
            });
            console.log("结束");
        }
    </script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json，输出json">
<input type="button" onclick="responseJson()" value="请求key/value,输出json">
</body>
</html>
