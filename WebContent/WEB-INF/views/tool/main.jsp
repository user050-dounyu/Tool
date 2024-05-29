<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String user_name = (String)request.getSession().getAttribute("user_name"); %>
<% int auth_id = (int)request.getSession().getAttribute("auth_id"); %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <title>メイン画面</title>
        <link rel="stylesheet" href="<c:url value='/css/main.css' />">
        <link rel="stylesheet" href="<c:url value='/css/header.css' />">
    </head>
    <body>
    <header>
    <h1 id="bigTitle">トップページ</h1>
    <div id="userinfo">

        <div id="username">ログイン中のユーザ　<br />

        <%= user_name %>
                    &nbsp;さん&nbsp;&nbsp;&nbsp;
        </div>
        <% if(auth_id == 1){ %>
            <form method="GET" action="${pageContext.request.contextPath}/newUser">
                <button class="newuser" type="submit">新規ユーザ作成</button><br /><br />
            </form>
        <% } %>
        <button id="logout" type="submit"><a href="${pageContext.request.contextPath}/logout">ログアウト</a></button>
    </div>
    </header>

    <div id="wrapper">
        <aside class="bookmark">
            <h3 class="title">ブックマーク一覧</h3>
                <ul class="category">
                    <li>野球</li>
                    <li>動物</li>
                    <li>バレーボール</li>
                </ul>
        </aside>
        <div class="choice">
                <div class="talk">
                    <img src="images/talk.png" alt="" width="300" height="300"><br />
                    <a class="button" id="talk"  href="${pageContext.request.contextPath}/talk">雑談</a>
                </div>
                <div class="question">
                    <img src="images/question.png" alt=""   width="300" height="300"><br />
                    <a class="button" id="question" href="${pageContext.request.contextPath}/question">相談</a>
                </div>
        </div>
    </div>
</body>
    </c:param>
</c:import>
