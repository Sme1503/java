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

			<c:if test="${not empty emplist }">
			<c:forEach var="emp" items="${emplist }">

				<tr>
					<td> <a href="choiceempno?empno=${emp.empno }">${emp.empno }</a>
					</td>
					<td>${emp.ename }</td>
<%-- 					<td>${emp.job }</td> --%>
<%-- 					<td>${emp.mgr }</td> --%>
<%-- 					<td>${emp.hiredate }</td> --%>
<%-- 					<td>${emp.sal }</td> --%>
<%-- 					<td>${emp.comm }</td> --%>
<%-- 					<td>${emp.deptno }</td> --%>
				</tr>
			</c:forEach>
			</c:if>
			
			<c:if test="${empty emplist }">
				<tr>
					<td colspan = "2"> 조회 결과가 없습니다</td>
				</tr>
			</c:if>
		</tbody>

	</table>
</body>
</html>