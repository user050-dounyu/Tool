<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<label for="title">タイトル（※最大100文字）</label><br />
<input type="text" name="title" id="title" value="${message.getTitle()}" />
<br /><br />

<label for="content_msg">コメント（※最大300文字）</label><br />
<input type="text" name="content" id="content_msg" value="${message.getMessageContents()}" />
<br /><br />

<label for="content_msg">カテゴリ（※最大300文字）</label><br />
<select name="authentication">
    <option value="${message.getCategoryId()}" selected><c:out value="${message.getCategoryName()}"></c:out></option>
    <c:forEach var="category" items="${categorys}">
        <option value="${category.getCategoryId()}"><c:out value="${category.getCategoryName()}"></c:out></option>
    </c:forEach>
</select>
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>