<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener('load', function () {
		const btn = document.querySelector('#btn');
		btn.addEventListener('click', function () {
			console.log('ajax 버튼 실행');
			
			let data = {
					image: document.getElementById('image').value,
					title: document.getElementById('title').value,
					author: document.getElementById('author').value,
					explanation: document.getElementById('exp').value
			}
			console.log("data", data);
			
			const xhr = new XMLHttpRequest();
			xhr.open('post', 'ajax1');
			
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.send(JSON.stringify(data));
			
			xhr.onload = function webtoonList() {
				console.log(xhr.reponseText);
				
				const list = JSON.parse(xhr.responseText);
				console.log(list);
				
				const flex_div = document.getElementById('flex_div');
				
				flex_div.innerHTML = "";
				
				for(let dto of list){
					const div = document.createElement('div');
					div.className = 'child_div';
					
						
					let html =``;
						
					
					html +=	`<table>`

					html +=	`<tbody>`

					html += `<tr>`
					html += `<td>\${dto.image}</td>`
				

					html += `</tr>`

					html += `<tr>`
					html += `<td>\${dto.title}</td>`
					html += `</tr>`

					html += `<tr>`
					html += `<td>\${dto.author}</td>`
					html += `</tr>`

					html += `<tr>`
					html += `<td>\${dto.explanation}</td>`
					html += `</tr>`
					html += `</tbody>`
					html += `</table>`
					
					
					
					div.innerHTML = html;
					console.log("html", html);
					console.log("div", div);
					
					flex_div.append(div);
					
				}
			}
		})
	})
	
	function webtoonList() {
		const list = JSON.parse(xhr.responseText);
		console.log(list);
		
		const flex_div = document.getElementById('flex_div');
		
		for(let dto of list){
			const div = document.createElement('div');
			div.className = "child_div";
			
				
			let html =``;
				
			
			html +=	`<table>`

			html +=	`<tbody>`

			html += `<tr>`
			html += `<td>\${dto1.image}</td>`
			html += `</tr>`

			html += `<tr>`
			html += `<td>\${dto.title}</td>`
			html += `</tr>`

			html += `<tr>`
			html += `<td>\${dto.author}</td>`
			html += `</tr>`

			html += `<tr>`
			html += `<td>\${dto.explanation}</td>`
			html += `</tr>`
			html += `</tbody>`
			html += `</table>`
			html += `</div>`
			
			
			div.innerHTML = html;
			console.log("html", html);
			console.log("div", div);
			
			flex_div.append(div);
			
		}
	}
	

</script>
<style>
.flex_div {
	display: flex;
	width: 100%;
	/* 		height:1000px; */
}
</style>
</head>
<body>

	<div>
		<form action="webcon" method="post">
			웹툰 추가 <br/> 
			이미지<input id="image" name="image" type="text"> <br/> 
			제목<input id="title" name="title" type="text"> <br/>
			작가<input id="author" name="author" type="text"> <br/> 
			설명<input id="exp" name="explanation" type="text"> <br/> 
			<input type="submit" value="추가">
		</form>

		<button type="button" id="btn">ajax실행</button>
	</div>

	<hr>

	<div>
		<table>
			<thead>
				<tr>
					<th colspan="4">웹툰 리스트</th>
				</tr>
			</thead>

		</table>


		<div class="flex_div" id="flex_div">

			<c:forEach var="dto" items="${list}">
				<div class="child_div">
					<table>

						<tbody>

							<tr>
								<td>${dto.image}</td>
							</tr>

							<tr>
								<td>${dto.title}</td>
							</tr>

							<tr>
								<td>${dto.author}</td>
							</tr>

							<tr>
								<td>${dto.explanation}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</c:forEach>
		</div>


	</div>

	<div>
		<table>
			<thead>
				<tr>
					<th colspan="4">웹툰 리스트</th>
				</tr>
			</thead>

			<tbody id="webtooncontent">

			</tbody>
		</table>
	</div>

	<div>
		<table>
			<thead>
				<tr>
					<th colspan="4">웹툰 리스트</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>이미지1</td>
					<td>이미지2</td>
					<td>이미지3</td>
					<td>이미지4</td>
				</tr>

				<tr>
					<td>제목1</td>
					<td>제목2</td>
					<td>제목3</td>
					<td>제목4</td>
				</tr>

				<tr>
					<td>작가1</td>
					<td>작가2</td>
					<td>작가3</td>
					<td>작가4</td>
				</tr>

				<tr>
					<td>설명1</td>
					<td>설명2</td>
					<td>설명3</td>
					<td>설명4</td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>