package testMM.v01_park;


public class TB_OD_1000MT_DTO {

	// 거래처 테이블
	
	
	private String CSTMR_CODE;					// 거래처 코드
	private String CMP_NM;						// 회사명			
	private String MNGR_NM;						// 담당자명
	private String TEL_NO;						// 연락처번호
	private String TRN_ITM_ITEM_NM;				// 거래품목명
	private String REG_DT;						// 입력일자
	private String MOD_DT;						// 수정일자
	
	
	public String getCSTMR_CODE() {
		return CSTMR_CODE;
	}
	public void setCSTMR_CODE(String cSTMR_CODE) {
		CSTMR_CODE = cSTMR_CODE;
	}
	public String getCMP_NM() {
		return CMP_NM;
	}
	public void setCMP_NM(String cMP_NM) {
		CMP_NM = cMP_NM;
	}
	public String getMNGR_NM() {
		return MNGR_NM;
	}
	public void setMNGR_NM(String mNGR_NM) {
		MNGR_NM = mNGR_NM;
	}
	public String getTEL_NO() {
		return TEL_NO;
	}
	public void setTEL_NO(String tEL_NO) {
		TEL_NO = tEL_NO;
	}
	public String getTRN_ITM_ITEM_NM() {
		return TRN_ITM_ITEM_NM;
	}
	public void setTRN_ITM_ITEM_NM(String tRN_ITM_ITEM_NM) {
		TRN_ITM_ITEM_NM = tRN_ITM_ITEM_NM;
	}
	public String getREG_DT() {
		return REG_DT;
	}
	public void setREG_DT(String rEG_DT) {
		REG_DT = rEG_DT;
	}
	public String getMOD_DT() {
		return MOD_DT;
	}
	public void setMOD_DT(String mOD_DT) {
		MOD_DT = mOD_DT;
	}
	
	
	@Override
	public String toString() {
		return "TB_OD_1000MT_DTO [CSTMR_CODE=" + CSTMR_CODE + ", CMP_NM=" + CMP_NM + ", MNGR_NM=" + MNGR_NM
				+ ", TEL_NO=" + TEL_NO + ", TRN_ITM_ITEM_NM=" + TRN_ITM_ITEM_NM + ", REG_DT=" + REG_DT + ", MOD_DT="
				+ MOD_DT + "]";
	}
	
	
}
