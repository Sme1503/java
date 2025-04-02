<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp 테이블</title>
</head>
<body>

	<form action="searchEmpList" method="get">

		<!-- ${param.ename} : 검색창에 검색한 문자표시 -->
		<%-- 		<input type="text" name="ename" value="${param.ename}"> --%>

		<select id="select1" name="type">
			<option value="ename">ename</option>
			<option value="sal">sal(이상)</option>
			<option value="ej">ename + job</option>
		</select> 
		<input type="text" name="keyword" value="${dto.keyword}"> 
		<input type="submit" value="찾기">
	</form>
	
	<select id="select" name="type">
			<option value="ename">ename</option>
			<option value="sal">sal(이상)</option>
			<option value="ej">ename + job</option>
	</select> 
	<input id="keyword" type="text" name="keyword" value="${dto.keyword}">
	<button type="button" id="btn_s">찾기-ajax</button>

	<div id="div">

		<table border="1px solid dark">

			<tbody>

				<tr>
					<th>empno</th>
					<th>ename</th>
					<!-- 				<th>job</th> -->
					<!-- 				<th>mgr</th> -->
					<!-- 				<th>hiredate</th> -->
					<th>sal</th>
					<!-- 				<th>comm</th> -->
					<!-- 				<th>deptno</th> -->
				</tr>

				<c:if test="${not empty list }">
					<c:forEach var="dto" items="${list }">

						<tr>
							<td><a href="detailEmp?empno=${dto.empno }">${dto.empno }</a>
							</td>
							<td>${dto.ename }</td>
							<%-- 					<td>${dto.job }</td> --%>
							<%-- 					<td>${dto.mgr }</td> --%>
							<%-- 					<td>${dto.hiredate }</td> --%>
							<td>${dto.sal }</td>
							<%-- 					<td>${dto.comm }</td> --%>
							<%-- 					<td>${dto.deptno }</td> --%>
						</tr>
					</c:forEach>
				</c:if>

				<c:if test="${empty list }">
					<tr>
						<td colspan="3">조회 결과가 없습니다</td>
					</tr>
				</c:if>
			</tbody>

		</table>
	</div>
	<a href="insertEmp"><button type="button">추가-insert</button></a>
	<a href="joinEmp"><button type="button">추가-join</button></a>

	<button type="button" id="btn">진동</button>
	<div id="view"></div>

	<style>
#popup {
	border: 1px solid red;
	width: 100px;
	height: 200px;
	position: absolute;
	top: 50px;
	left: 300px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0, 4);
}

#popup .title {
	background: blue;
	color: white;
}

#popup .title:hover {
	cursor: all-scroll;
}

#popup .title:hover {
	cursor: all-scroll;
}

#popup .content {
	background: white;
}

#dim {
	position: absolute;
	top: 0; left; 0;
	width: 100vw;
	height: 100vh;
	background: rgba{172, 172, 172, 0.7
}
;
}
</style>

<!-- 		<div id="dim"> -->
<!-- 			<div id="popup"> -->
<!-- 				<div class="title">제목</div> -->
<!-- 				<div class="content"> -->
<!-- 					내용 <br> 내용 -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

	<script>
// 		document.querySelector('#btn').addEventListener('click', ()=> {
// 			navigator.vibrate(500);     // ms 진동한다
// 		})
		
// 		if(screen.orientation) {
// 			screen.orientation.addEventListener('change', ()=> {})
// 				document.querySelector('#view').innerHTML = `
// 					type: \${screen.orientation.type}<br>
// 					angle: \${screen.orientation.angle}<br>
// 					orientation: \${window.orientation}
// 				`
// 		} else {
// 			alert('방향 지원 안함');
// 		}
		
// 		let isDragable = false;
// 		let offsetX = 0;
// 		let offsety = 0;
		
// 		document.querySelector('.title').addEventListener('mousedowm', (event)=> {
// 			isDragable = true;	
			
// 			document.querySelector('#view').innerHTML = `
// 				x: \${event.clientX}<br>
// 				y: \${event.clientY}<br>
// 			`
			
// 			offsetX = event.clientX;
// 			offsetY = event.clientY;
			
// 		})
// 		document.querySelector('.title').addEventListener('mouseup]]', ()=> {
// 			isDragable = false;			
// 		})
// 		document.querySelector('.title').addEventListener('mousemove', (event)=> {
// 			if(isDragable){
// 				let diff_X = event.clientX - offsetX
// 				let diff_Y = event.clientY - offsetY
				
// 				let popup = document.querySelector('#popup')
				
// // 				console.log(document.querySelector('#popup').style.top)
// 				console.log(popup.offsetTop)
				
// 				popup.style.top = (popup.offsetTop + diff_Y) + 'px'
// 				popup.style.left = (popup.offsetLeft + diff_x) + 'px'
				
// 				offsetX = evnet.clientX;
// 				offsetY = event.clientY;
// 			} 	
// 		})
		
		
		// ajax로 검색
		
		
		document.querySelector('#btn_s').addEventListener('click', function(){
			
		
			let select = document.querySelector('#select').value;
// 			let select_option = select.options[select.selectedIndex].value;
			console.log(select)
			
			// data
			let param = {
				type : document.querySelector('#select').value,
				keyword : document.querySelector('#keyword').value
			}
			
			console.log("param : ", param)
			
			const xhr = new XMLHttpRequest()
			xhr.open('get', 'searchEmpList1')
			xhr.setRequestHeader('Content-Type', 'application/json')
			xhr.send(JSON.stringify(param));
			xhr.onload = function() {
				console.log(xhr.reponseText)
				
				const list = JSON.parse(xhr.responseText)
				console.log(list)
				
				const div = document.querySelector('#div')
				div.innerHTML = ""
				
					let html = ``
					
					html += `<table border="1px solid dark">`

						html +=		`<tbody>`

						html +=     `<tr>`
						html +=		`<th>empno</th>`
						html +=		`<th>ename</th>`
								
						html +=		`<th>sal</th>`
								
						html +=     `</tr>`
						
					for(let dto of list) {
						
						html +=     `<tr>`
						html +=     `<td>\${dto.empno}</td>`
						html +=     `<td>\${dto.ename}</td>`
						html +=     `<td>\${dto.sal}</td>`
						html +=     `</tr>`
					}	
						html +=` </tbody>`

						html +=` </table>`
					
		 			div.innerHTML = html
					console.log("html", html);
					console.log("div", div);
					
		/*			html +=	`<c:if test="${not empty list }">`
					html +=		`<c:forEach var="dto" items="${list }">`

					html +=			`<tr>`
					html +=			`<td><a href="detailEmp?empno=${dto.empno }">${dto.empno }</a>`
					html +=			`</td>`
					html +=		`<td>${dto.ename }</td>`
										
					html +=			`<td>${dto.sal }</td>`
										
					html +=		`</tr>`
					html +=	`</c:forEach>`
					html +=	`</c:if>`

					html +=`	<c:if test="${empty list }">`
					html +=		`<tr>`
					html +=		`	<td colspan="3">조회 결과가 없습니다</td>`
					html +=	`</tr>`
					html +=	`</c:if>` */
					
						
					
			}
		})
		
		
	</script>


</body>
</html>