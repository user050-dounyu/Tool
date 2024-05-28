<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="title">タイトル（※最大100文字）</label><br />
<input type="text" name="title" id="title" value="${message.title}" />
<br /><br />

<label for="content_msg">コメント（※最大300文字）</label><br />
<input type="text" name="content" id="content_msg" value="${message.content}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>