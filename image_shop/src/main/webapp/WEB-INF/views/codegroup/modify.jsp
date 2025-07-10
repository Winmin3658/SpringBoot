<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>modify</title>
<style>
    body {
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue",
            "Malgun Gothic", Arial, "Noto Sans KR", "Apple SD Gothic Neo", sans-serif;
        font-size: 16px;
        line-height: 1.6;
        color: #333;
        margin: 20px;
    }
</style>
</head>

<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<jsp:include page="/WEB-INF/views/common/menu.jsp" />
<h2>
    <spring:message code="codegroup.header.modify" />
</h2>
<form:form modelAttribute="codeGroup" action="/codegroup/modify" method="post" id="codeGroup" >
    <table>
        <tr>
            <td>
                <spring:message code="codegroup.groupCode" />
            </td>
            <td>
                <form:input path="groupCode" readonly="true" id="groupCode"/>
            </td>
            <td>
                <font color="red">
                    <form:errors path="groupCode" />
                </font>
            </td>
        </tr>
        <tr>
            <td>
                <spring:message code="codegroup.groupName" />
            </td>
            <td>
                <form:input path="groupName" />
            </td>
            <td>
                <font color="red">
                    <form:errors path="groupName" />
                </font>
            </td>
        </tr>
    </table>
<div>
    <button type="submit" id="btnModify">
        <spring:message code="action.modify" />
    </button>
    <button type="button" id="btnList">
        <spring:message code="action.list" />
    </button>
</div>
</form:form>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />

<script>
    $(document).ready(function() {
        $("#btnModify").on("click", function() {
            if(!confirm("정말로 수정하시겠습니까?")) {
                return false;
            }
        });
        $("#btnList").on("click", function() {
            self.location = "list";
        });
    });
</script>
</body>

</html>