package kr.or.ktpn.dto;

import lombok.Data;

@Data
public class tb_fs_1000mt_DTO {

	// 완제품 현재 재고 테이블

	private String fnsh_code;		// 완제품 코드
	private String fnsh_nm; 		// 완제품명
	private int crnt_aftr_cnt; 	// 변동 후 수량
	private String fnsh_loc_nm; 	// 완제품 위치
}
