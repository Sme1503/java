<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<header>
<div>이거 헤더임</div>
<div>로고 here</div>
<div>${param.id }님 환영합니다</div>

<c:if test="${not empty param.msg }">
	<div class="msg">
		${param.msg }
	</div>
</c:if>

</header>

<script>
	const msg = '${param.msg}'
	let a = 'dom.value'
	let b = `\${a}`
</script>

<!-- html스크립트 변수 값이 자바 변수 값으로 올 수 없다  -->

</body>
</html>