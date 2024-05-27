<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>

        <p>メイン画面です。</p>
        <br /><br />

        <form method="GET" action="${pageContext.request.contextPath}/newUser">
            <button type="submit">新規作成</button>
        </form>
        <br /><br />

        <form method="GET" action="${pageContext.request.contextPath}/logout">
            <button type="submit">ログアウト</button>
        </form>

    </body>
</html>