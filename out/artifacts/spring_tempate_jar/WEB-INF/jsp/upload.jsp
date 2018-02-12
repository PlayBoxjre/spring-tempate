<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\2\12 0012
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form id="upload"  method="post" enctype="multipart/form-data" >
    <input id="name" type="text" placeholder="姓名"/>
    <input id="file" type="file" />
    <input type="submit" value="上传"/>
</form>
</body>

