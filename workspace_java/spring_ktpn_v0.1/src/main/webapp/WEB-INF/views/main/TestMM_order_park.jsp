<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- 여기에 대시보드 css 파일옮기기 -->
<!-- <link rel="stylesheet" href="resources/css/layOut_kwak.css" type="text/css"> -->
<link rel="stylesheet" href="resources/css/TestMM_order_park.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<!-- <script src="resources/js/layOut_kwak.js"></script> -->
<script src="resources/js/TestMM_order_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>
	<div class="menuPage-con">
		<!-- html 들어갈 곳 -->
		<!-- TestMM_order -->

		<div class="containerMM_order">
			<div class="content">

				<div class="margin">

					<div class="tab-name-con">
						<div class="tab-name">거래처</div>
					</div>

					<!-- <div class="div_none"></div> -->

					<div>
						<table class="order_table">

							<tr>
								<th scope="col" class="order_th">거래처코드</th>
								<th scope="col" class="order_th">회사</th>
								<th scope="col" class="order_th">담당자</th>
								<th scope="col" class="order_th">연락처</th>
								<th scope="col" class="order_th">거래품목</th>
							</tr>

							<c:forEach var="company" items="${companyList }">

								<tr>
									<td class="order_td">${company.cstmr_code }</td>
									<td class="order_td">${company.cmp_nm }</td>
									<td class="order_td">${company.mngr_nm }</td>
									<td class="order_td">${company.tel_no }</td>
									<td class="order_td">${company.trn_itm_item_nm }</td>
								</tr>

							</c:forEach>

						</table>

						<div class="div_none">
							<!-- 빈 공간 -->
						</div>

						<div class="div_button">
							<button type="button" id="btn_order_confirm">
								<a class="btn_text_color" href="TestMM_main_park.jsp">확인</a>
							</button>
						</div>

					</div>
				</div>


			</div>

		</div>




	</div>

</body>

</html>