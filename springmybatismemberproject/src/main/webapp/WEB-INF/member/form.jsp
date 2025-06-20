<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="./header.jsp"%>
<!-- 화면영역 -->
<main>
	<h2>List</h2>
	<a href="registerForm">게시판입력</a>
	<table border="1">
		<tr>
			<th align="center" width="80">NO</th>
			<th align="center" width="320">ID</th>
			<th align="center" width="100">NAME</th>
			<th align="center" width="180">REGDATE</th>
		</tr>

		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">List is empty.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="member">
					<tr>
						<td align="center">${member.no}</td>
						<td align="left"><a
							href="/member/read?no=${member.no}">${member.id}</a></td>
						<td align="right">${member.name}</td>
						<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${member.regDate}" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>
</main>
<%@ include file="./footer.jsp"%>