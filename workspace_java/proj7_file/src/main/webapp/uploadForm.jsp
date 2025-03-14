<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 파일 첨부 시 유의 사항 
		method는 꼭 post여야 한다
		enctype은 원래 한글 깨짐 방지에 사용하는 속성인데
		파일 첨부시 enctype="multipart/form-data"를 써야한다
		accept-charset를 이용할 수 있다
	-->
	
	<form method="post" action="upload.do" enctype="multipart/form-data" accept-charset="utf-8">
		제목 : <input type="text" name="title"><br>
		내용 <textarea name="content" cols="40" rows="10"></textarea><br>
		첨부파일 : <input type="file" name="file1"><br>
		<input type="submit" value="등록"><br>
	</form>
	
	<img src="">
		
</body>
</html>