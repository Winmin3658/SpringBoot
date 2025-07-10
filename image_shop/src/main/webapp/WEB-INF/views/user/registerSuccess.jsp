<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>registerSuccess</title>
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
        <h2><spring:message code="common.joinMemberSuccess" arguments="${userName}" /></h2>
        <a href="/auth/login"><spring:message code="action.login" /></a>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>