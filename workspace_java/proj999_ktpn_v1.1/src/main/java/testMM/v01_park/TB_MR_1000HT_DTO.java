package testMM.v01_park;

import java.sql.Date;

public class TB_MR_1000HT_DTO {
	
	// 원자재 로그 테이블
	
	private int SN;					// 순번
	private String MTRL_CD;				// 원자재코드
	private String MTRL_NM;            // 원자재명
	private int STN_CNT;               // 기준수량
	private int CRNT_CNT;              // 변동수량
	private int CRNT_AFTR_CNT;         // 변동 후 수량
	private String CHNG_DT;            // 변동일자	
	private String IOB_SE_CD;          // 변동(입출고)구분코드
	private String ORDR_RQRD_YN;       // 주문필요여부
	private String WORK_NM;            // 작업자명
	private String MTRL_CD_NM;         // 원자재위치명
	private String RMRK;               // 비고
	private Date REG_DTTM;             // 입력일시
	
	
	public int getSN() {
		return SN;
	}
	public void setSN(int sN) {
		SN = sN;
	}
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
	public int getCRNT_CNT() {
		return CRNT_CNT;
	}
	public void setCRNT_CNT(int cRNT_CNT) {
		CRNT_CNT = cRNT_CNT;
	}
	public String getORDR_RQRD_YN() {
		return ORDR_RQRD_YN;
	}
	public void setORDR_RQRD_YN(String oRDR_RQRD_YN) {
		ORDR_RQRD_YN = oRDR_RQRD_YN;
	}
	public String getIOB_SE_CD() {
		return IOB_SE_CD;
	}
	public void setIOB_SE_CD(String iOB_SE_CD) {
		IOB_SE_CD = iOB_SE_CD;
	}
	public String getWORK_NM() {
		return WORK_NM;
	}
	public void setWORK_NM(String wORK_NM) {
		WORK_NM = wORK_NM;
	}
	public String getMTRL_CD_NM() {
		return MTRL_CD_NM;
	}
	public void setMTRL_CD_NM(String mTRL_CD_NM) {
		MTRL_CD_NM = mTRL_CD_NM;
	}
	public String getRMRK() {
		return RMRK;
	}
	public void setRMRK(String rMRK) {
		RMRK = rMRK;
	}
	public Date getREG_DTTM() {
		return REG_DTTM;
	}
	public void setREG_DTTM(Date rEG_DTTM) {
		REG_DTTM = rEG_DTTM;
	}
	public int getCRNT_AFTR_CNT() {
		return CRNT_AFTR_CNT;
	}
	public void setCRNT_AFTR_CNT(int cRNT_AFTR_CNT) {
		CRNT_AFTR_CNT = cRNT_AFTR_CNT;
	}
	public String getCHNG_DT() {
		return CHNG_DT;
	}
	public void setCHNG_DT(String cHNG_DT) {
		CHNG_DT = cHNG_DT;
	}
	
	
	@Override
	public String toString() {
		return "TB_MR_1000HT_DTO [SN=" + SN + ", MTRL_CD=" + MTRL_CD + ", MTRL_NM=" + MTRL_NM + ", STN_CNT=" + STN_CNT
				+ ", CRNT_CNT=" + CRNT_CNT + ", ORDR_RQRD_YN=" + ORDR_RQRD_YN + ", IOB_SE_CD=" + IOB_SE_CD
				+ ", WORK_NM=" + WORK_NM + ", MTRL_CD_NM=" + MTRL_CD_NM + ", RMRK=" + RMRK + ", REG_DTTM=" + REG_DTTM
				+ ", CRNT_AFTR_CNT=" + CRNT_AFTR_CNT + ", CHNG_DT=" + CHNG_DT + "]";
	}
	
	
}
