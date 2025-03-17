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

		List MtableSelect = Mtable_dao.selectCurrentM(); // 원자재 테이블 전체 조회

		request.setAttribute("MtableSelect", MtableSelect);

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

			list = Mtable_dao.selectCurrentM();

			if (list.size() == 0) { // 원자재 현황 테이블에서 원자재를 조회했을 때 데이터가 없으면
				Mtable_dto.setMTRL_CD(code);
				Mtable_dto.setMTRL_NM(name);
				Mtable_dto.setSTN_CNT(1000);
				Mtable_dto.setCRNT_AFTR_CNT(0 + EA);
				Mtable_dto.setMTRL_LOC_NM(warehouse);
				if(Mtable_dto.getCRNT_AFTR_CNT() <= Mtable_dto.getSTN_CNT()) {	// 현재 수량이 기준 수량과 같거나 작으면
					Mtable_dto.setORDR_RQRD_YN("Y");		// 주문 필요 여부가 Y
				} else {
					Mtable_dto.setORDR_RQRD_YN("N");		// 주문 필요 여부가 N
				}
			}
			
			int ex = Mtable_dao.insertCurrentM(Mtable_dto);
			
			System.out.println("원자재 현황테이블에 " + ex + "행이 삽입되었습니다");
			
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

		}

		doGet(request, response);

		String url = "imcon";
		response.sendRedirect(url);

	}

}
