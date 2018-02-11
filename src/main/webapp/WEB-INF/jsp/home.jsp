<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\2\4 0004
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<form method="post"     class="form" id="home-form">
    <fieldset form="home-form"  id="home-form-filedset">
        姓名：<input id="home-name" type="text" name="home-name" placeholder="请输入你的名字" />
    <br/>
        年龄：<input id="home-age" type="text" name="home-age" placeholder="输入年龄"/>
        <br/>
        <input class="button" type="submit" value="提交" />

    </fieldset>
</form>

</body>
</html>
