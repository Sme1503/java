<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<form action="allEmp3" method="post">

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
					<td><input id="empno" type="type" name="empno" value=""></td>

					<td><input id="ename" type="text" name="ename" value=""></td>

					<td><input id="job" type="text" name="job" value=""></td>

					<td><input id="mgr" type="text" name="mgr" value=""></td>

					<td><input id="hiredate" type="date" name="hiredate" value=""></td>

					<td><input id="sal" type="text" name="sal" value=""></td>

					<td><input id="comm" type="text" name="comm" value=""></td>

					<td><input id="deptno" type="text" name="deptno" value=""></td>

				</tr>

			</tbody>

		</table>
		<input type="submit" value="확인">
	</form>
</body>

</html>