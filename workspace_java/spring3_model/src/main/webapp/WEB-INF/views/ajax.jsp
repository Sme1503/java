<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener('load', function() {
		const btn = document.querySelector('#btn');
		btn.addEventListener('click', function() {
			console.log('click!!');
			
			// 데이터를 json으로 전달하기
			let data = {
				id: "adbc"
// 				pw: "pw"
			}
			
			const xhr = new XMLHttpRequest();
// 			xhr.open('get', 'ui/login.do');
// 			xhr.open('post', 'ajax1');		// ajax.jsp 소스가 리턴
// 			xhr.open('post', 'ajax2');		// 글자 "ajax"가 리턴
//			xhr.open('post', 'ajax3');		// MemberDTO가 리턴
			xhr.open('post', 'ajax4');		// List가 리턴
			
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.send(JSON.stringify(data));
			
			console.log('xhr.responseText', xhr.responseText);
			xhr.onload = function() {
				console.log(xhr.responseText);
			}
		})
	})

	function ajax() {
		
	}
</script>

</head>
<body>
	ajax.jsp
	<br>
	<button type="button" id="btn">ajax 실행</button>
</body>
</html>