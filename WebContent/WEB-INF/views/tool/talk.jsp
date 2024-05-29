<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String user_name = (String)request.getSession().getAttribute("user_name"); %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <title>雑談掲示板</title>
            <link rel="stylesheet" href="<c:url value='/css/header.css' />">
    </head>
    <body>
        <header>
            <h1 id="bigTitle">雑談掲示板一覧</h1>
            <div id="userinfo">

                <div id="username">ログイン中のユーザ　<br />

                    <%= user_name %>
                        &nbsp;さん&nbsp;&nbsp;&nbsp;
                </div>
                <button id="logout" type="submit"><a href="${pageContext.request.contextPath}/logout">ログアウト</a></button>
            </div>
        </header>
        <h2>投稿一覧</h2>
        <ul>
            <c:forEach var="message" items="${messages}">
                <li>
                    <a href="${pageContext.request.contextPath}/show?id=${message.getMessageId()}">
                        <c:out value="ID: ${message.getMessageId()}" />
                    </a><br />
                    タイトル：<c:out value="${message.getTitle()}"></c:out>/投稿時間：<c:out value="${message.getMessageTime()}" />
                    /投稿者：<c:out value="${message.getUserName()}"></c:out>

                    <p><c:out value="${message.getMessageContents()}" /></p>
                </li>
            </c:forEach>
        </ul>

        <p><a href="${pageContext.request.contextPath}/new">新規投稿</a></p>

    </body>

    </c:param>
</c:import>