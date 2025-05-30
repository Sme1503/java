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
<link rel="stylesheet" href="layOut_kwak.css" type="text/css">
<link rel="stylesheet" href="TestMM_add_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="layOut_kwak.js"></script>
<script src="TestMM_add_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<!-- <body> -->

<body>
	<div class="menu-con work">
		<div>
			<div id="title-name">
				<div class="titleName">
					<i id="ham" class=" main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;
					<div class="logo">
						<i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES
						solution
					</div>
				</div>
				<div class="icon-sub">
					관리자님 환영합니다.
					<!-- <i class="fas fa-solid fa-gear fa-lg" style="display: flex; width: 60px; justify-content: space-between;" > -->
					<i class="fas fa-regular fa-arrow-right-from-bracket fa-md"> <span
						class="subBut">로그아웃</span>
					</i>
					<!-- </i> -->
				</div>
			</div>
		</div>
		<div class="main-menu-con">
			<!-- <div class="main-menu" id="main-menu">MENU 닫기</div> -->
			<div class="menu">기준관리</div>
			<div class="menu">작업관리</div>
			<div class="menu">생산관리</div>
			<div class="menu">생산리포팅</div>
			<div class="menu">재고관리</div>
			<div class="menu">품질관리</div>
		</div>
	</div>
	<div class="board">

		<div class="mainmenu" id="work1">
			<div class="menuBut">대시보드</div>
			<div class="menuBut">게시판</div>
			<div class="menuBut">공지사항</div>
			<!-- <div class="menuBut">기준관리</div> -->
		</div>
		<div class="bome-con">

			<!-- <div> -->
			<div class="menuPage-con">
				<!-- html 들어갈 곳 -->
				<!-- TestMM_add -->
				<div class="containerMM_add">

					<div class="content">

						<div class="margin">

							<div class="tab-name-con">
								<div class="tab-name">재고 추가</div>
								2줄로
							</div>

							<div class="div_add">

								<!-- <div class="div_none"></div> -->

								<div id="input">
									<form action="impcon" method="post">
										<div class="flex_child">

											<div class="item i_color">생산코드</div>
											<div class="item i_color">완제품코드</div>
											<div class="item i_color">완제품이름</div>
											<div class="item i_color">입력수량</div>
											<div class="item i_color">입고/출고</div>
										</div>

										<div class="flex_child">

											<div class="item">
												<select id="select1" name="Pcode" onchange="changePP()">
													<option value="default" selected="selected">선택</option>
													<c:forEach var="pcode" items="${pList }">
														<option value="${pcode.prod_cd }"
															auto_icode="${pcode.item_cd }"
															auto_iname="${pcode.item_nm }"
															auto_iea="${pcode.prod_qntt }">${pcode.prod_cd }</option>
													</c:forEach>
												</select>
											</div>


											<script>
												// 셀렉트 박스의 옵션을 선택하면 다른 인풋에 값이 들어가는 함수
												function changePP() {
													var select1 = document
															.getElementById('select1');
													var select1_option = select1.options[select1.selectedIndex];

													var auto_icode = select1_option.getAttribute('auto_icode');
													document.getElementById('icode').value = auto_icode;

													var auto_iname = select1_option.getAttribute('auto_iname');
													document.getElementById('iname').value = auto_iname;
															 			
													var auto_iea = select1_option.getAttribute('auto_iea');
													document.querySelector('#iea').value = auto_iea;
												}
											</script>

											<div class="item">

												<input class="item" type="text" id="icode" name="code"
													value="" readonly="readonly">
											</div>
											<div class="item">
												<input class="item" type="text" id="iname" name="name"
													value="" readonly="readonly">
											</div>


											<!--                                     		<select name="code"> -->
											<%--                                     			<c:forEach var = "code" items = "${codeList }"> --%>
											<%--                                     				<option value="${code.ITEM_CD }">${code.ITEM_CD }</option> --%>
											<%--                                     			</c:forEach> --%>
											<!--                                     		</select> -->

											<!--                                     		<select name="name"> -->
											<%--                                     			<c:forEach var = "code" items = "${codeList }"> --%>
											<%--                                     				<option value="${code.ITEM_NM }">${code.ITEM_NM }</option> --%>
											<%--                                     			</c:forEach> --%>
											<!--                                     		</select> -->

											<div class="item">
												<input class="item Mea" type="text" id="iea" name="ea"
													value="" readonly="readonly"/>
											</div>
											<div class="item">
												<select name="inNout">
													<option value="i">입고</option>
													<option value="o">출고</option>
												</select>
											</div>
										</div>
										
										<div class="div_none"></div>

										<div class="flex_child">
											<div class="item i_color">작업자</div>
											<div class="item i_color">위치</div>
											<div class="item i_color">입력일</div>
											<div class="item i_color">비고</div>
											<!--                                         <div class="item i_color">변동후 수량</div> -->
											<!--                                         <div class="item i_color">변동일</div> -->
										</div>

										<!-- 입력추가 버튼을 누르면 나오는 input 예시 -->
										<!-- 										<div class="flex_child new_input"> -->

										<div class="flex_child">

											<div class="item">
												<select name="worker">
													<c:forEach var="member" items="${mList }">
														<option value="${member.mbr_nm }">${member.mbr_nm }</option>
													</c:forEach>
												</select>
											</div>

											<div class="item">
												<select name="warehouse">
													<option value="warehouse1">P창고1</option>
													<!--                                     			<option value="warehouse2">P창고2</option> -->
													<!--                                     			<option value="warehouse3">P창고3</option> -->

												</select>
											</div>

											<div class="item">
												<input class="item" id="date" name="date" type="date" />
											</div>

											<div class="item">
												<input class="item note" type="text" name="note" value=""
													placeholder="입력" />
											</div>


										</div>


										<!-- 										</div> -->
										<div>
											<input type="hidden" name="command" value="insert"> 
											<input type="submit" value="추가">
										</div>


									</form>

								</div>

								<div class="div_btn">

									<div class="div_none">
										<!-- 빈 공간 -->
									</div>

									<!-- 추가 input을 만드는 버튼 -->
									<div class="div_btn_input_add">
										<button type="button" id="btn_input_add" class="btn_input_add">입력추가</button>
									</div>

									<div class="div_none">
										<!-- 빈 공간 -->
									</div>

									<!-- 확인 버튼 -->
									<div class="div_btn_add_confirm">
										<button type="button" id="btn_add_confirm">
											<a class="btn_text_color" href="./TestMM_main_park.html">확인</a>
										</button>
									</div>
								</div>




							</div>
						</div>




					</div>
				</div>




			</div>
		</div>
	</div>
	<!-- </div> -->
	<!-- </body> -->

</body>

</html>