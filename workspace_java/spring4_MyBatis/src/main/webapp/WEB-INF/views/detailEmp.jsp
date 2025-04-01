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

				<tr>
					<td>${dto.empno }</td>
					<td>${dto.ename }</td>
					<td>${dto.job }</td>
					<td>${dto.mgr }</td>
					<td>${dto.hiredate }</td>
					<td>${dto.sal }</td>
					<td>${dto.comm }</td>
					<td>${dto.deptno }</td>
				</tr>

		</tbody>

	</table>
	
	<a href="modifyEmp_form?empno=${dto.empno }"><button type="button">수정하기-form</button></a>
	<a href="modifyEmp?empno=${dto.empno }"><button type="button">수정하기-ajax</button></a>
	
	<form action="allEmp4" method="post">
		<input id="empno" type="hidden" name="empno" value="${dto.empno }">
		<input type="submit" value="삭제">
	</form>
</body>
</html>