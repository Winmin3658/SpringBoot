<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 화면 영역 --%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <header>
        <h1>Header 영역입니다. home0901.jsp입니다.</h1>
    </header>
    <hr>
    <main>
        <c:import url="/boardjstl/search">
            <c:param name="keyword" value="orange" />
        </c:import>
        <a href="http://localhost:8080/boardjstl/search?title=orange">/boardjstl/search?title=orange</a>
        <br> <br>
        <form action="/boardjstl/search" method="get">
            <input type="text" name="title" value="orange">
            <input type="submit" value="전송">
        </form>
    </main>
    <footer>
        <h1>footer 영역입니다.</h1>
    </footer>
</body>
</html>