<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
    <h2>REGISTER</h2>
    
    <form:form modelAttribute="member" action="register" id="member">
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id" /></td>
                <td><font color="red"><form:errors path="id" /></font></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:input path="pw" /></td>
                <td><font color="red"><form:errors path="pw" /></font></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:textarea path="name" /></td>
                <td><font color="red"><form:errors path="name" /></font></td>
            </tr>
        </table>

        <div>
            <button type="button" id="btnRegister">게시판입력</button>
            <button type="button" id="btnList">게시판전체출력</button>
        </div>
    </form:form>
</main>

<%-- 푸터 영역 --%>
<%@ include file="./footer.jsp" %>

<script>
    $(document).ready(function () {
        var formObj = $("#member");

        $("#btnRegister").on("click", function () {
            formObj.attr("action", "/member/register");
            formObj.attr("method", "post");
            formObj.submit();
        });

        $("#btnList").on("click", function () {
            self.location = "/member/list";
        });
    });
</script>
