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
<link rel="stylesheet" href="resources/css/layOut_kwak.css" type="text/css">
<link rel="stylesheet" href="resources/css/TestQA_report_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="resources/js/layOut_kwak.js"></script>
<script src="resources/js/TestQA_report_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>

	<div class="menuPage-con">
		<!-- html 들어갈 곳 -->
		<!-- TestQA_report -->
		<div class="containerQA_report">
			<!-- background : darkgrey -->
			<div class="content">

				<div class="margin">

					<div class="tab-name-con">
						<div class="tab-name">품질 테스트 수정</div>
					</div>

					<div class="div_report_parent">
						<div class="div_report_name"></div>


						<div class="t_con">
							<form method="post" action="컨트롤러">
								<div class="con_1">

									<div>
										<table class="QA-table">
											<tbody>
												<tr class="QA-tr">
													<th class="QA-th1">생산코드</th>
													<th class="QA-th1">품목코드</th>
													<th class="QA-th1">품목명</th>
													<th class="QA-th1">검수자</th>
													<th class="QA-th1">검수일</th>

												</tr>

												<tr>
													<td class="QA-td">${QcList.PROD_CD }</td>
													<td class="QA-td">${QcList.ITEM_CD }</td>
													<td class="QA-td">${QcList.ITEM_NM }</td>
													<td class="QA-td"><select name="worker"
														required="required">
															<c:forEach var="worker" items="${workerList }">
																<option value="${worker.MBR_NM }">${worker.MBR_NM }</option>
															</c:forEach>
													</select></td>
													<td class="QA-td"><input type="date" id="currentDate"
														required="required"></td>

												</tr>
											</tbody>
										</table>
									</div>

									<div>
										<table class="QA-table">
											<tbody>
												<tr class="QA-tr">
													<th class="QA-th1">강도값</th>
													<th class="QA-th1">크기값</th>
													<th class="QA-th1">색상값</th>
													<th class="QA-th1">품질값</th>
													<th class="QA-th1">불합격사유</th>
													<th class="QA-th1" colspan="1">비고</th>
												</tr>

												<tr>


													<td class="QA-td"><select name="fiber"
														required="required">
															<!-- <option value="fiber_select">선택</option> -->
															<option value="fiber_1">1</option>
															<option value="fiber_2">2</option>
															<option value="fiber_3">3</option>
															<option value="fiber_4">4</option>
															<option value="fiber_5">5</option>
															<option value="fiber_6">6</option>
															<option value="fiber_7">7</option>
															<option value="fiber_8">8</option>
															<option value="fiber_9">9</option>
															<option value="fiber_10" selected>10</option>
													</select></td>

													<td class="QA-td"><select name="size"
														required="required">
															<!-- <option value="size_select">선택</option> -->
															<option value="size_1">1</option>
															<option value="size_2">2</option>
															<option value="size_3">3</option>
															<option value="size_4">4</option>
															<option value="size_5">5</option>
															<option value="size_6">6</option>
															<option value="size_7">7</option>
															<option value="size_8">8</option>
															<option value="size_9">9</option>
															<option value="size_10" selected>10</option>
													</select></td>

													<td class="QA-td"><input name="color" type="color"
														value="" placeholder="입력하세요"></td>

													<td class="QA-td"><select name="erase"
														required="required">
															<!-- <option value="erase_select">선택</option> -->
															<option value="erase_1">1</option>
															<option value="erase_2">2</option>
															<option value="erase_3">3</option>
															<option value="erase_4">4</option>
															<option value="erase_5">5</option>
															<option value="erase_6">6</option>
															<option value="erase_7">7</option>
															<option value="erase_8">8</option>
															<option value="erase_9">9</option>
															<option value="erase_10" selected>10</option>
													</select></td>

													<td class="QA-td" colspan="1"><select name="notpass"
														required="required">
															<option value="선택" selected>선택</option>
															<option value="외관불량">외관불량</option>
															<option value="강도불량">강도불량</option>
															<option value="색상불량">색상불량</option>
															<option value="잘안지워짐">잘안지워짐</option>
															<option value="옵션없음(비고에 입력)">옵션없음(비고에 입력)</option>
													</select> <!-- 														<input type="text" name="notpass" value="" placeholder="입력하세요"> -->
													</td>
													<td class="QA-td" colspan="1"><input type="text"
														name="note" value="" placeholder="입력하세요"></td>
												</tr>
											</tbody>
										</table>
									</div>

									<div>
										<input type="hidden" value="update" name="command"> <input
											type="submit" value="수정하기">

										<button type="submit" name="command" value="update">수정하기</button>
									</div>

								</div>
							</form>

							<div class="con_2"></div>




						</div>
					</div>
				</div>
				</form>
			</div>

		</div>


		<div class="div_button">
			<div class="div_none">
				<!-- 빈 공간 -->
			</div>
			<button type="button" id="btn_report_confirm">
				<a class="btn_text_color" href="./TestQA_main_park.html">확인</a>
			</button>

			<div class="div_none">
				<!-- 빈 공간 -->
			</div>
		</div>
	</div>
</body>

</html>