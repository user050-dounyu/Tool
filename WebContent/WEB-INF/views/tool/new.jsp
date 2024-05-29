<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String user_name = (String)request.getSession().getAttribute("user_name"); %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <title>新規投稿ページ</title>
        <link rel="stylesheet" href="<c:url value='/css/header.css' />">
    </head>
    <body>
        <header>
            <h1 id="bigTitle">新規投稿ページ</h1>
            <div id="userinfo">

                <div id="username">ログイン中のユーザ　<br />

                    <%= user_name %>
                        &nbsp;さん&nbsp;&nbsp;&nbsp;
                </div>
                <button id="logout" type="submit"><a href="${pageContext.request.contextPath}/logout">ログアウト</a></button>
            </div>
        </header>

        <form method="POST" action="${pageContext.request.contextPath}/create">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="${pageContext.request.contextPath}/main">メイン画面に戻る</a></p>

    </c:param>
</c:import>