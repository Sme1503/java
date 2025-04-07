package testQA.v01_park;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Memberr.MemberDAO;
import Memberr.MemberDTO;
import tb_pr_1100mt.TB_PR_1100MTDAO;
import tb_pr_1100mt.TB_PR_1100MTDTO;

/**
 * Servlet implementation class QAController
 */
@WebServlet("/qccon")
public class QAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/qccon doGet실행");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		TB_QA_1100DT_DTO QCtable_dto = new TB_QA_1100DT_DTO();
		TB_QA_1100DT_DAO QCtable_dao = new TB_QA_1100DT_DAO();
		List list = new ArrayList();
		
		
		list = QCtable_dao.selectQCreport();
		String url = "TestQA_main_park.jsp";

		request.getRequestDispatcher(url).forward(request, response);
		
		
		
		
//		String code = request.getParameter("code");
//		
//		list = QCtable_dao.joinQCnPR(code);	// 조인한 결과 리스트
//		request.setAttribute("joinList", list);
//		
//		url = "TestQA_report_park_table_show.jsp";
//		
//		request.getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/qccon doPost실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		TB_QA_1100DT_DTO QCtable_dto = new TB_QA_1100DT_DTO();
		TB_QA_1100DT_DAO QCtable_dao = new TB_QA_1100DT_DAO();
		
		List list = new ArrayList();
		
		String command = request.getParameter("command");
		
		if("insert".equals(command)) {
			
			String pcode = request.getParameter("Pcode");
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String tester = request.getParameter("tester");
			String date = request.getParameter("date");
			date = date.replace("-", "");
			String fiber = request.getParameter("fiber");
			int fiber_i = Integer.parseInt(fiber);
			String size = request.getParameter("size");
			int size_i = Integer.parseInt(size);
			String color = request.getParameter("color");
			String erase = request.getParameter("erase");
			int erase_i = Integer.parseInt(erase);
			String notpass = request.getParameter("notpass");
			String note = request.getParameter("note");
			
			QCtable_dto.setProd_cd(pcode);
			QCtable_dto.setItem_cd(code);
			QCtable_dto.setItem_nm(name);
			QCtable_dto.setChckr_nm(tester);
//			QCtable_dto.setChckr_dttm(();
			QCtable_dto.setStrth_val(fiber_i);
			QCtable_dto.setSz_val(size_i);
			QCtable_dto.setClrl_val(color);
			QCtable_dto.setQlty_val(erase_i);
			QCtable_dto.setFail_caus_desc(notpass);
			QCtable_dto.setRmrk(note);
			
			int ex = QCtable_dao.insertQCreport(QCtable_dto);
			System.out.println("QC테이블에 " + ex + "행이 삽입되었습니다");
			
			
		} 
		else if("update".equals(command)) {
			
			
			String pcode = request.getParameter("pcode");
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String tester = request.getParameter("tester");
			String date = request.getParameter("date");
			date = date.replace("-", "");
			String fiber = request.getParameter("fiber");
			int fiber_i = Integer.parseInt(fiber);
			String size = request.getParameter("size");
			int size_i = Integer.parseInt(size);
			String color = request.getParameter("color");
			String erase = request.getParameter("erase");
			int erase_i = Integer.parseInt(erase);
			String notpass = request.getParameter("notpass");
			String note = request.getParameter("note");
			
			QCtable_dto.setProd_cd(pcode);
			QCtable_dto.setItem_cd(code);
			QCtable_dto.setItem_nm(name);
			QCtable_dto.setChckr_nm(tester);
//			QCtable_dto.setChckr_dttm(();
			QCtable_dto.setStrth_val(fiber_i);
			QCtable_dto.setSz_val(size_i);
			QCtable_dto.setClrl_val(color);
			QCtable_dto.setQlty_val(erase_i);
			QCtable_dto.setFail_caus_desc(notpass);
			QCtable_dto.setRmrk(note);
			
			int ex = QCtable_dao.updateQCreport(QCtable_dto);
			System.out.println("QC테이블에 " + ex + "행이 수정되었습니다");
		}
		else if("delete".equals(command)) {
			// 여러개 삭제 가능
			// delete from where ? or ? or ? or	  1번만 실행
			// 또는 delete from where ?           여러번 실행
			
			// 여러개의 값이 같은 이름으로 올 수도 있다
			String[] del = request.getParameterValues("delcode");
			
			int ex = 0;
			int cnt = 0;
			
			// delete from where ? = ? 여러번 실행
			for(int i = 0; i<del.length; i++) {
				
				QCtable_dto.setProd_cd(del[i]);
				ex = QCtable_dao.deleteQCreport(QCtable_dto);
				
				cnt++;
			}
			System.out.println("QC테이블에 " + cnt + "행이 삭제되었습니다");
			
			
			
		}
		else if("move_add_page".equals(command)) {
			
			TB_PR_1100MTDTO p_table_dto = new TB_PR_1100MTDTO();
			TB_PR_1100MTDAO p_table_dao = new TB_PR_1100MTDAO();

			List PcodeList = new ArrayList();
			// 생산이 완료된 생산코드 데이터
			PcodeList = p_table_dao.selectTBPR_Y_List();

			for (int i = 0; i < PcodeList.size(); i++) {
				p_table_dto = (TB_PR_1100MTDTO) PcodeList.get(i);

				System.out.println("생산이 완료된 생산코드 : " + p_table_dto.toString());
				System.out.println();
			}

			request.setAttribute("pList", PcodeList);
			
			// 검수자
			MemberDTO m_table_dto = new MemberDTO();
			MemberDAO m_table_dao = new MemberDAO();

			List memberList = new ArrayList();
			memberList = m_table_dao.selectMember();

			for (int i = 0; i < memberList.size(); i++) {
				m_table_dto = (MemberDTO) memberList.get(i);

				System.out.println("member : " + m_table_dto.toString());
				System.out.println();
			}
			request.setAttribute("mList", memberList);
			
			
			String url = "TestQA_report_park_table_add2.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			
		}
		else if("move_update_page".equals(command)) {
			
			TB_PR_1100MTDTO p_table_dto = new TB_PR_1100MTDTO();
			TB_PR_1100MTDAO p_table_dao = new TB_PR_1100MTDAO();

			List PcodeList = new ArrayList();
			// 생산이 완료된 생산코드 데이터
			PcodeList = p_table_dao.selectTBPR_Y_List();

			for (int i = 0; i < PcodeList.size(); i++) {
				p_table_dto = (TB_PR_1100MTDTO) PcodeList.get(i);

				System.out.println("생산이 완료된 생산코드 : " + p_table_dto.toString());
				System.out.println();
			}

			request.setAttribute("pList", PcodeList);
			
			// 검수자
			MemberDTO m_table_dto = new MemberDTO();
			MemberDAO m_table_dao = new MemberDAO();

			List memberList = new ArrayList();
			memberList = m_table_dao.selectMember();

			for (int i = 0; i < memberList.size(); i++) {
				m_table_dto = (MemberDTO) memberList.get(i);

				System.out.println("member : " + m_table_dto.toString());
				System.out.println();
			}
			request.setAttribute("mList", memberList);
			
			
			String url = "TestQA_report_park_table_update2.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			
		}
		else if("move_show_page".equals(command)) {
			
			// 생산테이블과 품질테이블을 생산코드로 조인
			String code = request.getParameter("code");
			
			TB_QA_1000DT_DTO Jointable_dto = new TB_QA_1000DT_DTO();
			TB_QA_1100DT_DAO Jointable_dao = new TB_QA_1100DT_DAO();
			
			List joinList = new ArrayList();
			
			joinList = Jointable_dao.joinQCnPR(code);
			
			for (int i = 0; i < joinList.size(); i++) {
				Jointable_dto = (TB_QA_1000DT_DTO) joinList.get(i);

				System.out.println("조인 내용 : " + Jointable_dto.toString());
				System.out.println();
			}
			request.setAttribute("QcList", joinList);
			
			
			String url = "TestQA_report_park_table_show.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			
		}
		else if("move_main_page".equals(command)) {
			
			// 품질 테이블 조회 List를 메인으로 보내기
			list = QCtable_dao.selectQCreport();
			String url = "TestQA_main_park2.jsp";

			request.getRequestDispatcher(url).forward(request, response);
		}
		
//		String url = "qccon";
//		response.sendRedirect(url);
//		
//		
//		doGet(request, response);
	}

}
