package testQA.v01_park;

import java.sql.Date;

public class TB_QA_1100DT_DTO {

	// 생산코드빼고 생산 부분이 없는 QA리포트 테이블 // 생산 코드로 생산테이블과 조인해서 조회
	
	private String PROD_CD;					   // 생산코드
	private String ITEM_CD;                   // 품목코드
	private String ITEM_NM;                   // 품목명
	private String CHCKR_NM;                  // 검수자명
	private Date CHCKR_DTTM;                  // 검수일시
	private int STRTH_VAL;                    // 강도값
	private int SZ_VAL;                       // 크기값
	private String CLRL_VAL;                  // 색상값
	private int QLTY_VAL;                     // 픔질값
	private String FAIL_CAUS_DESC;            // 불합격사유내용
	private String RMRK;                      // 비고
	
	
	public String getPROD_CD() {
		return PROD_CD;
	}
	public void setPROD_CD(String pROD_CD) {
		PROD_CD = pROD_CD;
	}
	public String getITEM_CD() {
		return ITEM_CD;
	}
	public void setITEM_CD(String iTEM_CD) {
		ITEM_CD = iTEM_CD;
	}
	public String getITEM_NM() {
		return ITEM_NM;
	}
	public void setITEM_NM(String iTEM_NM) {
		ITEM_NM = iTEM_NM;
	}
	public String getCHCKR_NM() {
		return CHCKR_NM;
	}
	public void setCHCKR_NM(String cHCKR_NM) {
		CHCKR_NM = cHCKR_NM;
	}
	public Date getCHCKR_DTTM() {
		return CHCKR_DTTM;
	}
	public void setCHCKR_DTTM(Date cHCKR_DTTM) {
		CHCKR_DTTM = cHCKR_DTTM;
	}
	public int getSTRTH_VAL() {
		return STRTH_VAL;
	}
	public void setSTRTH_VAL(int sTRTH_VAL) {
		STRTH_VAL = sTRTH_VAL;
	}
	public int getSZ_VAL() {
		return SZ_VAL;
	}
	public void setSZ_VAL(int sZ_VAL) {
		SZ_VAL = sZ_VAL;
	}
	public String getCLRL_VAL() {
		return CLRL_VAL;
	}
	public void setCLRL_VAL(String cLRL_VAL) {
		CLRL_VAL = cLRL_VAL;
	}
	public int getQLTY_VAL() {
		return QLTY_VAL;
	}
	public void setQLTY_VAL(int qLTY_VAL) {
		QLTY_VAL = qLTY_VAL;
	}
	public String getFAIL_CAUS_DESC() {
		return FAIL_CAUS_DESC;
	}
	public void setFAIL_CAUS_DESC(String fAIL_CAUS_DESC) {
		FAIL_CAUS_DESC = fAIL_CAUS_DESC;
	}
	public String getRMRK() {
		return RMRK;
	}
	public void setRMRK(String rMRK) {
		RMRK = rMRK;
	}
	
	
	@Override
	public String toString() {
		return "TB_QA_1100DT_DTO [PROD_CD=" + PROD_CD + ", ITEM_CD=" + ITEM_CD + ", ITEM_NM=" + ITEM_NM + ", CHCKR_NM="
				+ CHCKR_NM + ", CHCKR_DTTM=" + CHCKR_DTTM + ", STRTH_VAL=" + STRTH_VAL + ", SZ_VAL=" + SZ_VAL
				+ ", CLRL_VAL=" + CLRL_VAL + ", QLTY_VAL=" + QLTY_VAL + ", FAIL_CAUS_DESC=" + FAIL_CAUS_DESC + ", RMRK="
				+ RMRK + "]";
	}
	
	
}
