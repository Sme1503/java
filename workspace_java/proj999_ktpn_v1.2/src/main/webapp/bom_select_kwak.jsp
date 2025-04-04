<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tb_bm_1000mt.DAO_BM_Kwak" %>
<%@ page import="tb_bm_1000mt.DTO_BM_Kwak" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="bom_select_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="bom_select_kwak.js"></script>    
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>
<body>
    <!-- <body> -->
        <div class="menu-con work">
            <div>
                <div id ="title-name">
                    <div class="titleName">
                        <i id="ham" class=" main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;<div class="logo"><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution</div>
                    </div>
                    <div class="icon-sub">
                        관리자님 환영합니다.
                        <i class="fas fa-regular fa-arrow-right-from-bracket fa-md">
                            <span class="subBut">로그아웃</span>
                        </i>
                    </div>  
                </div>
            </div>
            <div class="main-menu-con">
                <!-- <div class="main-menu" id="main-menu">MENU 열기</div> -->
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


                    <div class="menuPage-con">    
                       <!-- html 들어갈 곳 -->
                        <div class="border_line">
                       <div class="pop">
                        <div class="add-table">
<!--                          <img class="eraser-img" > -->
                            <table class="detail-table">
                                <tr>
                                    <th class="detail-th" scope = "col">BOM코드</th>
                                    <th class="detail-th" scope = "col">BOM명</th>
                                    <th class="detail-th" scope = "col">품목코드</th>
                                </tr>
                                <%
                                	
                                	DAO_BM_Kwak dao = new DAO_BM_Kwak();
                                	List<DTO_BM_Kwak> dto = dao.getDataInfo(request.getParameter("bom_cd"));
                                	DTO_BM_Kwak dt = dto.get(0);
                                
                                %>
                                <tr>
                                    <td class="detail-td"><span class="spn-td"><%=dt.getBom_cd()%></span></td>
                                    <td class="detail-td"><span class="spn-td"><%=dt.getBom_nm()%></span></td>
                                    <td class="detail-td"><span class="spn-td"><%=dt.getItem_cd()%></span></td>
                                </tr>
                                
                            </table>
                        </div>
                        </div>
                        <div class="bompro-con">
                            <div class="bom-con">
                                <h4>품목코드 :<span class="spn-td"><%=dt.getItem_cd()%></span><input type='text' class="mod-td hide" value="A80"></h4>
                                <div class="bom-item-con">
<!--                                     <img class="eraser-img bom-item"> -->
                                    <span class="spn-td"><%=dt.getBom_desc().replace("\r\n","<br>")%></span><input type='text' class="mod-td hide" value="고무로 접착된 식물성 기름 5g">
                                </div>
                            </div>
                        </div>
                          <div class="add-con">
                            <div class="mode-con">
                            <form method="post" action="CNTRL_BM_Kwak">
                                <input type="submit" class="mod" value="수정">
                                <input type="hidden" value="수정" name="command">
                                <input type="hidden" value="<%=dt.getBom_cd() %>" name="bom_cd">
                             </form>
                            <form method="post" action="CNTRL_BM_Kwak">
                                <input type="submit" class="del" value="삭제">
                                <input type="hidden" value="삭제" name="command">
                                <input type="hidden" value="<%=dt.getBom_cd() %>" name="bom_cd">
                             </form>
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