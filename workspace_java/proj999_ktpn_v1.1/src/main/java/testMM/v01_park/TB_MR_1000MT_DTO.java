package testMM.v01_park;

public class TB_MR_1000MT_DTO {

	// 원자재 현재 재고 테이블
	
	private String MTRL_CD;				    // 원자재코드
	private String MTRL_NM;                // 원자재명
	private int STN_CNT;                   // 기준수량
	private int CRNT_AFTR_CNT;             // 변동 후 수량
	private String ORDR_RQRD_YN;           // 주문필요여부
	private String MTRL_LOC_NM;            // 원자재위치
	
	public String getMTRL_CD() {
		return MTRL_CD;
	}
	public void setMTRL_CD(String mTRL_CD) {
		MTRL_CD = mTRL_CD;
	}
	public String getMTRL_NM() {
		return MTRL_NM;
	}
	public void setMTRL_NM(String mTRL_NM) {
		MTRL_NM = mTRL_NM;
	}
	public int getSTN_CNT() {
		return STN_CNT;
	}
	public void setSTN_CNT(int sTN_CNT) {
		STN_CNT = sTN_CNT;
	}
	public int getCRNT_AFTR_CNT() {
		return CRNT_AFTR_CNT;
	}
	public void setCRNT_AFTR_CNT(int cRNT_AFTR_CNT) {
		CRNT_AFTR_CNT = cRNT_AFTR_CNT;
	}
	public String getORDR_RQRD_YN() {
		return ORDR_RQRD_YN;
	}
	public void setORDR_RQRD_YN(String oRDR_RQRD_YN) {
		ORDR_RQRD_YN = oRDR_RQRD_YN;
	}
	public String getMTRL_LOC_NM() {
		return MTRL_LOC_NM;
	}
	public void setMTRL_LOC_NM(String mTRL_LOC_NM) {
		MTRL_LOC_NM = mTRL_LOC_NM;
	}
	
	@Override
	public String toString() {
		return "TB_MR_1000MT_DTO [MTRL_CD=" + MTRL_CD + ", MTRL_NM=" + MTRL_NM + ", STN_CNT=" + STN_CNT
				+ ", CRNT_AFTR_CNT=" + CRNT_AFTR_CNT + ", ORDR_RQRD_YN=" + ORDR_RQRD_YN + ", MTRL_LOC_NM=" + MTRL_LOC_NM
				+ "]";
	}
	
	
}
