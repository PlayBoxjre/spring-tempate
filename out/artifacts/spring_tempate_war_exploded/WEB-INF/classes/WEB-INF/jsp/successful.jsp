<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\2\4 0004
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Home</title>
    <link href="<spring:theme code="styleSheet"/>" rel="stylesheet" type="text/css"/>
</head>
<body style="background-image: url('<spring:theme code="background"/>');">
    <p> upload success ${fileName}</p>

</body>
</html>
