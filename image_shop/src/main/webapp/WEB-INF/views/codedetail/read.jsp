<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>read</title>
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
        <spring:message code="codedetail.header.read" />
    </h2>
    <form:form modelAttribute="codeDetail" id="codeDetail">
        <table>
            <tr>
                <td>
                    <spring:message code="codedetail.groupCode" />
                </td>
                <td>
                    <form:select path="groupCode" items="${groupCodeList}" itemValue="value" itemLabel="label" disabled="true" id="groupCode"/>
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
                    <form:input path="codeValue" readonly="true" id="codeValue"/>
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
                    <form:input path="codeName" readonly="true" />
                </td>
                <td>
                    <font color="red">
                        <form:errors path="codeName" />
                    </font>
                </td>
            </tr>
        </table>
    </form:form>
    <div>
        <button type="button" id="btnEdit">
            <spring:message code="action.edit" />
        </button>
        <button type="button" id="btnRemove">
            <spring:message code="action.remove" />
        </button>
        <button type="button" id="btnList">
            <spring:message code="action.list" />
        </button>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script>
        $(document).ready(function () {
            var formObj = $("#codeDetail");
            $("#btnEdit").on("click", function () {
                var groupCode = $("#groupCode");
                var groupCodeVal = groupCode.val();
                var codeValue = $("#codeValue");
                var codeValueVal = codeValue.val();
                self.location = "modify?groupCode=" + groupCodeVal + "&" + "codeValue=" + codeValueVal;
            });
            $("#btnRemove").on("click", function () {
                if (!confirm("정말로 삭제하시겠습니까?")) {
                    return;
                }
                formObj.attr("action", "remove");
                formObj.attr("method", "post");
                formObj.submit();
            });
            $("#btnList").on("click", function () {
                self.location = "list";
            });
        });
    </script>
</body>

</html>