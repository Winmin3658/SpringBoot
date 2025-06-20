<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>

<main>
	<h2>MODIFY</h2>
	<form:form modelAttribute="member" action="modify">
		<form:hidden path="memberNo" />
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="memberID" /></td>
				<td><font color="red"><form:errors path="memberID" /></font></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:input path="memberPW" /></td>
				<td><font color="red"><form:errors path="memberPW" /></font></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><form:textarea path="memberName" /></td>
				<td><font color="red"><form:errors path="memberName" /></font></td>
			</tr>
		</table>
	</form:form>

	<div>
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnList">List</button>
	</div>

</main>
<style>

</style>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		$("#btnModify").on("click", function() {
			formObj.attr("action", "/member/modify");
			formObj.attr("method", "post");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "/member/list";
		});
	});
</script>