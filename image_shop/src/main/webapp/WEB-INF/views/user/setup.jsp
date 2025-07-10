<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>setup</title>
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
    <div align="center">
        <h2>
            <spring:message code="user.header.register" />
        </h2>
        <form:form modelAttribute="member" action="/user/setup" method="post">
            <table>
                <tr>
                    <td>
                        <spring:message code="user.userId" />
                    </td>
                    <td>
                        <form:input path="userId" />
                    </td>
                    <td>
                        <font color="red">
                            <form:errors path="userId" />
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <spring:message code="user.userPw" />
                    </td>
                    <td>
                        <form:input path="userPw" />
                    </td>
                    <td>
                        <font color="red">
                            <form:errors path="userPw" />
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <spring:message code="user.userName" />
                    </td>
                    <td>
                        <form:input path="userName" />
                    </td>
                    <td>
                        <font color="red">
                            <form:errors path="userName" />
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
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script>
        $(document).ready(function () {
            $("#btnList").on("click", function () {
                self.location = "/user/list";
            });
        });
    </script>
</body>

</html>