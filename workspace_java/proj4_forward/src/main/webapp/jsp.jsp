<%-- jsp 주석 java로 번역이 안된다 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="java.util.ArrayList"
    %>
    
<%@ page import="java.util.*" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 스트립틀릿 = scriptlet -->
<%
	// java 영역
	System.out.println("java");

	List list = new ArrayList();
%>

<%
	int a = 10;
	System.out.println("a: " + a);
%>

<div><% out.println(a); %></div>
<div><%= a %></div>

<%!
	// 선언문
	// 필드 선언
	String str = "글씨";

	// 메소드 선언
	String getStr() {
		return this.str;
	}
%>

<%@ include file="header.jsp" %>

<!-- jsp에 직접 text에 1234라는 값을 보내고 jsp에서 html로 그 값을 출력하시오 -->
<%
	String text = request.getParameter("text");
	System.out.println("text: " + text);	
	
//	response.getWriter().println(text);
%>

<%= text %>

<%= request.getParameter("text")%>

<hr>
<!-- 액션 태그 -->
<jsp:include page= "header.jsp">
	<jsp:param value="nnan" name="id"/>
</jsp:include>

<script>
	let a = '<%= a%>'
	let b = 30;
</script>

</body>
</html>