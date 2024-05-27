<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>プロトタイプ_ログイン画面</title>

<link rel="stylesheet" href="<c:url value='/css/index.css' />">

</head>
<body style="margin-top:0px; margin-right:0px; margin-left:0px; margin-bottom:0px;">
    <div id="home" class="home">
        <header>
            <h1 id="title">ログイン画面</h1>
        </header>


        <form method="GET" action="${pageContext.request.contextPath}/login?id=${tool.user_id}">
        <div id="wrapper">
            <div id="main">
                <label for="user_id">ID</label><br />
                <input type="text" name="user_id" id="user_id" value="${tool.user_id}" />
                <br /><br />

                <label for="password">パスワード</label><br />
                <input type="password" name="password" id="password" value="${tool.password}" />
                <br /><br />

                <button type="submit">ログイン</button>

            </div>
        </div>
        </form>
     </div>
</body>
</html>