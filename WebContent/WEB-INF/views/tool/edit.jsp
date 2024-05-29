<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String user_name = (String)request.getSession().getAttribute("user_name"); %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <title>編集ページ</title>
            <link rel="stylesheet" href="<c:url value='/css/header.css' />">
    </head>
    <body>
        <header>
            <h1 id="bigTitle">投稿編集ページ</h1>
            <div id="userinfo">

                <div id="username">ログイン中のユーザ　<br />

                    <%= user_name %>
                        &nbsp;さん&nbsp;&nbsp;&nbsp;
                </div>
                <button id="logout" type="submit"><a href="${pageContext.request.contextPath}/logout">ログアウト</a></button>
            </div>
        </header>
        <h2>id : ${message.getMessageId()} の投稿編集ページ</h2>

        <form method="POST" action="${pageContext.request.contextPath}/update">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="${pageContext.request.contextPath}/main">一覧に戻る</a></p>

        <p><a href="#" onclick="confirmDestroy();">この投稿を削除する</a></p>
        <form method="POST" action="${pageContext.request.contextPath}/destroy">
            <input type="hidden" name="_token" value="${_token}" />
        </form>
        <script>
        function confirmDestroy() {
            if(confirm("本当に削除してよろしいですか？")) {
                document.forms[1].submit();
            }
        }
        </script>

    </c:param>
</c:import>