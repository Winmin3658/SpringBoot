<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="linkToCSS" />
    </head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <body>
        <header>
            <h1>home 페이지입니다</h1>
            <P>서버의 시간은 ${serverTime} 입니다.</P>
            ${userInfo.userId} <br />
            ${userInfo.userName} <br />
        </header>
    </body>
</html>