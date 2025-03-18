package testQA.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import testMM.v01_park.TB_OD_1000MT_DTO;

public class TB_QA_1100DT_DAO {
	
	// QA리포트 테이블의 CRUD
	
	// 조회
	// 전체 조회
	public List selectQCreport() {

		System.out.println("TB_QA_1100DT selectQCreport 실행");

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
			String query = "select * from TB_QA_1100DT ";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_QA_1100DT_DTO dto = new TB_QA_1100DT_DTO();

				dto.setPROD_CD(rs.getString("PROD_CD"));
				dto.setITEM_CD(rs.getString("ITEM_CD"));
				dto.setITEM_NM(rs.getString("ITEM_NM"));
				dto.setCHCKR_NM(rs.getString("CHCKR_NM"));
				dto.setCHCKR_DTTM(rs.getDate("CHCKR_DTTM"));
				dto.setSTRTH_VAL(rs.getInt("STRTH_VAL"));
				dto.setSZ_VAL(rs.getInt("SZ_VAL"));
				dto.setCLRL_VAL(rs.getString("CLRL_VAL"));
				dto.setQLTY_VAL(rs.getInt("QLTY_VAL"));
				dto.setFAIL_CAUS_DESC(rs.getString("FAIL_CAUS_DESC"));
				dto.setRMRK(rs.getString("RMRK"));
			
				
				list.add(dto);
				System.out.println("조회 중");
			}
			System.out.println("조회 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}
	
	
	// 삽입
	public int insertQCreport(TB_QA_1100DT_DTO dto) {

		System.out.println("TB_QA_1100DT insertQCreport 실행");
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
			// 생산 테이블에서 생산이 완료된 것들만 qa테이블에 데이터 삽입
			String query =  " insert into TB_QA_1100DT (PROD_CD, ITEM_CD, ITEM_NM, CHCKR_NM, CHCKR_DTTM, STRTH_VAL, SZ_VAL, CLRL_VAL, QLTY_VAL, FAIL_CAUS_DESC, RMRK) ";
				   query += " values (?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?) ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getPROD_CD());
			ps.setString(2, dto.getITEM_CD());
			ps.setString(3, dto.getITEM_NM());
			ps.setString(4, dto.getCHCKR_NM());
			ps.setInt(5, dto.getSTRTH_VAL());
			ps.setInt(6, dto.getSZ_VAL());
			ps.setString(7, dto.getCLRL_VAL());
			ps.setInt(8, dto.getQLTY_VAL());
			ps.setString(9, dto.getFAIL_CAUS_DESC());
			ps.setString(10, dto.getRMRK());
			
			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//							ResultSet rs = ps.executeQuery();

			// int에는 영양받은 줄의 수
			result = ps.executeUpdate();

			System.out.println("삽입 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}
	
	
	// 수정
	public int updateQCreport(TB_QA_1100DT_DTO dto) {

		System.out.println("TB_QA_1100DT updateQCreport 실행");
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
			// 생산 테이블에서 생산이 완료된 것들만 qa테이블에 데이터 수정
			String query =  " update TB_QA_1100DT ";
				   query += " set CHCKR_NM = ?, CHCKR_DTTM = ?, STRTH_VAL = ?, SZ_VAL = ?, ";
				   query +=	" CLRL_VAL = ?, QLTY_VAL = ?, FAIL_CAUS_DESC = ?, RMRK = ? ";
				   query += " where PROD_CD = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);			
			ps.setString(1, dto.getCHCKR_NM());
			ps.setDate(2, dto.getCHCKR_DTTM());
			ps.setInt(3, dto.getSTRTH_VAL());
			ps.setInt(4, dto.getSZ_VAL());
			ps.setString(5, dto.getCLRL_VAL());
			ps.setInt(6, dto.getQLTY_VAL());
			ps.setString(7, dto.getFAIL_CAUS_DESC());
			ps.setString(8, dto.getRMRK());
			ps.setString(9, dto.getPROD_CD());
			
			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//							ResultSet rs = ps.executeQuery();

			// int에는 영양받은 줄의 수
			result = ps.executeUpdate();

			System.out.println("삽입 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}
	
	
	// 삭제
	public int deleteQCreport(TB_QA_1100DT_DTO dto) {

		System.out.println("TB_QA_1100DT deleteQCreport 실행");
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
			// 생산 테이블에서 생산이 완료된 것들만 qa테이블에 데이터 삽입
			String query =  " delete from TB_QA_1100DT ";
				   query += " where PROD_CD = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getPROD_CD());
			
			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//							ResultSet rs = ps.executeQuery();

			// int에는 영양받은 줄의 수
			result = ps.executeUpdate();

			System.out.println("삽입 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}
	
	
}
