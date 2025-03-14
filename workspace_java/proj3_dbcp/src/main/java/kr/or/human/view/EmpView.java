package kr.or.human.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.or.human.dto.EmpDTO;

public class EmpView {

	public void viewEmp(List<EmpDTO> list, HttpServletResponse response) {
		 

		try {
			PrintWriter out = response.getWriter();

			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>empno</th>");
			out.println("<th>ename</th>");
			out.println("<th>hiredate</th>");
			out.println("</tr>");

			for (int j = 0; j < list.size(); j++) {
				EmpDTO empDTO = new EmpDTO();
				empDTO = list.get(j);
				out.println("<tr>");
				out.println("<td>" + empDTO.getEmpno() + "</td>");
				out.println("<td>" + empDTO.getEname() + "</td>");
				out.println("<td>" + empDTO.getHiredate() + "</td>");
				out.println("<tr>");
			}

			out.println("</table>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
