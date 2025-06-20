<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
    <h2>MODIFY</h2>
    <form:form modelAttribute="member" action="modify">
        <form:hidden path="no" />
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
    </form:form>
    <div>
        <button type="submit" id="btnModify">Modify</button>
        <button type="submit" id="btnList">List</button>
    </div>
</main>

<%-- 푸터 영역 --%>
<%@ include file="./footer.jsp" %>

<script>
  $(document).ready(function () {
    var formObj = $("#member");
    $("#btnModify").on("click", function () {
      formObj.attr("action", "/member/modify");
      formObj.attr("method", "post");
      formObj.submit();
    });
      $("#btnList").on("click", function () {
        self.location = "/member/list";
      });
  });
</script>