package kr.or.ktpn.dto;

import lombok.Data;

@Data
public class tb_od_1000mt_DTO {

	// 거래처 테이블

	private String cstmr_code; // 거래처 코드
	private String cmp_nm; // 회사명
	private String mngr_nm; // 담당자명
	private String tel_no; // 연락처번호
	private String trn_itm_item_nm; // 거래품목명
	private String reg_dt; // 입력일자
	private String mod_dt; // 수정일자
}
