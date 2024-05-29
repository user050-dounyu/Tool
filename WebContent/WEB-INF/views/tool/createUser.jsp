<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String user_name = (String)request.getSession().getAttribute("user_name"); %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <head>
        <meta charset="UTF-8">
        <title>新規ユーザ登録ページ</title>
        <link rel="stylesheet" href="<c:url value='/css/createuser.css' />">
    </head>
    <body>
        <header>
            <h1 id="title">新規ユーザ作成</h1>
            <div id="userinfo">

                <div id="username">ログイン中のユーザ　<br />

                    <%= user_name %>
                            &nbsp;さん&nbsp;&nbsp;&nbsp;
                </div>
                <form method="GET" action="${pageContext.request.contextPath}/main">
                    <button type="submit">メイン画面に戻る</button>
                </form>
                <button id="logout" type="submit"><a href="${pageContext.request.contextPath}/logout">ログアウト</a></button>

            </div>
        </header>

        <div id="wrapper">
            <form method="POST" action="${pageContext.request.contextPath}/createuser">
                <label for="user_id">ID</label><br />
                <input type="text" name="user_id" id="user_id" />
                <br /><br />

                <label for="user_name">名前</label><br />
                <input type="text" name="user_name" id="user_name" />
                <br /><br />

                <label for="password">パスワード</label><br />
                <input type="text" name="password" id="password" />
                <br /><br />

                <label for="authentication">権限</label><br />
                <select name="authentication">
                    <option value="teatcher">講師</option>
                    <option value="general">内定者</option>
                </select>
                <br /><br />

                <button type="submit">作成</button>
            </form>

            <br />
        </div>

    </body>
    </c:param>
</c:import>