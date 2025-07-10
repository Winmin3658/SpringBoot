<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
        <div align="right">
            <table>
                <tr>
                    <sec:authorize access="isAuthenticated()">
                        <td width="80"><a href="/">
                                <spring:message code="header.home" />
                            </a></td>
                    </sec:authorize>
                    <td width="80">
                        <a href="/codegroup/register">
                            <spring:message code="header.joinMember" />
                        </a>
                    </td>

                    <td width="120">
                        <a href="/codegroup/list">
                            <spring:message code="menu.codegroup.list" />
                        </a>
                    </td>
                    <td width="120">
                        <a href="/codedetail/list">
                            <spring:message code="menu.codedetail.list" />
                        </a>
                    </td>
                    <!-- 회원 관리를 메뉴에 추가한다.-->
                    <td width="120"><a href="/user/list">
                            <spring:message code="menu.user.admin" />
                        </a>
                    </td>
                </tr>
            </table>
        </div>
        <hr>