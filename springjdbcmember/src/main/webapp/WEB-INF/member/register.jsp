<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
    <h2>Member input 화면입니다.</h2>
    
    <form:form modelAttribute="member" action="register" id="member">
        <table>
            <tr>
                <td>Id</td>
                <td><form:input path="id"  name="id" value="id"/></td>
                <td><font color="red"><form:errors path="id" /></font></td>
            </tr>
            <tr>
                <td>Pwd</td>
                <td><form:input path="pwd" /></td>
                <td><font color="red"><form:errors path="pwd" /></font></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input path="name" /></td>
                <td><font color="red"><form:errors path="name" /></font></td>
            </tr>
        </table>

        <div>
            <button type="button" id="btnRegister">멤버 가입</button>
            <button type="button" id="btnList">가입 멤버 전체 출력</button>
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
