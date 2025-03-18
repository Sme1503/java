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
 * Servlet implementation class IMController
 */
@WebServlet("/imcon")
public class IMController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/imcon doGet실행");

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
		System.out.println("/imcon doPost실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		TB_MR_1000MT_DTO Mtable_dto = new TB_MR_1000MT_DTO(); // 원자재 현황 테이블 dto
		TB_MR_1000HT_DTO MLogtable_dto = new TB_MR_1000HT_DTO(); // 원자재 로그 테이블 dto

		TB_MR_1000MT_DAO Mtable_dao = new TB_MR_1000MT_DAO(); // 원자재 현황 테이블 dao
		TB_MR_1000HT_DAO MLogtable_dao = new TB_MR_1000HT_DAO(); // 원자재 로그 테이블 dao

		List list = new ArrayList();

		String command = request.getParameter("command");
		System.out.println("command : " + command);

		if ("insert".equals(command)) {

			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String ea = request.getParameter("ea");
			int EA = Integer.parseInt(ea);
			String io = request.getParameter("inNout");
			String worker = request.getParameter("worker");
			String warehouse = request.getParameter("warehouse");
			String date = request.getParameter("date"); // yyyy-mm-dd
			date = date.replace("-", ""); // - 제거
			String note = request.getParameter("note");

			int ex = 0;					// insert, update 확인하는 변수

			if ("i".equals(io)) { // 입고
				list = Mtable_dao.selectCurrentM(code); // 원자재 현황 테이블에서 입력한 원자재코드의 데이터 조회

				if (list.size() == 0) { // 데이터가 없으면 insert
					Mtable_dto.setMTRL_CD(code);
					Mtable_dto.setMTRL_NM(name);
					Mtable_dto.setSTN_CNT(1000);
					Mtable_dto.setCRNT_AFTR_CNT(0 + EA);
					Mtable_dto.setMTRL_LOC_NM(warehouse);

					if (Mtable_dto.getCRNT_AFTR_CNT() <= Mtable_dto.getSTN_CNT()) { // 현재 수량이 기준 수량과 같거나 작으면
						Mtable_dto.setORDR_RQRD_YN("Y"); // 주문 필요 여부가 Y
					} else {
						Mtable_dto.setORDR_RQRD_YN("N"); // 주문 필요 여부가 N
					}

					ex = Mtable_dao.insertCurrentM(Mtable_dto);
					System.out.println("원자재 현황테이블에 " + ex + "행이 삽입되었습니다");

					System.out.println("입력한 데이터: " + Mtable_dto.toString());
					
				} else { // 데이터가 있으면 update
					Mtable_dto = (TB_MR_1000MT_DTO) list.get(0);
					System.out.println("수정 전 데이터: " + Mtable_dto.toString());
//					Mtable_dto.setMTRL_CD(code);
//					Mtable_dto.setMTRL_NM(name);
//					Mtable_dto.setSTN_CNT(1000);
//					Mtable_dto.getCRNT_AFTR_CNT();
					Mtable_dto.setCRNT_AFTR_CNT(Mtable_dto.getCRNT_AFTR_CNT() + EA);
					Mtable_dto.setMTRL_LOC_NM(warehouse);
					if (Mtable_dto.getCRNT_AFTR_CNT() <= Mtable_dto.getSTN_CNT()) { // 현재 수량이 기준 수량과 같거나 작으면
						Mtable_dto.setORDR_RQRD_YN("Y"); // 주문 필요 여부가 Y
					} else {
						Mtable_dto.setORDR_RQRD_YN("N"); // 주문 필요 여부가 N
					}

					ex = Mtable_dao.updateCurrentM(Mtable_dto);
					System.out.println("원자재 현황테이블에 " + ex + "행이 수정되었습니다");
					System.out.println("수정 후 데이터: " + Mtable_dto.toString());
				}

			}

			else if ("o".equals(io)) { // 출고

				list = Mtable_dao.selectCurrentM(code); // 원자재 현황 테이블에서 입력한 원자재코드의 데이터 조회

				if (list.size() == 0) { // 데이터가 없으면 오류
					System.out.println("오류! 출고할 데이터가 없습니다.");

				} else { // 데이터가 있으면 update
					Mtable_dto = (TB_MR_1000MT_DTO) list.get(0);
					System.out.println("수정 전 데이터: " + Mtable_dto.toString());
//					Mtable_dto.setMTRL_CD(code);
//					Mtable_dto.setMTRL_NM(name);
//					Mtable_dto.setSTN_CNT(1000);
//					Mtable_dto.getCRNT_AFTR_CNT();
					Mtable_dto.setCRNT_AFTR_CNT(Mtable_dto.getCRNT_AFTR_CNT() - EA);
					Mtable_dto.setMTRL_LOC_NM(warehouse);
					if (Mtable_dto.getCRNT_AFTR_CNT() <= Mtable_dto.getSTN_CNT()) { // 현재 수량이 기준 수량과 같거나 작으면
						Mtable_dto.setORDR_RQRD_YN("Y"); // 주문 필요 여부가 Y
					} else {
						Mtable_dto.setORDR_RQRD_YN("N"); // 주문 필요 여부가 N
					}
					System.out.println("수정 후 데이터: " + Mtable_dto.toString());

					if (Mtable_dto.getCRNT_AFTR_CNT() < 0) { // 현재 수량이 0보다 작으면
						System.out.println("오류! 출고할 수량이 현재 수량보다 큽니다.");
					} else if (Mtable_dto.getCRNT_AFTR_CNT() >= 0) { // 현재 수량이 0보다 크면
						ex = Mtable_dao.updateCurrentM(Mtable_dto);
						System.out.println("원자재 현황테이블에 " + ex + "행이 수정되었습니다");
					} else { // 현재 수량이 0이면
//						ex = Mtable_dao.deleteCurrentM(Mtable_dto);
						// System.out.println("원자재 현황테이블에 " + ex + "행이 삭제되었습니다");
					}

				}
			}

			MLogtable_dto.setMTRL_CD(Mtable_dto.getMTRL_CD());
			MLogtable_dto.setMTRL_NM(Mtable_dto.getMTRL_NM());
			MLogtable_dto.setSTN_CNT(Mtable_dto.getSTN_CNT());
			MLogtable_dto.setCRNT_CNT(EA);
			MLogtable_dto.setCRNT_AFTR_CNT(Mtable_dto.getCRNT_AFTR_CNT());
			MLogtable_dto.setORDR_RQRD_YN(Mtable_dto.getORDR_RQRD_YN());
			MLogtable_dto.setIOB_SE_CD(io);
			MLogtable_dto.setWORK_NM(worker);
//			MLogtable_dto.setREG_DTTM();
			MLogtable_dto.setCHNG_DT(date);
			MLogtable_dto.setRMRK(note);
			MLogtable_dto.setMTRL_CD_NM(Mtable_dto.getMTRL_LOC_NM());

			ex = MLogtable_dao.insertMlog(MLogtable_dto);
			System.out.println("원자재 로그테이블에 " + ex + "행이 삽입되었습니다");

		} else if ("update".equals(command)) {

			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String ea = request.getParameter("ea");
			int EA = Integer.parseInt(ea);
			String io = request.getParameter("inNout");
			String worker = request.getParameter("worker");
			String warehouse = request.getParameter("warehouse");
			String date = request.getParameter("date"); // yyyy-mm-dd
			date = date.replace("-", ""); // - 제거
			String note = request.getParameter("note");

			int ex = 0;

			if ("i".equals(io)) { // 입고
				list = Mtable_dao.selectCurrentM(code); // 원자재 현황 테이블에서 입력한 원자재코드의 데이터 조회

				if (list.size() == 0) { // 데이터가 없으면 insert
					Mtable_dto.setMTRL_CD(code);
					Mtable_dto.setMTRL_NM(name);
					Mtable_dto.setSTN_CNT(1000);
					Mtable_dto.setCRNT_AFTR_CNT(0 + EA);
					Mtable_dto.setMTRL_LOC_NM(warehouse);

					if (Mtable_dto.getCRNT_AFTR_CNT() <= Mtable_dto.getSTN_CNT()) { // 현재 수량이 기준 수량과 같거나 작으면
						Mtable_dto.setORDR_RQRD_YN("Y"); // 주문 필요 여부가 Y
					} else {
						Mtable_dto.setORDR_RQRD_YN("N"); // 주문 필요 여부가 N
					}
					System.out.println("입력 후" + Mtable_dto.toString());

					ex = Mtable_dao.insertCurrentM(Mtable_dto);
					System.out.println("원자재 현황테이블에 " + ex + "행이 삽입되었습니다");

				} else { // 데이터가 있으면 update
					Mtable_dto = (TB_MR_1000MT_DTO) list.get(0);
					System.out.println("수정 전" + Mtable_dto.toString());
//					Mtable_dto.setMTRL_CD(code);
//					Mtable_dto.setMTRL_NM(name);
//					Mtable_dto.setSTN_CNT(1000);
//					Mtable_dto.getCRNT_AFTR_CNT();
					Mtable_dto.setCRNT_AFTR_CNT(Mtable_dto.getCRNT_AFTR_CNT() + EA);
					Mtable_dto.setMTRL_LOC_NM(warehouse);
					if (Mtable_dto.getCRNT_AFTR_CNT() <= Mtable_dto.getSTN_CNT()) { // 현재 수량이 기준 수량과 같거나 작으면
						Mtable_dto.setORDR_RQRD_YN("Y"); // 주문 필요 여부가 Y
					} else {
						Mtable_dto.setORDR_RQRD_YN("N"); // 주문 필요 여부가 N
					}
					System.out.println("수정 후" + Mtable_dto.toString());

					ex = Mtable_dao.updateCurrentM(Mtable_dto);
					System.out.println("원자재 현황테이블에 " + ex + "행이 수정되었습니다");
				}

			}

			else if ("o".equals(io)) { // 출고

				list = Mtable_dao.selectCurrentM(code); // 원자재 현황 테이블에서 입력한 원자재코드의 데이터 조회

				if (list.size() == 0) { // 데이터가 없으면
					System.out.println("오류! 출고할 데이터가 없습니다.");

				} else { // 데이터가 있으면
					Mtable_dto = (TB_MR_1000MT_DTO) list.get(0);
					System.out.println("수정 전" + Mtable_dto.toString());
//					Mtable_dto.setMTRL_CD(code);
//					Mtable_dto.setMTRL_NM(name);
//					Mtable_dto.setSTN_CNT(1000);
//					Mtable_dto.getCRNT_AFTR_CNT();
					Mtable_dto.setCRNT_AFTR_CNT(Mtable_dto.getCRNT_AFTR_CNT() - EA);
					Mtable_dto.setMTRL_LOC_NM(warehouse);
					if (Mtable_dto.getCRNT_AFTR_CNT() <= Mtable_dto.getSTN_CNT()) { // 현재 수량이 기준 수량과 같거나 작으면
						Mtable_dto.setORDR_RQRD_YN("Y"); // 주문 필요 여부가 Y
					} else {
						Mtable_dto.setORDR_RQRD_YN("N"); // 주문 필요 여부가 N
					}
					System.out.println("수정 후" + Mtable_dto.toString());

					if (Mtable_dto.getCRNT_AFTR_CNT() < 0) { // 현재 수량이 0보다 작으면
						System.out.println("오류! 출고할 수량이 현재 수량보다 큽니다.");
					} else if (Mtable_dto.getCRNT_AFTR_CNT() >= 0) { // 현재 수량이 0이거나 0보다 크면
						ex = Mtable_dao.updateCurrentM(Mtable_dto);
						System.out.println("원자재 현황테이블에 " + ex + "행이 수정되었습니다");
					} else { // 현재 수량이 0이면
//						ex = Mtable_dao.deleteCurrentM(Mtable_dto);
						// System.out.println("원자재 현황테이블에 " + ex + "행이 삭제되었습니다");
					}

				}
			}

			MLogtable_dto.setMTRL_CD(Mtable_dto.getMTRL_CD());
			MLogtable_dto.setMTRL_NM(Mtable_dto.getMTRL_NM());
			MLogtable_dto.setSTN_CNT(Mtable_dto.getSTN_CNT());
			MLogtable_dto.setCRNT_CNT(EA);
			MLogtable_dto.setCRNT_AFTR_CNT(Mtable_dto.getCRNT_AFTR_CNT());
			MLogtable_dto.setORDR_RQRD_YN(Mtable_dto.getORDR_RQRD_YN());
			MLogtable_dto.setIOB_SE_CD(io);
			MLogtable_dto.setWORK_NM(worker);
//			MLogtable_dto.setREG_DTTM();
			MLogtable_dto.setCHNG_DT(date);
			MLogtable_dto.setRMRK(note);
			MLogtable_dto.setMTRL_CD_NM(Mtable_dto.getMTRL_LOC_NM());

			ex = MLogtable_dao.insertMlog(MLogtable_dto);
			System.out.println("원자재 로그테이블에 " + ex + "행이 삽입되었습니다");

		} else if("undo".equals(command)) {			// 입력 취소 - 이전 데이터로 롤백
			
			String code = request.getParameter("code");
			
			int ex = 0;
			
//			Mtable_dto.setMTRL_CD(code);
//			ex = Mtable_dao.deleteCurrentM(Mtable_dto);
//			System.out.println("원자재 현황테이블에 " + ex + "행이 삭제되었습니다");
//			
//			list = MLogtable_dao.selectLastMLog(code);
//			Mtable_dto = (TB_MR_1000MT_DTO) list.get(0);
//			
//			System.out.println("마지막 로그: " + Mtable_dto.toString());
//
//			ex = Mtable_dao.insertCurrentM(Mtable_dto);
//			System.out.println("원자재 현황테이블에 " + ex + "행이 추가되었습니다");
			
			// 잘못 입력한 로그 찾기
			list = MLogtable_dao.selectLastMLog(code, 1);
			MLogtable_dto = (TB_MR_1000HT_DTO) list.get(0);
			MLogtable_dto.setRMRK("데이터 입력이 잘못되었음");
			
			// 잘못 입력한 로그의 비고 데이터 수정
			ex = MLogtable_dao.updateMlog(MLogtable_dto);
			
			// 잘못 입력한 로그의 바로 이전 로그 찾기 - 정상 로그
			list = MLogtable_dao.selectLastMLog(code, 2);
//			Mtable_dto = (TB_MR_1000MT_DTO) list.get(0);
			
			MLogtable_dto = (TB_MR_1000HT_DTO) list.get(0);
			MLogtable_dto.setRMRK("이전 로그로 롤백 ");
			
			Mtable_dto.setMTRL_CD(MLogtable_dto.getMTRL_CD());
			Mtable_dto.setMTRL_NM(MLogtable_dto.getMTRL_NM());
			Mtable_dto.setSTN_CNT(MLogtable_dto.getSTN_CNT());
			Mtable_dto.setORDR_RQRD_YN(MLogtable_dto.getORDR_RQRD_YN());
			Mtable_dto.setMTRL_LOC_NM(MLogtable_dto.getMTRL_CD_NM());
			Mtable_dto.setCRNT_AFTR_CNT(MLogtable_dto.getCRNT_AFTR_CNT());
			
			
			System.out.println("잘못 입력된 로그 이전의 로그값- 정상 로그 : 원자재 현황부분 " + Mtable_dto.toString());
			System.out.println("잘못 입력된 로그 이전의 로그값- 정상 로그 : 원자재 로그부분 " + MLogtable_dto.toString());

			ex = Mtable_dao.updateCurrentM(Mtable_dto);
			System.out.println("원자재 현황테이블에 " + ex + "행이 수정되었습니다");
			
			// 롤백하는 로그 데이터 다시 삽입하기
			ex = MLogtable_dao.insertMlog(MLogtable_dto);
			System.out.println("원자재 로그테이블에 " + ex + "행이 삽입되었습니다");
		}

		doGet(request, response);

		String url = "imcon";
		response.sendRedirect(url);

	}

}
