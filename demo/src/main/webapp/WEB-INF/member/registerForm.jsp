<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <header>
        <h1>Header 영역입니다. RegisterForm.jsp입니다.</h1>
    </header>
    <hr>
    <main>
        <%-- <form action="/register" method="post">
            userId: <input type="text" name="userId" value="hong"><br> password: <input type="text" name="password" value="1234"><br>
            dateOfBirth: <input type="text" name="dateOfBirth" value="20001020"><br>
            <input type="submit" value="register">
        </form>
        <form action="/registerSelect" method="post">
            nationality: <select name="nationality" >
                <option value="Korea" selected>대한민국</option>
                <option value="Germany">독일</option>
                <option value="Australia">호주</option>
                <option value="Canada">캐나다</option>
            </select><br>
        <input type="submit" value="registerSelect">
        </form>
        <hr> --%>
            <form action="/member/registerFileupload" method="post" enctype="multipart/form-data">
            userId: <input type="text" name="userId" value="hong"><br>
            password: <input type="text" name="password" value="1234"><br>
            file: <input type="file" multiple="multiple" name="picture"> <br>
            <input type="submit" value="register">
        </form>
    </main>
    <hr>
    <footer>
        <h1>footer 영역입니다.</h1>
    </footer>
</body>
</html>