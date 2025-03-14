package testMM.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TB_MR_1000MT_DAO {

	// 원자재 현재 재고 테이블의 CRUD

	// 조회
	public List selectCurrentM() {

		System.out.println("TB_MR_1000MT selectCurrentM 실행");

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
			String query = "select * from TB_MR_1000MT ";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_MR_1000MT_DTO dto = new TB_MR_1000MT_DTO();

				dto.setMTRL_CD(rs.getString("MTRL_CD"));
				dto.setMTRL_NM(rs.getString("MTRL_NM"));
				dto.setSTN_CNT(rs.getInt("STN_CNT"));
				dto.setCRNT_AFTR_CNT(rs.getInt("CRNT_AFTR_CNT"));
				dto.setORDR_RQRD_YN(rs.getString("ORDR_RQRD_YN"));
				dto.setMTRL_LOC_NM(rs.getString("MTRL_CD_NM"));

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
	/*
	 * 삽입 흐름 -> 원자재로그 테이블에 값을 넣은 다음 그 값을 가져와서 원자재 현황테이블에 넣는 것이 아니고 -> 원자재로그 테이블에 값을
	 * 넣고, 원자재 현황테이블에도 바로 값을 넣는다
	 */
	public int insertCurrentM(TB_MR_1000MT_DTO dto) {

		System.out.println("TB_MR_1000MT insertCurrentM 실행");
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
			// 원자재 로그 테이블에 데이터 삽입
			String query = "insert into TB_MR_1000MT (MTRL_CD, MTRL_NM, STN_CNT, ORDR_RQRD_YN, ";
			query += " MTRL_LOC_NM, CRNT_AFTR_CNT) ";
			query += " values ( ?, ?, ?, ?, ?, ?) ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getMTRL_CD());
			ps.setString(2, dto.getMTRL_NM());
			ps.setInt(3, dto.getSTN_CNT());

			ps.setString(5, dto.getORDR_RQRD_YN());

			ps.setString(8, dto.getMTRL_LOC_NM());

			ps.setInt(10, dto.getCRNT_AFTR_CNT());

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
	public int updateCurrentM(TB_MR_1000MT_DTO dto, int i, int j) {

		// i는 입출고 구분
		// j는 변동 수량

		System.out.println("TB_MR_1000MT updateDealCompany 실행");

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
			String orderYN = null;

			String query = null;
			PreparedStatement ps = null;

			if (i != null) { // i가 null이 아니면
				if (i == 0) { // i가 0이면 입고
					int k = dto.getCRNT_AFTR_CNT();
					dto.setCRNT_AFTR_CNT(k + j);

					if (dto.getCRNT_AFTR_CNT() != null) { // 변동 후 수량이 null이 아니면 -> 방어코드

					}
					if (dto.getSTN_CNT() > dto.getCRNT_AFTR_CNT()) { // 기준 수량이 변동 후 수량보다 크면
						orderYN = "Y"; // 주문 필요를 Y로 한다
					} else {
						orderYN = "N"; // 주문 필요를 N으로 한다
					}

					query = " update TB_MR_1000MT ";
					query += " set ORDR_RQRD_YN = ?, MTRL_LOC_NM = ?, CRNT_AFTR_CNT = ? ";
					query += " where MTRL_CD = ? ";

					ps = con.prepareStatement(query);
					// 물음표에 값을 넣어라
					ps.setString(1, orderYN);
					ps.setString(2, dto.getMTRL_LOC_NM());
					ps.setInt(3, dto.getCRNT_AFTR_CNT());
					ps.setString(4, dto.getMTRL_CD());

				} else if (i == 1) { // i가 1이면 출고
					int k = dto.getCRNT_AFTR_CNT();

					if ((k - j) < 0) {
						System.out.println("입력 오류! 결과 재고값이 0보다 작습니다.");
						
						return result;		// result = -1
					} else {
						dto.setCRNT_AFTR_CNT(k - j);

						query = " update TB_MR_1000MT ";
						query += " set STN_CNT = ?, ORDR_RQRD_YN = ?, MTRL_LOC_NM = ?, CRNT_AFTR_CNT = ? ";
						query += " where MTRL_CD = ? ";

						ps = con.prepareStatement(query);
						// 물음표에 값을 넣어라
						ps.setString(1, dto.get); // 내일 하기
						ps.setString(1, dto.get);
						ps.setString(1, dto.get);
						ps.setString(1, dto.get);
						ps.setString(1, dto.get);
					}

				}
			} else {
				System.out.println("오류 : 입출력값이 없음 ");
			}

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//						ResultSet rs = ps.executeQuery();

			// int에는 영양받은 줄의 수
			result = ps.executeUpdate();

			System.out.println("수정 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	// 삭제
}
