<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp 테이블</title>
</head>
<body>

	<table border="1px solid dark">

		<tbody>
		
			<tr>
				<th>empno</th>
				<th>ename</th>
<!-- 				<th>job</th> -->
<!-- 				<th>mgr</th> -->
<!-- 				<th>hiredate</th> -->
<!-- 				<th>sal</th> -->
<!-- 				<th>comm</th> -->
<!-- 				<th>deptno</th> -->
			</tr>

			<c:if test="${not empty list }">
			<c:forEach var="dto" items="${list }">

				<tr>
					<td> <a href="detailEmp?empno=${dto.empno }">${dto.empno }</a>
					</td>
					<td>${dto.ename }</td>
<%-- 					<td>${dto.job }</td> --%>
<%-- 					<td>${dto.mgr }</td> --%>
<%-- 					<td>${dto.hiredate }</td> --%>
<%-- 					<td>${dto.sal }</td> --%>
<%-- 					<td>${dto.comm }</td> --%>
<%-- 					<td>${dto.deptno }</td> --%>
				</tr>
			</c:forEach>
			</c:if>
			
			<c:if test="${empty list }">
				<tr>
					<td colspan = "2"> 조회 결과가 없습니다</td>
				</tr>
			</c:if>
		</tbody>

	</table>
</body>
</html>