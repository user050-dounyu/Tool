<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <title>メイン画面</title>
        <link rel="stylesheet" href="<c:url value='/css/main.css' />">
    </head>
    <body>
    <header>
    <h1 id="bigTitle">トップページ</h1>
    <div id="userinfo">
        <div id="username">ログイン中のユーザ　<br />
        田中　太郎 </div>
        <button id="logout" type="submit"><a href="./index.html">ログアウト</a></button>
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
                    <a class="button" id="talk"  href="./talk.html">雑談</a>
                </div>
                <div class="question">
                    <img src="images/question.png" alt=""   width="300" height="300"><br />
                    <a class="button" id="question" href="./question.html">相談</a>
                </div>
        </div>
    </div>
</body>
    </c:param>
</c:import>
