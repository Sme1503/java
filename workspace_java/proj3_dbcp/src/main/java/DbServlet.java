
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import kr.or.human.dto.EmpDTO;

/**
 * Servlet implementation class DbServlet
 */
@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		System.out.println();
		System.out.println("/db doGot 실행");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println();

		try {

			long time_before = System.currentTimeMillis(); // DB 접속 전 시간

			// DB 접속시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null
			Connection con = ds.getConnection();

			long time_after = System.currentTimeMillis(); // DB 접속 후 시간

			int time = (int) (time_after - time_before);
			System.out.println("DB 접속하는데 걸린 시간- time : " + time);

			time_before = System.currentTimeMillis(); // SQL 실행 전 시간

			// SQL 준비
			String query = "select * from";
			query += " emp";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			time_after = System.currentTimeMillis(); // SQL 실행 후 시간

			time = (int) (time_after - time_before);
			System.out.println("SQL실행하는데 걸린 시간- time : " + time);

			// 결과 활용
//			rs.next();		// 다음 줄로 커서를 이동
			// 다음 줄이 있으면 true, 없으면 false를 return

			time_before = System.currentTimeMillis(); // 콘솔 출력 전 시간

			int i = 1;
			List<EmpDTO> list = new ArrayList<EmpDTO>();
			while (rs.next()) { // 다음 줄이 없을 때까지 반복

				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
				System.out.println("----------------");
				System.out.print(i++);
				System.out.print(" empno: " + empno);
				System.out.print(" ename: " + ename);
				System.out.print(" hiredate: " + hiredate);
				System.out.println();

				Map map = new HashMap();
				map.put("empno", empno);
				map.put("ename", ename);
				map.put("hiredate", hiredate);

				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setHiredate(hiredate);
				list.add(empDTO);
				// list.add(map);
			}

			time_after = System.currentTimeMillis(); // 콘솔 출력 후 시간

			time = (int) (time_after - time_before);
			System.out.println("자바 콘솔 - time : " + time);

			// View
			PrintWriter out = response.getWriter();

			time_before = System.currentTimeMillis(); // 브라우저 출력 전 시간

			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<th>");
			out.print("<th>");
			out.print("<th>");
			out.print("</table>");

			for (int j = 0; j < list.size(); j++) {
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(list.get(j).getEmpno());
				empDTO.setEname(list.get(j).getEname());
				empDTO.setHiredate(list.get(j).getHiredate());
				out.print("<br>");
				out.print(" <Strong>" + empDTO.getEmpno() + "</Strong>");
				out.print(" <Strong>" + empDTO.getEname() + "</Strong>");
				out.print(" <Strong>" + empDTO.getHiredate() + "</Strong>");
				out.print("<br>");

				out.println();
			}

			time_after = System.currentTimeMillis(); // 브라우저 출력 후 시간

			time = (int) (time_after - time_before);
			System.out.println("브라우저 - time : " + time);
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
