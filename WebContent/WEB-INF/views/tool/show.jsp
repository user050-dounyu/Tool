<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String user_name = (String)request.getSession().getAttribute("user_name"); %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <title>掲示板</title>
        <link rel="stylesheet" href="<c:url value='/css/header.css' />">
    </head>
    <body>
        <header>
            <h1 id="bigTitle">投稿詳細</h1>
            <div id="userinfo">

                <div id="username">ログイン中のユーザ　<br />

                    <%= user_name %>
                        &nbsp;さん&nbsp;&nbsp;&nbsp;
                </div>
                <button id="logout" type="submit"><a href="${pageContext.request.contextPath}/logout">ログアウト</a></button>
            </div>
        </header>

        <h2>ID : ${message.getMessageId()} の投稿詳細</h2>

        <p>タイトル：<c:out value="${message.getTitle()}" /></p>
        <p>投稿内容：<c:out value="${message.getMessageContents()}" /></p>
        <p>作成日時：<fmt:formatDate value="${message.getMessageTime()}" pattern="yyyy-MM-dd HH:mm:ss" /></p>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
        <p><a href="${pageContext.request.contextPath}/edit?id=${message.getMessageId()}">この投稿を編集する</a></p>

    </c:param>
</c:import>