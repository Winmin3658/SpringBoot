<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%-- Manager 영역 --%>
<%
// 지역 객체 참조 변수
Date date = new Date();
DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.KOREA);
String serverTime = df.format(date);
%>
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
        <h2>현재 한국시간은 <%= serverTime %></h2>
    </main>
    <footer>
        <h1>footer 영역입니다.</h1>
    </footer>
</body>
</html>