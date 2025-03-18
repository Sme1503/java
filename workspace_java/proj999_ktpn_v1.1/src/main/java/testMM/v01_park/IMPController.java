package testMM.v01_park;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IMPController
 */
@WebServlet("/impcon")
public class IMPController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/impcon doGet실행");

		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		TB_MR_1000MT_DAO Mtable_dao = new TB_MR_1000MT_DAO();
		TB_FS_1000MT_DAO Ptable_dao = new TB_FS_1000MT_DAO();

		List MtableSelect = Mtable_dao.selectCurrentM(); // 원자재 테이블 전체 조회
		List PtableSelect = Ptable_dao.selectCurrentP(); // 완제품 테이블 전체 조회

		request.setAttribute("MtableSelect", MtableSelect);
		request.setAttribute("PtableSelect", PtableSelect);

		String url = "/TestMM_main_park.jsp";

		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/impcon doPost실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		TB_FS_1000MT_DTO Ptable_dto = new TB_FS_1000MT_DTO(); // 완제품 현황 테이블 dto
		TB_FS_1000HT_DTO PLogtable_dto = new TB_FS_1000HT_DTO(); // 완제품 로그 테이블 dto

		TB_FS_1000MT_DAO Ptable_dao = new TB_FS_1000MT_DAO(); // 완제품 현황 테이블 dao
		TB_FS_1000HT_DAO PLogtable_dao = new TB_FS_1000HT_DAO(); // 완제품 로그 테이블 dao

		List list = new ArrayList();

		String command = request.getParameter("command");
		System.out.println("command : " + command);

		if ("insert".equals(command)) {

			String pcode = request.getParameter("pcode");
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String ea = request.getParameter("ea");
			int EA = Integer.parseInt(ea);
			String io = request.getParameter("io");
			String worker = request.getParameter("worker");
			String warehouse = request.getParameter("warehouse");
			String date = request.getParameter("date");
			date = date.replace("-", "");
			String note = request.getParameter("note");

			int ex = 0; // insert, update 확인하는 변수

			if ("i".equals(io)) {
				list = Ptable_dao.selectCurrentP(code); // 완제품 현황 테이블에 입력한 코드의 데이터가 있는지 조회

				if (list.size() == 0) { // 데이터가 없으면 insert
					Ptable_dto.setFNSH_CODE(code);
					Ptable_dto.setFNSH_NM(name);
					Ptable_dto.setCRNT_AFTR_CNT(0 + EA);
					Ptable_dto.setFNSH_LOC_NM(warehouse);

					ex = Ptable_dao.insertCurrentP(Ptable_dto);
					System.out.println("완제품 현황 테이블에 " + ex + "행이 삽입되었습니다");

				} else { // 데이터가 있으면 update
					Ptable_dto = (TB_FS_1000MT_DTO) list.get(0);
					System.out.println("수정 전 데이터: " + Ptable_dto.toString());

					Ptable_dto.setCRNT_AFTR_CNT(Ptable_dto.getCRNT_AFTR_CNT() + EA);
					Ptable_dto.setFNSH_LOC_NM(warehouse);

					ex = Ptable_dao.updateCurrentP(Ptable_dto);
					System.out.println("완제품 현황 테이블에 " + ex + "행이 수정되었습니다");
					System.out.println("수정 후 데이터: " + Ptable_dto.toString());
				}

			} else if ("o".equals(io)) {
				list = Ptable_dao.selectCurrentP(code); // 완제품 현황 테이블에 입력한 코드의 데이터 조회

				if (list.size() == 0) { // 데이터가 없으면 오류
					System.out.println("오류! 출고할 데이터가 없습니다");

				} else { // 데이터가 있으면 update
					Ptable_dto = (TB_FS_1000MT_DTO) list.get(0);
					System.out.println("수정 전 데이터: " + Ptable_dto.toString());

					Ptable_dto.setCRNT_AFTR_CNT(Ptable_dto.getCRNT_AFTR_CNT() - EA);
					Ptable_dto.setFNSH_LOC_NM(warehouse);
					
					if(Ptable_dto.getCRNT_AFTR_CNT() < 0 ) {
						System.out.println("오류! 출고할 수량이 현재 수량보다 큽니다");
					} else if(Ptable_dto.getCRNT_AFTR_CNT() > 0) {
						ex = Ptable_dao.updateCurrentP(Ptable_dto);
						System.out.println("완제품 현황 테이블에 " + ex + "행이 수정되었습니다");
						
						
					} else {	// 현재 수량이 0이면
						ex = Ptable_dao.deleteCurrentP(Ptable_dto);
						System.out.println("완제품 현황 테이블에 " + ex + "행이 삭제되었습니다");
					}
				}

			}
			
			PLogtable_dto.setPROD_CD(pcode);
			PLogtable_dto.setFNSH_CODE(code);
			PLogtable_dto.setFNSHD_ITEM_NM(name);
			PLogtable_dto.setCRNT_CNT(EA);
			PLogtable_dto.setIOB_SE_CD(io);
			PLogtable_dto.setWORK_NM(worker);
			PLogtable_dto.setFNSHL_LOC_NM(warehouse);
			PLogtable_dto.setRMRK(note);
//			PLogtable_dto.setREG_DTTM(code);
			PLogtable_dto.setCRNT_AFTR_CNT(Ptable_dto.getCRNT_AFTR_CNT());
			PLogtable_dto.setCHNG_DT(date);
			
			ex = PLogtable_dao.insertPlog(PLogtable_dto);
			System.out.println("완제품 로그테이블에 " + ex + "행이 삽입되었습니다");


		} else if ("update".equals(command))

		{

			String pcode = request.getParameter("pcode");
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String ea = request.getParameter("ea");
			int EA = Integer.parseInt(ea);
			String io = request.getParameter("io");
			String worker = request.getParameter("worker");
			String warehouse = request.getParameter("warehouse");
			String date = request.getParameter("date");
			date = date.replace("-", "");
			String note = request.getParameter("note");
			
			int ex = 0; // insert, update 확인하는 변수

			if ("i".equals(io)) {
				list = Ptable_dao.selectCurrentP(code); // 완제품 현황 테이블에 입력한 코드의 데이터가 있는지 조회

				if (list.size() == 0) { // 데이터가 없으면 insert
					Ptable_dto.setFNSH_CODE(code);
					Ptable_dto.setFNSH_NM(name);
					Ptable_dto.setCRNT_AFTR_CNT(0 + EA);
					Ptable_dto.setFNSH_LOC_NM(warehouse);

					ex = Ptable_dao.insertCurrentP(Ptable_dto);
					System.out.println("완제품 현황 테이블에 " + ex + "행이 삽입되었습니다");

				} else { // 데이터가 있으면 update
					Ptable_dto = (TB_FS_1000MT_DTO) list.get(0);
					System.out.println("수정 전 데이터: " + Ptable_dto.toString());

					Ptable_dto.setCRNT_AFTR_CNT(Ptable_dto.getCRNT_AFTR_CNT() + EA);
					Ptable_dto.setFNSH_LOC_NM(warehouse);

					ex = Ptable_dao.updateCurrentP(Ptable_dto);
					System.out.println("완제품 현황 테이블에 " + ex + "행이 수정되었습니다");
					System.out.println("수정 후 데이터: " + Ptable_dto.toString());
				}

			} else if ("o".equals(io)) {
				list = Ptable_dao.selectCurrentP(code); // 완제품 현황 테이블에 입력한 코드의 데이터 조회

				if (list.size() == 0) { // 데이터가 없으면 오류
					System.out.println("오류! 출고할 데이터가 없습니다");

				} else { // 데이터가 있으면 update
					Ptable_dto = (TB_FS_1000MT_DTO) list.get(0);
					System.out.println("수정 전 데이터: " + Ptable_dto.toString());

					Ptable_dto.setCRNT_AFTR_CNT(Ptable_dto.getCRNT_AFTR_CNT() - EA);
					Ptable_dto.setFNSH_LOC_NM(warehouse);
					
					if(Ptable_dto.getCRNT_AFTR_CNT() < 0 ) {
						System.out.println("오류! 출고할 수량이 현재 수량보다 큽니다");
					} else if(Ptable_dto.getCRNT_AFTR_CNT() > 0) {
						ex = Ptable_dao.updateCurrentP(Ptable_dto);
						System.out.println("완제품 현황 테이블에 " + ex + "행이 수정되었습니다");
						
						
					} else {	// 현재 수량이 0이면
						ex = Ptable_dao.deleteCurrentP(Ptable_dto);
						System.out.println("완제품 현황 테이블에 " + ex + "행이 삭제되었습니다");
					}
				}

			}
			
			PLogtable_dto.setPROD_CD(pcode);
			PLogtable_dto.setFNSH_CODE(code);
			PLogtable_dto.setFNSHD_ITEM_NM(name);
			PLogtable_dto.setCRNT_CNT(EA);
			PLogtable_dto.setIOB_SE_CD(io);
			PLogtable_dto.setWORK_NM(worker);
			PLogtable_dto.setFNSHL_LOC_NM(warehouse);
			PLogtable_dto.setRMRK(note);
//			PLogtable_dto.setREG_DTTM(code);
			PLogtable_dto.setCRNT_AFTR_CNT(Ptable_dto.getCRNT_AFTR_CNT());
			PLogtable_dto.setCHNG_DT(date);
			
			ex = PLogtable_dao.insertPlog(PLogtable_dto);
			System.out.println("완제품 로그테이블에 " + ex + "행이 삽입되었습니다");

			

		} else if ("undo".equals(command)) {
			String code = request.getParameter("code");
			
			int ex = 0;
			
			// 잘못 입력한 로그 찾기
			list = PLogtable_dao.selectLastPLog(code, 1);
			PLogtable_dto = (TB_FS_1000HT_DTO) list.get(0);
			PLogtable_dto.setRMRK("데이터 입력이 잘못되었음");
			
			// 잘못 입력한 로그의 비고 데이터 수정
			ex = PLogtable_dao.updatePlog(PLogtable_dto);
			
			// 잘못 입력한 로그의 바로 이전 로그 찾기 - 정상 로그
			list = PLogtable_dao.selectLastPLog(code, 2);
			PLogtable_dto = (TB_FS_1000HT_DTO) list.get(0);
			PLogtable_dto.setRMRK("이전 로그로 롤백 ");
			
			Ptable_dto.setFNSH_CODE(PLogtable_dto.getFNSH_CODE());
			Ptable_dto.setFNSH_NM(PLogtable_dto.getFNSHD_ITEM_NM());
			Ptable_dto.setFNSH_LOC_NM(PLogtable_dto.getFNSHL_LOC_NM());
			Ptable_dto.setCRNT_AFTR_CNT(PLogtable_dto.getCRNT_AFTR_CNT());
			
			System.out.println("잘못 입력된 로그 이전의 로그값- 정상 로그 : 완제품 현황부분 " + Ptable_dto.toString());
			System.out.println("잘못 입력된 로그 이전의 로그값- 정상 로그 : 완제품 로그부분 " + PLogtable_dto.toString());
		
			ex = Ptable_dao.updateCurrentP(Ptable_dto);
			System.out.println("완제품 현황테이블에 " + ex + "행이 수정되었습니다");

			// 롤백하는 로그 데이터 다시 삽입하기
			ex = PLogtable_dao.insertPlog(PLogtable_dto);
			System.out.println("완제품 로그테이블에 " + ex + "행이 삽입되었습니다");
		}

		doGet(request, response);
		
		String url = "impcon";
		response.sendRedirect(url);
	}

}
