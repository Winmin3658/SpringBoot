<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <h1>Header 영역입니다. home03.jsp입니다.</h1>
    </header>
    <main>
    <h1>NAME 문자열 배열 출력</h1>
    <%
        String[] nameArray = (String[])request.getAttribute("name");
        for(String data : nameArray) {
    %>
        <p> <%= data %></p>
    <%
        }
    %>
    <h1>NAME 문자열 배열 출력</h1>
        <c:forEach var = "data" items = "${name}">
            <p> <c:out value="${data}" /></p>
        </c:forEach>
    <h1>NAME 문자열 배열 출력 첨자 형식으로 출력</h1>
        <p> ${name[0]}</p>
        <p> ${name[1]}</p>
        <p> ${name[2]}</p>

    <h1>NAMELIST 문자열 배열 출력</h1>
        <c:forEach var = "data" items = "${nameList}">
            <p> <c:out value="${data}" /></p>
        </c:forEach>
    <h1>NAMELIST 첨자 모양으로 출력</h1>
    <p> ${nameList[0]}</p>
    <p> ${nameList[1]}</p>
    <p> ${nameList[2]}</p>
    </main>
    <footer>
        <h1>footer 영역입니다.</h1>
    </footer>
</body>
</html>