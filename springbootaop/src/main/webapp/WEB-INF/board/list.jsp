<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>
<!-- 화면 영역 -->
<main>
    <h2>List</h2>
    <a href="register">게시판 입력</a>
    <table border="1">
        <tr>
            <th align="center" width="80">NO</th>
            <th align="center" width="320">TITLE</th>
            <th align="center" width="100">WRITER</th>
            <th align="center" width="180">REGDATE</th>
        </tr>
        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td colspan="4">
                    List is empty.
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="board" items="${list}">
                <tr>
                    <td align="center">${board.no}</td>
                    <td align="left"><a href="/board/read?no=${board.no}">${board.title}</a></td>
                    <td align="right">${board.writer}</td>
                    <td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regDate}" /></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>