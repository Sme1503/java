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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
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
                    <i id="ham" class=" main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;<div class="logo"><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution</div>
                </div>
                <div class="icon-sub">
                    관리자님 환영합니다.
                    <!-- <i class="fas fa-solid fa-gear fa-lg" style="display: flex; width: 60px; justify-content: space-between;" > -->
                    <i class="fas fa-regular fa-arrow-right-from-bracket fa-md">
                        <span class="subBut">로그아웃</span>
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
            <div class="menu">자재관리</div>
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
                            </div>

                            <div class="div_add">

                                <!-- <div class="div_none"></div> -->

                                <div id="input">

                                    <div class="flex_child">

                                        <div class="item i_color">자재코드</div>
                                        <div class="item i_color">자재명</div>
                                        <div class="item i_color">수량</div>
                                        <!-- <div class= i_color"item">주문필요</div> -->
                                        <div class="item i_color">재고위치</div>
                                    </div>

                                    <!-- 입력추가 버튼을 누르면 나오는 input 예시 -->
                                    <!-- <div class="flex_child new_input">
                                <input class="item Mcode" type="text" value="" placeholder="자재코드 입력" />
                                <input class="item Mname" type="text" value="" placeholder="자재명 입력" />
                                <input class="item Mea" type="text" value="" placeholder="수량(EA) 입력" />
                                <input class="item Morder" type="text" value="" placeholder="1000개 미만 주문필요" readonly="readonly" />
                                <input class="item Mloc" type="text" value="" placeholder="재고위치 입력" />
                                </div> -->




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
                                        <button type="button" id="btn_add_confirm"><a class="btn_text_color"
                                                href="./TestMM_main_park.html">확인</a></button>
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