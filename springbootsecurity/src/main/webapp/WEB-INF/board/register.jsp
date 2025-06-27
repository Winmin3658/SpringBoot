<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
    <h3>게시글 등록 : 로그인한 회원만 접근 가능</h3>
    <form action="/logout" method="post">
        <sec:csrfInput />
        <p>principal : <sec:authentication property="principal"/></p>
        <p>Member : <sec:authentication property="principal.member"/></p>
        <p>사용자이름 : <sec:authentication property="principal.member.name"/></p>
        <p>사용자아이디 : <sec:authentication property="principal.username"/></p>
        <p>사용자 권한 리스트 : <sec:authentication property="principal.member.authList"/></p>
        <div>
            <a href="/">HOME</a>
        </div>

        <button>로그아웃</button>
    </form>
</main>

<%-- 푸터 영역 --%>
<%@ include file="./footer.jsp" %>
