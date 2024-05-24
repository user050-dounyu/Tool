<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロトタイプ_ログイン画面</title>
<link rel="stylesheet" href='/css/index.css'>
</head>
<body style="margin-top:0px; margin-right:0px; margin-left:0px; margin-bottom:0px;">
    <div id="home" class="home">
        <header>
            <h1 id="title">ログイン画面</h1>
        </header>

        <div id="wrapper">
            <div id="main">
                <label for="user_id">ID</label><br />
                <input type="text" name="user_id" id="user_id" value="${user_id}" />
                <br /><br />

                <label for="password">パスワード</label><br />
                <input type="text" name="password" id="password" value="${password}" />
                <br /><br />

                <button type="submit"><a class="button" href="${pageContext.request.contextPath}/login?id=${user_id}">ログイン</a></button>
            </div>
        </div>
     </div>
</body>
</html>