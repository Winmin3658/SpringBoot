<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
    <h2>READ</h2>
    <form:form modelAttribute="board">
        <form:hidden path="no" />
        <table>
            <tr>
                <td>Title</td>
                <td><form:input path="title" readonly="true" /></td>
            </tr>
            <tr>
                <td>Writer</td>
                <td><form:input path="writer" readonly="true" /></td>
            </tr>
            <tr>
                <td>Content</td>
                <td><form:textarea path="content" readonly="true" /></td>
            </tr>
        </table>
    </form:form>
    <div>
        <button type="submit" id="btnModify">Modify</button>
        <button type="submit" id="btnRemove">Remove</button>
    </div>
</main>

<%-- 푸터 영역 --%>
<%@ include file="./footer.jsp" %>

<script>
    $(document).ready(function() { var formObj = $("#board"); console.log(formObj);
        $("#btnModify").on("click", function() {
            var boardNo = $("#no");
            var boardNoVal = boardNo.val();
            self.location = "/board/modify?no=" + boardNoVal;
        });
        $("#btnRemove").on("click", function() { 
            formObj.attr("action", "/board/remove"); 
            formObj.submit();
        });
        $("#btnList").on("click", function() { 
            self.location = "/board/list";
        });
    });
</script>