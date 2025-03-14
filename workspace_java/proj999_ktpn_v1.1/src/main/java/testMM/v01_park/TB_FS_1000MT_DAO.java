package testMM.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TB_FS_1000MT_DAO {

	// 완제품 현재 재고 테이블의 CRUD
	
	// 조회
	public List selectPLog() {

		System.out.println("TB_FS_1000HT selectPLog 실행");

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
			String query = "select * from TB_FS_1000HT ";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_FS_1000HT_DTO dto = new TB_FS_1000HT_DTO();

				dto.setSN(rs.getInt("SN"));
				dto.setFNSH_CODE(rs.getString("FNSH_CODE"));
				dto.setFNSHD_ITEM_NM(rs.getString("FNSHD_ITEM_NM"));
				dto.setCRNT_CNT(rs.getInt("CRNT_CNT"));
				dto.setCRNT_AFTR_CNT(rs.getInt("CRNT_AFTR_CNT"));
				dto.setCHNG_DT(rs.getString("CHNG_DT"));
				dto.setIOB_SE_CD(rs.getString("IOB_SE_CD"));
				dto.setWORK_NM(rs.getString("WORK_NM"));
				dto.setFNSHL_LOC_NM(rs.getString("FNSHL_LOC_NM"));
				dto.setRMRK(rs.getString("RMRK"));
				dto.setREG_DTTM(rs.getDate("REG_DTTM"));
				
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
	
	
	// 수정
	
	
	// 삭제
	
}
