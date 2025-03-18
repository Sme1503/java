package testQA.v01_park;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		TB_QA_1000DT_DAO QCtable_dao = new TB_QA_1000DT_DAO();
		
		List list = new ArrayList();
		
		String command = request.getParameter("command");
		
		if("insert".equals(command)) {
			
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
		}
		
		
		
		doGet(request, response);
	}

}
