<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
    <h3>회원 등록</h3>
    <form:form modelAttribute="member" action="register">
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id" /></td>
                <td><font color="red"><form:errors path="id"/></font></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:input path="pw" /></td>
                <td><font color="red"><form:errors path="pw"/></font></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input path="name" /></td>
                <td><font color="red"><form:errors path="name"/></font></td>
            </tr>
        </table>
    </form:form>
    <div>
        <button type="submit" id="btnRegister">등록</button>
    </div>
</main>

<%-- 푸터 영역 --%>
<%@ include file="./footer.jsp" %>

<script>
    $(document).ready(function() {
        var formObj = $("#member");
        $("#btnRegister").on("click", function() {
            formObj.attr("action","/member/register");
            formObj.attr("method","post");
            formObj.submit();
        });
    });
</script>
