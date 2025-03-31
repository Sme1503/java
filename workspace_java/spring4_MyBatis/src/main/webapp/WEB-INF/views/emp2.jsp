<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<%-- 			<c:forEach var="emp" items="${emplist }"> --%>

				<tr>
					<td>${emplist[0].empno }</td>
					<td>${emplist[0].ename }</td>
					<td>${emplist[0].job }</td>
					<td>${emplist[0].mgr }</td>
					<td>${emplist[0].hiredate }</td>
					<td>${emplist[0].sal }</td>
					<td>${emplist[0].comm }</td>
					<td>${emplist[0].deptno }</td>
				</tr>
<%-- 			</c:forEach> --%>

		</tbody>

	</table>
</body>
</html>