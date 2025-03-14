package testMM.v01_park;

import java.sql.Date;

public class TB_FS_1000HT_DTO {

	// 완제품 로그 테이블
	
	private int SN;						// 순번
	private String FNSH_CODE;           	// 완제품코드
	private String FNSHD_ITEM_NM;       	// 완제품명
	private int CRNT_CNT;               	// 변동수량
	private int CRNT_AFTR_CNT;          	// 변동 후 수량
	private String CHNG_DT;             	// 변동일자
	private String IOB_SE_CD;           	// 변동(입출고)구분코드
	private String WORK_NM;             	// 작업자명
	private String FNSHL_LOC_NM;        	// 완제품위치명
	private String RMRK;                	// 비고
	private Date REG_DTTM;              	// 입력일시
	
	public int getSN() {
		return SN;
	}
	public void setSN(int sN) {
		SN = sN;
	}
	public String getFNSH_CODE() {
		return FNSH_CODE;
	}
	public void setFNSH_CODE(String fNSH_CODE) {
		FNSH_CODE = fNSH_CODE;
	}
	public String getFNSHD_ITEM_NM() {
		return FNSHD_ITEM_NM;
	}
	public void setFNSHD_ITEM_NM(String fNSHD_ITEM_NM) {
		FNSHD_ITEM_NM = fNSHD_ITEM_NM;
	}
	public int getCRNT_CNT() {
		return CRNT_CNT;
	}
	public void setCRNT_CNT(int cRNT_CNT) {
		CRNT_CNT = cRNT_CNT;
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
	public String getFNSHL_LOC_NM() {
		return FNSHL_LOC_NM;
	}
	public void setFNSHL_LOC_NM(String fNSHL_LOC_NM) {
		FNSHL_LOC_NM = fNSHL_LOC_NM;
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
	
	@Override
	public String toString() {
		return "TB_FS_1000HT_DTO [SN=" + SN + ", FNSH_CODE=" + FNSH_CODE + ", FNSHD_ITEM_NM=" + FNSHD_ITEM_NM
				+ ", CRNT_CNT=" + CRNT_CNT + ", CRNT_AFTR_CNT=" + CRNT_AFTR_CNT + ", CHNG_DT=" + CHNG_DT
				+ ", IOB_SE_CD=" + IOB_SE_CD + ", WORK_NM=" + WORK_NM + ", FNSHL_LOC_NM=" + FNSHL_LOC_NM + ", RMRK="
				+ RMRK + ", REG_DTTM=" + REG_DTTM + "]";
	}
	
	
}
