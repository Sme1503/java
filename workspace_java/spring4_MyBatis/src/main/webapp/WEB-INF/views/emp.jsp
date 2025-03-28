<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<th>job</th>
				<th>mgr</th>
				<th>hiredate</th>
				<th>sal</th>
				<th>comm</th>
				<th>deptno</th>
			</tr>

			<c:forEach var="emp" items="${emplist }">

				<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.mgr }</td>
					<td>${emp.hiredate }</td>
					<td>${emp.sal }</td>
					<td>${emp.comm }</td>
<%-- 					<c:if test="${empty emp.comm }"> --%>
<!-- 						<td>0</td> -->
					
<%-- 					</c:if> --%>
					
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${empty emp.comm }"> --%>
<!-- 							<td>0</td> -->
<%-- 						</c:when> --%>
<%-- 						<c:when test="${not empty emp.comm }"> --%>
<!-- 							<td>0</td> -->
<%-- 						</c:when> --%>
						
<%-- 					</c:choose> --%>
					
					
					
					<td>${emp.deptno }</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>