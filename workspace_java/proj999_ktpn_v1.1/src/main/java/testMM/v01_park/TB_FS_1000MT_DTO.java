package testMM.v01_park;

public class TB_FS_1000MT_DTO {

	// 완제품 현재 재고 테이블
	
	private String FNSH_CODE;            // 완제품 코드
	private String FNSH_NM;              // 완제품명
	private int CRNT_AFTR_CNT;           // 변동 후 수량
	private String FNSH_LOC_NM;          // 완제품 위치
	
	
	public String getFNSH_CODE() {
		return FNSH_CODE;
	}
	public void setFNSH_CODE(String fNSH_CODE) {
		FNSH_CODE = fNSH_CODE;
	}
	public String getFNSH_NM() {
		return FNSH_NM;
	}
	public void setFNSH_NM(String fNSH_NM) {
		FNSH_NM = fNSH_NM;
	}
	public String getFNSH_LOC_NM() {
		return FNSH_LOC_NM;
	}
	public void setFNSH_LOC_NM(String fNSH_LOC_NM) {
		FNSH_LOC_NM = fNSH_LOC_NM;
	}
	public int getCRNT_AFTR_CNT() {
		return CRNT_AFTR_CNT;
	}
	public void setCRNT_AFTR_CNT(int cRNT_AFTR_CNT) {
		CRNT_AFTR_CNT = cRNT_AFTR_CNT;
	}
	
	
	@Override
	public String toString() {
		return "TB_FS_1000MT_DTO [FNSH_CODE=" + FNSH_CODE + ", FNSH_NM=" + FNSH_NM + ", FNSH_LOC_NM=" + FNSH_LOC_NM
				+ ", CRNT_AFTR_CNT=" + CRNT_AFTR_CNT + "]";
	}
	
	
}
