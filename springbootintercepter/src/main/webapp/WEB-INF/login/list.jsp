<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>
<!-- 화면 영역 -->
<main>
    <h3>회원 목록</h3>
  <a href="register">New</a>
  <table border="1">
    <tr>
      <th align="center" width="60">NO</th>
      <th align="center" width="80">ID</th>
      <th align="center" width="50">PW</th>
      <th align="center" width="50">NAME</th>
      <th align="center" width="180">REGDATE</th>
    </tr>
    <c:forEach items="${list}" var="member">
      <tr>
        <td align="center">${member.no}</td>
        <td align="center">
          <a href="/member/read?no=${member.no}">${member.id}</a>
        </td>
        <td align="left">${member.pw}</td>
        <td align="right">${member.name}</td>
        <td align="center">
          <fmt:formatDate
            pattern="yyyy-MM-dd HH:mm"
            value="${member.regDate}"
          />
        </td>
      </tr>
    </c:forEach>
  </table>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>