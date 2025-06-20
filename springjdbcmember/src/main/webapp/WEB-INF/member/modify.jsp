<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url values='/css/member/modify.css'/>" />
<script type="text/javascript" src="<c:url value='/js/member/modify.js' /> "></script>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
    <h2>MODIFY 화면입니다.</h2>
    <form:form modelAttribute="member" action="modify">
        <form:hidden path="no" />
        <table>
            <tr>
                <td>Id</td>
                <td><form:input path="id"/></td>
                <td><font color="red"><form:errors path="id" /></font></td>
            </tr>
            <tr>
                <td>Pwd</td>
                <td><form:input path="pwd"/></td>
                <td><font color="red"><form:errors path="pwd" /></font></td>
            </tr>
            <tr>
                <td>name</td>
                <td><form:input path="name"/></td>
                <td><font color="red"><form:errors path="name" /></font></td>
            </tr>
        </table>
    </form:form>
    <div>
        <button type="submit" id="btnModify">Modify</button>
        <button type="submit" id="btnList">List</button>
    </div>
</main>

<%-- 푸터 영역 --%>
<%@ include file="./footer.jsp" %>