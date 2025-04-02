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
		<input type="submit" id="join" value="등록하기">
	

	<script>
	document.querySelector('#join').addEventListener('click', function(event) {
		event.preventDefault();       
		// vaildate 값검증하기
		// data
		let param = {
				empno: document.getElementById('empno').value,
				ename: document.getElementById('ename').value,
				job: document.getElementById('job').value,
				mgr: document.getElementById('mgr').value,
				hiredate: document.getElementById('hiredate').value,
				sal: document.getElementById('sal').value,
				comm: document.getElementById('comm').value,
				deptno: document.getElementById('deptno').value 
		}
		
		console.log("param : ", param);
		
		if(param.empno.trim().length == 0) {
			alert('empno는 필수입니다')
		} else if(param.ename.trim().length == 0) {
			alert('ename는 필수입니다')
		} else if(param.job.trim().length == 0) {
			alert('job는 필수입니다')
		} else if(param.mgr.trim().length == 0) {
			alert('mgr는 필수입니다')
		} else if(param.hiredate.trim().length == 0) {
			alert('hiredate는 필수입니다')
		} else if(param.sal.trim().length == 0) {
			alert('sal는 필수입니다')
		} else if(param.comm.trim().length == 0) {
			alert('comm는 필수입니다')
		} else if(param.deptno.trim().length == 0) {
			alert('deptno는 필수입니다')
		}
		
		// ajax - fetch
		fetch('joinEmp', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body : JSON.stringify(param)
		}).then(function(resp) {
			return resp.json()
		}).then((data)=> {
			console.log(data)
			if(data == 1) {
				location.href = 'allEmp'
			}
		}).catch((err)=> {
			console.error('ERROR joinEmp fetch', err)
		})
	})
			
	function promise() {
		
		let a = 10
		setTimeout( function () {
			a = 20
		}, 1000)
		console.log(a)		// 10
		// 20이 출력되게 하려면?
		
		// Promise는 resolve() 또는 reject()가 실행될 때까지 기다려준다
		let p = new Promise(function(resolve, reject) {
			setTimeout( function () {
				if(a == 10){
					a = 20
					resolve(a)					
				} else {
					reject('ERRRR')
				}
			}, 1000)
		})
		console.log(1) // 위 코드보다 먼저 실행된다
		p.then(function(data) {
			console.log(data)
		})
		p.catch(function(data) {
			console.log(data)
		})	
	}
	
	// await을 쓸려면 함수 앞에 async를 써야한다
	async function async_await() {
		await new Promise(function(resolve, reject) {
			setTimeout( function () {
				if(a == 10){
					a = 20
					resolve(a)					
				} else {
					reject('ERRRR')
				}
			}, 1000)
		})
	}
</script>

</body>

</html>