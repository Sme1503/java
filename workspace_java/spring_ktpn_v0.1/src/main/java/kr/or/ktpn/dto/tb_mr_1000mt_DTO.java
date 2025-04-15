package kr.or.ktpn.dto;

import lombok.Data;

@Data
public class tb_mr_1000mt_DTO {

	// 원자재 현재 재고 테이블

	private String mtrl_cd; // 원자재코드
	private String mtrl_nm; // 원자재명
	private int stn_cnt; // 기준수량
	private int crnt_aftr_cnt; // 변동 후 수량
	private String ordr_rqrd_yn; // 주문필요여부
	private String mtrl_loc_nm; // 원자재위치
}
