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
    <h1>MemberMap(HashMap) 저장된 값 출력</h1>
    <p> id = ${memMap["id"]}</p>
    <p> pwd = ${memMap["pwd"]}</p>
    <p> email = ${memMap["email"]}</p>
    <p> name = ${memMap["name"]}</p>
    <p> date = ${memMap["date"]}</p>

    </main>
    <footer>
        <h1>footer 영역입니다.</h1>
    </footer>
</body>
</html>