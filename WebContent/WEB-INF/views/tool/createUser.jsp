<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>新規ユーザ登録ページ</title>
    </head>
    <body>
        <header>
            <h1 id="title">新規ユーザ作成</h1>
        </header>

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
            </select><br />

            <button type="submit">作成</button>
        </form>

        <br />
        <form method="POST" action="${pageContext.request.contextPath}/main">
            <button type="submit">戻る</button>
        </form>

    </body>
</html>