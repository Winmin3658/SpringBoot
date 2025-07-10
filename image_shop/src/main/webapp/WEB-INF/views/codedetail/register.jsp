<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>register</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
        <spring:message code="codedetail.header.register" />
    </h2>
    <form:form modelAttribute="codeDetail" action="register" method="post">
        <table>
            <tr>
                <td>
                    <spring:message code="codedetail.groupCode" />
                </td>
                <td>
                    <form:select path="groupCode" items="${groupCodeList}" itemValue="value"
                        itemLabel="label" />
                </td>
                <td>
                    <font color="red">
                        <form:errors path="groupCode" />
                    </font>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="codedetail.codeValue" />
                </td>
                <td>
                    <form:input path="codeValue" />
                </td>
                <td>
                    <font color="red">
                        <form:errors path="codeValue" />
                    </font>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="codedetail.codeName" />
                </td>
                <td>
                    <form:input path="codeName" />
                </td>
                <td>
                    <font color="red">
                        <form:errors path="codeName" />
                    </font>
                </td>
            </tr>
        </table>
        <div>
            <button type="submit" id="btnRegister">
                <spring:message code="action.register" />
            </button>
            <button type="button" id="btnList">
                <spring:message code="action.list" />
            </button>
        </div>
    </form:form>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script>
        $(document).ready(function () {
            $("#btnList").on("click", function () {
                self.location = "list";
            });
        });
    </script>
</body>

</html>