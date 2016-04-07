<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <%--FAVICON--%>

        <%--Jquery--%>
        <c:url value="/webjars/jquery/2.1.4/jquery.min.js" var="jquery"/>
            <script src="${jquery}"></script>
        <%--Bootstrap--%>
        <%--<c:url value="/webjars/bootstrap/3.3.4/css/bootstrap.min.css" var="bootstrapCSS"/>--%>
            <%--<link rel="stylesheet" href="${bootstrapCSS}" media="screen"--%>

        <%--BOOTWATCH--%>
        <c:url value="/static/css/bootswatch_simplex.css" var="bootstrapCSS"/>
            <link rel="stylesheet" href="${bootstrapCSS}" media="screen"/>

        <c:url value="/webjars/bootstrap/3.3.4/js/bootstrap.js" var="bootstrapJS"/>
            <script src="${bootstrapJS}"></script>

        <%--font-awesome--%>
        <c:url value="/webjars/font-awesome/4.5.0/css/font-awesome.css" var="fontawesomeCSS"/>
            <link rel="stylesheet" href="${fontawesomeCSS}" media="screen"/>

        <%--custom CSS--%>
        <c:url value="/static/css/astonengineer.css" var="customCSS"/>
            <link rel="stylesheet" href="${customCSS}" media="screen"/>

        <%--custom JS --%>
        <c:url value="/static/js/common.js" var="commonJS"/>
            <script src="${commonJS}"></script>

        <title>Aston Technologies HR Application</title>
    </head>
    <body>

