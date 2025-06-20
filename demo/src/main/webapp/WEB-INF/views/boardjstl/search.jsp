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
        <h1>Header 영역입니다. home0303.jsp입니다.</h1>
    </header>
    <hr>
    <main>
        <table border = "1">
            <tr>
                <td>\${board.title}</td>
                <td>${board.title}</td>
            </tr>
        </table>
    </main>
    <footer>
        <h1>footer 영역입니다.</h1>
    </footer>
</body>
</html>