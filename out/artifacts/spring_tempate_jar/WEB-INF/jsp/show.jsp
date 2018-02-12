<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\2\4 0004
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
    <h1> 这是显示提交的数据信息界面</h1>
    <hr/>
    <p>error:${error}</p>
    <p>continer:${continer}</p>
    <p>version:${version}</p>
    <P>name :${user.name}</P>
    <p>age :${user.age}</p>
</body>
</html>
