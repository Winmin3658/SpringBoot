<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
    <h3>게시글 등록 : 로그인한 회원만 접근 가능</h3>
    <form action="/logout" method="post">
    <sec:csrfInput />
    <button>로그아웃</button>
    </form>
</main>

<%-- 푸터 영역 --%>
<%@ include file="./footer.jsp" %>
