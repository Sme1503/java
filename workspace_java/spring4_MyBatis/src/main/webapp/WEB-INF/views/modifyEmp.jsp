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

<!-- <script> -->
// 	document.querySelector('#modify').addEventListener('click', function(event) {
// 		event.preventDefault();       
// 		// vaildate 값검증하기
// 		// data
// 		let paramData = {
// 				empno: document.getElementById('empno').value,
// 				ename: document.getElementById('ename').value,
// 				job: document.getElementById('job').value,
// 				mgr: document.getElementById('mgr').value,
// 				hiredate: document.getElementById('hiredate').value,
// 				sal: document.getElementById('sal').value,
// 				comm: document.getElementById('comm').value,
// 				deptno: document.getElementById('deptno').value 
// 		}
		
// 		console.log("paramData : ", paramData);
		
// 		// ajax
// 		const xhr = XMLHttpRequest();
// 		xhr.open('put', 'allEmp');
// 		xhr.setRequestHeader('Content-Type', 'application/json')
// 		xhr.send(JSON.stringify(paramData));
// 		xhr.onload = function() {
// 			if(xhr.responseText == '1'){
// 				alert('수정 성공');
// 				location.href='allEmp';
// 			} else {
// 				alert('수정 실패');
// 			}
// 		}
		
		
		
// 	})
<!-- </script> -->
</head>
<body>

	<!-- <form action="emp" method="put"> -->

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
				<td><input id="empno" type="hidden" value="${dto.empno }">
					${dto.empno }</td>

				<td><input id="ename" type="text" value="${dto.ename }"></td>

				<td><input id="job" type="text" value="${dto.job }"></td>

				<td><input id="mgr" type="text" value="${dto.mgr }"></td>

				<td><input id="hiredate" type="date" value="${dto.hiredate }"></td>

				<td><input id="sal" type="text" value="${dto.sal }"></td>

				<td><input id="comm" type="text" value="${dto.comm }"></td>

				<td><input id="deptno" type="text" value="${dto.deptno }"></td>

			</tr>

		</tbody>

	</table>
<%-- 	<input type="hidden" value="${emplist[0].empno }"> --%>
	<input id="modify" type="button" value="확인">
	<!-- </form> -->
</body>

<script>
	document.querySelector('#modify').addEventListener('click', function(event) {
		event.preventDefault();       
		// vaildate 값검증하기
		// data
		let paramData = {
				empno: document.getElementById('empno').value,
				ename: document.getElementById('ename').value,
				job: document.getElementById('job').value,
				mgr: document.getElementById('mgr').value,
				hiredate: document.getElementById('hiredate').value,
				sal: document.getElementById('sal').value,
				comm: document.getElementById('comm').value,
				deptno: document.getElementById('deptno').value 
		}
		
		console.log("paramData : ", paramData);
		
		// ajax
		const xhr = new XMLHttpRequest();
		xhr.open('put', 'allEmp1');
		xhr.setRequestHeader('Content-Type', 'application/json')
		xhr.send(JSON.stringify(paramData));
		xhr.onload = function() {
			if(xhr.responseText == '1'){
				alert('수정 성공');
				location.href='allEmp';
			} else {
				alert('수정 실패');
			}
		}
		
		
		
	})
</script>

</html>