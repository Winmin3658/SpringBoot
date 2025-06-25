<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="./header.jsp"%>
<!-- 화면영역 -->
<main>
	<h1>로그인</h1>
	<form method="post" action="/login">
		<div>
			<input type="text" name="userId" value="admin">
		</div>
		<div>
			<input type="password" name="userPw" value="1234">
		</div>
		<div>
			<input type="submit">
		</div>
	</form>
</main>
<%@ include file="./footer.jsp"%>