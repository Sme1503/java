import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class TodoDAO {

	public int inssertTodo(TodoDTO todoDTO) {
		System.out.println("TodoDAO insertTodo 실행");

		int result = -1;
		try {

			// DB 접속시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null
			Connection con = ds.getConnection();

			// SQL 준비
			String query = "insert into todo ";
			
			// 방법1 : sql String 만들기
//			query += " values ( seq_todo.nextval,'"+ todoDTO.getTodo() + "', sysdate, null, 'N')";
			
			// 방법2 : ? 활용하기
			query += " values ( seq_todo.nextval, ?, sysdate, null, 'N')";
			
			PreparedStatement ps = con.prepareStatement(query);
			// 첫번째 물음표에 값을 넣어라
			ps.setString(1, todoDTO.getTodo());

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//			ResultSet rs = ps.executeQuery();
			
			// int에는 영양받은 줄의 수
			result = ps.executeUpdate();
			

			

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	List selectTodoList() {
		System.out.println("selectTodoList 실행");
		
		List list = new ArrayList();
		
		try {

			// DB 접속시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null
			Connection con = ds.getConnection();

			// SQL 준비
			String query = "select * from todo ";
			PreparedStatement ps = con.prepareStatement(query);
			
		

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				TodoDTO dto = new TodoDTO();
				dto.setTodo_id(rs.getInt("todo_id"));
				dto.setTodo(rs.getString("todo"));
				dto.setCreate_date(rs.getDate("create_date"));
				dto.setModify_date(rs.getDate("modify_date"));
				dto.setDone(rs.getString("done"));
				
				list.add(dto);
			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int updateTodo(TodoDTO todoDTO) {
		System.out.println("TodoDAO updateTodo 실행");
		System.out.println(todoDTO);

		int result = -1;
		try {

			// DB 접속시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null
			Connection con = ds.getConnection();

			// SQL 준비
			String query = " update todo ";
				   query += " set done = ? ";
				   query += " where todo_id = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			// 첫번째 물음표에 값을 넣어라
			ps.setString(1, todoDTO.getDone());
			ps.setInt(2, todoDTO.getTodo_id());

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//			ResultSet rs = ps.executeQuery();
			
			// int에는 영양받은 줄의 수
			result = ps.executeUpdate();
			

			

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	
}
