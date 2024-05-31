<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>コミュニケーションツール</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper_layout">
            <div id="header">
                <h1>掲示板</h1>
                <img src="images/systems_logo.png" alt="" >
            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                by Katsuki Nagashima.
                   Tatsuhisa Suzuki.
                   Yuta Fujioka.
            </div>
        </div>
    </body>
</html>