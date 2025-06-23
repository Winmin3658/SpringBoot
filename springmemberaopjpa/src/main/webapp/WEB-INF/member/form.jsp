<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="./header.jsp" %>
<!-- 화면영역 -->
    <main>
        <form action="/board/registerMultipleSelect01" method="post">
            dateOfBirth: <input type="text" name="dateOfBirth" /><br> <input
            type="submit" value="registerDate01">
        </form>
        <form action="/board/registerMultipleSelect01" method="post"
            enctype="multipart/form-data">
            userId: <input type="text" name="userId" value="hong"><br>
            password: <input type="text" name="password" value="1234"><br>
            <input type="file" name="pictureList[0]"> <br> 
            <input type="file" name="pictureList[1]"> <input type="submit">
        </form>
    </main>
<%@ include file="./footer.jsp" %>