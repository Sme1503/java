select * from tb_md_1000mt;
// 기준관리 테이블

select * from tb_mr_1000mt;
// 원자재 현황 테이블

delete from tb_mr_1000mt;
commit;

insert into TB_MR_1000MT (MTRL_CD, MTRL_NM)select mt_mng_cd, mt_mng_nm from tb_md_1000mt where mt_mng_cd like 'M%';
// 원자재 현황 테이블에 데이터 삽입
// 기준관리에서 원자재코드랑 이름 가져오기 - 성공
// 코드와 이름을 제외 나머지는 널로
// 나머지도 데이터를 넣을 때는 어떻게?

update tb_mr_1000mt set CRNT_AFTR_CNT = CRNT_AFTR_CNT + ? where MTRL_CD like 'M0004';
// 만약 입고면 더하기, ?의 값은 사용자가 입력한 값
update tb_mr_1000mt set CRNT_AFTR_CNT = CRNT_AFTR_CNT - 1000 where MTRL_CD like 'M0004';
// 만약 출고면 빼기, ?의 값은 사용자가 입력한 값, 결과값이 0보다 작으면 안된다
// 원자재 현황 테이블 데이터 수정

commit;
select * from tb_mr_1000ht;
// 원자재 로그 테이블

insert into tb_mr_1000ht (sn, crnt_cnt, CRNT_AFTR_CNT) values ('M'||LPAD(SQ_MR_1000HT.NEXTVAL, 4, '0'), 1000, 
1000 + select CRNT_AFTR_CNT from tb_mr_1000ht where sn like 'M0002');
// 원자재 로그 테이블 데이터 삽입 // 잘못된 쿼리

insert into tb_mr_1000ht (sn, crnt_cnt, CRNT_AFTR_CNT) // 시퀀스, 변동 수량, 변동 후 수량, 입고일 때
select 'M'||LPAD(SQ_MR_1000HT.NEXTVAL, 4, '0') as sn , 1000 as crnt_cnt , CRNT_AFTR_CNT + 1000 from tb_mr_1000mt where MTRL_CD like 'M0004';
// 원자재 로그 테이블 데이터 삽입 // 올바른 쿼리


select 'M'||LPAD(SQ_MR_1000HT.NEXTVAL, 4, '0') as sn 
     , 1000 as crnt_cnt 
     , CRNT_AFTR_CNT + 1000 
 from tb_mr_1000mt 
where MTRL_CD like 'M0004';

select * from tb_mr_1000ht;
select * from tb_mr_1000mt;

update tb_mr_1000mt set CRNT_AFTR_CNT = 3000 where MTRL_CD like 'M0004';
commit;

insert into tb_mr_1000ht (CRNT_AFTR_CNT, sn, crnt_cnt)
select CRNT_AFTR_CNT + 1000 from tb_mr_1000mt where MTRL_CD like 'M0004' as CRNT_AFTR_CNT, 'M'||LPAD(SQ_MR_1000HT.NEXTVAL, 4, '0') as sn , 1000 as crnt_cnt;
// 원자재 로그 테이블 데이터 삽입 // 위의 올바른 쿼리에서 컬럼 순서를 바꾼 쿼리

select * from tb_fs_1000mt;
// 완제품 현황 테이블

insert into tb_fs_1000mt (FNSH_CODE, FNSH_NM) select mt_mng_cd, mt_mng_nm from tb_md_1000mt where mt_mng_cd like 'P%';
// 완제품 현황 테이블에 데이터 삽입
// 지금은 완제품 코드와 완제품명만 넣지만 실제로는 생산 테이블에서 생산완료인 생산코드의 생산량을 입력
// 조건 : select 생산량 from 생산 where 생산완료 like 'Y';

update tb_fs_1000mt set CRNT_AFTR_CNT = CRNT_AFTR_CNT + ? where FNSH_CODE like 'P0006';
// 만약 입고면 더하기, ?의 값은 생산테이블의 생산완료인 생산코드의 생산량

update tb_fs_1000mt set CRNT_AFTR_CNT = CRNT_AFTR_CNT - ? where FNSH_CODE like 'P0006';
// 만약 출고면 빼기, ?의 값은 사용자가 입력한 값, 결과값이 0보다 작으면 안된다. 
// 완제품 현황 테이블 데이터 수정

select * from tb_fs_1000ht;
// 완제품 로그 테이블

insert into tb_fs_1000ht (sn, crnt_cnt, CRNT_AFTR_CNT) // 시퀀스, 변동 수량, 변동 후 수량, 입고일 때
select 'P'||LPAD(SQ_FS_1000HT.NEXTVAL, 4, '0'),        // 시퀀스 값 1씩 증가
prod_qntt from TB_PR_1100MT where PROD_END_YN like 'Y' and PROD_CD like '',  // 생산테이블에서 생산완료인 생산코드의 생산량
CRNT_AFTR_CNT + prod_qntt from tb_fs_1000mt where where FNSH_CODE like 'P0006'


// 완제품 로그 테이블에서 변동 후 수량을 계산 하는 쿼리 -> 안좋음
insert into tb_fs_1000ht (sn, PROD_CD,crnt_cnt, CRNT_AFTR_CNT) // 시퀀스, 변동 수량, 변동 후 수량, 입고일 때
select 'P'||LPAD(SQ_FS_1000HT.NEXTVAL, 4, '0'),        // 시퀀스 값 1씩 증가
        a.PROD_CD           // 생산 테이블에서 생산완료인 생산코드
        a.prod_qntt         // 생산 테이블에서 생산완료인 생산코드의 생산량
      , b.CRNT_AFTR_CNT + a.prod_qntt // 생산량과 완제품 현황 테이블에서  완제품 코드가 'P0006'인 변동 후 수량 더하기
   from TB_PR_1100MT a      // 생산 테이블
      , tb_fs_1000mt b      // 완제품 현황 테이블
  where PROD_END_YN like 'Y' // 생산테이블에서 생산완료가 'y'
    and PROD_CD like '',  // 생산테이블에서 생산완료인 생산코드의 생산량
    and FNSH_CODE like 'P0006';     // 완제품 현황 테이블에서 완제품 코드가 'P0006'
 from where FNSH_CODE like 'P0006';     // 완제품 현황 테이블에서 완제품 코드가 'P0006'


update tb_fs_1000mt set CRNT_AFTR_CNT = CRNT_AFTR_CNT + (생산량) where FNSH_CODE like 'P0006';
// 완제품 현황 테이블에서 변동 후 수량을 계산하는 쿼리

update tb_fs_1000mt set CRNT_AFTR_CNT = CRNT_AFTR_CNT + (
select PROD_QNTT 
  from TB_PR_1100MT 
 where PROD_END_YN like 'Y'
   and PROD_CD like '?')
 where FNSH_CODE like 'P0006';
   
update tb_fs_1000mt 
   set CRNT_AFTR_CNT = CRNT_AFTR_CNT + (
select PROD_QNTT 
  from TB_PR_1100MT 
 where PROD_END_YN like 'Y'
   and PROD_CD like '?'
   and FNSH_CODE like 'P0006';
   
   
select * from TB_PR_1100MT;
insert into TB_PR_1100MT (PROD_CD, ITEM_CD, PROD_QNTT, PROD_END_YN) values ('S0001', 'P0001', 1000, 'Y');
commit;

INSERT INTO TB_PR_1000MT (PROD_CD) VALUES ('S0001');

MERGE INTO TB_FS_1000MT T
     USING (select A.PROD_QNTT 
              from TB_PR_1100MT A
             where A.PROD_END_YN = 'Y'
               and A.PROD_CD = 'S0001'
--               AND A.ITEM_CD = 'P0006'
           ) S
        ON (T.FNSH_CODE = S.ITEM_CD)
   WHEN MATCHED THEN
              UPDATE SET T.CRNT_AFTR_CNT = (T.CRNT_AFTR_CNT + S.PROD_QNTT);
              
update tb_fs_1000mt set CRNT_AFTR_CNT = 1000;
commit;

MERGE INTO TB_FS_1000MT T
     USING (SELECT A.PROD_QNTT
                 , A.ITEM_CD
              FROM TB_PR_1100MT A
             WHERE A.PROD_END_YN = 'Y'
               AND A.PROD_CD = ?
           ) S
        ON (T.FNSH_CODE = S.ITEM_CD)
   WHEN MATCHED THEN
              UPDATE SET T.CRNT_AFTR_CNT = (T.CRNT_AFTR_CNT + S.PROD_QNTT);
              
alter table TB_FS_1000HT add PROD_CD VARCHAR2(100);   
              
alter table TB_FS_1000HT add constraint fk_prod_cd
foreign key(PROD_CD) references TB_PR_1100MT(PROD_CD);


select * from TB_PR_1100MT;


// 로그 테이블에서 마지막에 입력한 잘못된 로그의 바로 이전 로그 찾기
// 2가 아니라 1로 하면 마지막에 입력한 잘못된 로그
select a.*
  from (
        select a.*, rownum as rn
          from TB_MR_1000HT a
         where a.MTRL_CD = 'M0004'
        order by a.sn desc
      ) a
 where a.rn = 2;
 
 select a.*, rownum as rn
          from TB_MR_1000HT a
         where a.MTRL_CD = 'M0004'
        order by a.sn desc;
 
commit;
select * from TB_MR_1000MT; 
select * from TB_FS_1000HT;
select * from TB_QA_1100DT;
select * from TB_QA_1000DT;

select * from TB_MR_1000HT;

insert into TB_MR_1000HT
values (SQ_MR_1000HT.NEXTVAL, 'M0004', '염화비닐', 1000, 1000, 'y', 'i', '김철수', 'm창고', '없음', sysdate, 1500, to_char(sysdate, 'yyyymmdd'));

select * from TB_QA_1100DT;
insert into TB_QA_1100DT(PROD_CD, ITEM_CD, ITEM_NM) values ('S0001', 'ss-01', '싹싹지우개');

// 품질 테이블에 데이터 삽입
insert into TB_QA_1100DT(PROD_CD, ITEM_CD, ITEM_NM) values ('S0002', 'ss-01', '싹싹지우개');
insert into TB_QA_1100DT(PROD_CD, ITEM_CD, ITEM_NM) values ('S0003', 'ss-01', '싹싹지우개');
insert into TB_QA_1100DT(PROD_CD, ITEM_CD, ITEM_NM) values ('S0004', 'ss-01', '싹싹지우개');

// 품질 테이블에 데이터 삭제
delete from TB_QA_1100DT where PROD_CD = 'S0002' or PROD_CD = 'S0003' or PROD_CD = 'S0004';
commit;

select * from TB_PR_1100MT;
update TB_PR_1100MT 
set ITEM_NM = '싹싹지우개', ITEM_CD = 'ss-01'
where PROD_CD = 'S0001';

// 생산 테이블에 불량률 컬럼 추가
alter table TB_PR_1100MT add DFC_RT NUMBER;

// 생산 테이블과 품질 테이블 조인
select * 
  from TB_QA_1100DT qa
     , TB_PR_1100MT pr 
 where qa.PROD_CD = pr.PROD_CD and qa.ITEM_CD = pr.ITEM_CD and qa.ITEM_NM = pr.ITEM_NM;

// 조인한 테이블에서 생산코드가 'S0001'인 데이터 조회, 서브쿼리 안에 *을 쓰면 컬럼의 정의가 애매하다는 오류가 떠서 테이블.컬럼을 해야한다
select j.* 
  from (
        select *    // qa.prod_cd, ... 표시할 값을 지정해야한다
         from TB_QA_1100DT qa, TB_PR_1100MT pr 
        where qa.PROD_CD = pr.PROD_CD ) j
 where j.PROD_CD = 'S0001';

// 조인한 테이블에서 생산코드가 'S0001'인 데이터 조회,  *만 쓰면 조인할 때 쓴 컬럼이 중복되서 나온다
  select *
   from TB_QA_1100DT qa, TB_PR_1100MT pr 
 where qa.PROD_CD = pr.PROD_CD
   and qa.PROD_CD = 'S0001';

// 조인한 테이블에서 생산코드가 'S0001'인 데이터 조회, 테이블.컬럼을 쓴 조인 쿼리문 
   select pr.PROD_CD, pr.ITEM_CD, pr.ITEM_NM, pr.WORK_NM, pr.PROD_END_TIME, pr.INDC_QNTT, pr.PROD_QNTT, pr.DFC_RT,
          qa.CHCKR_NM, qa.CHCKR_DTTM, qa.STRTH_VAL, qa.SZ_VAL, qa.CLRL_VAL, qa.QLTY_VAL, qa.FAIL_CAUS_DESC, qa.RMRK
   from TB_QA_1100DT qa, TB_PR_1100MT pr 
 where qa.PROD_CD = pr.PROD_CD
   and qa.PROD_CD = upper('D0026');
   
select * from TB_MB_1000MT where MBR_SENM = '일반회원';


// 테이블 정리 - 기본키 설정
// 품질 테이블
select * from TB_QA_1100DT;
delete from TB_QA_1100DT;
commit;
alter table TB_QA_1100DT add constraint prod_cd_pk primary key(prod_cd);

select * from TB_MD_1000MT;
select MT_MNG_CD, MT_MNG_NM from TB_MD_1000MT where TP_CLS_VAL = '원자재';

select * from tb_mr_1000mt;

select * FROM TB_PR_1100MT where PROD_END_YN = 'Y';


// 거래처 테이블 더미데이터 넣기
select * from tb_od_1000mt;
rollback;
delete from tb_od_1000mt;
commit;

insert into TB_OD_1000MT 
values ( 'T'||LPAD(sq_od_1000mt.NEXTVAL, 4, '0'), 'HT염화', '김철수', '010-1234-1234', '염화비닐', to_char(sysdate, 'yyyymmdd'), to_char(sysdate, 'yyyymmdd'));

insert into TB_OD_1000MT 
values ( 'T'||LPAD(sq_od_1000mt.NEXTVAL, 4, '0'), 'SH황', '김영희', '010-1123-1564', '황', to_char(sysdate, 'yyyymmdd'), to_char(sysdate, 'yyyymmdd')); 

insert into TB_OD_1000MT 
values ( 'T'||LPAD(sq_od_1000mt.NEXTVAL, 4, '0'), '고무GOMU', '조무고', '010-9123-6445', '고무', to_char(sysdate, 'yyyymmdd'), to_char(sysdate, 'yyyymmdd'));

insert into TB_OD_1000MT 
values ( 'T'||LPAD(sq_od_1000mt.NEXTVAL, 4, '0'), 'GARUstone', '박도루', '010-7823-1479', '고운 속돌가루', to_char(sysdate, 'yyyymmdd'), to_char(sysdate, 'yyyymmdd'));

insert into TB_OD_1000MT 
values ( 'T'||LPAD(sq_od_1000mt.NEXTVAL, 4, '0'), 'sicKwaterOil', '최유식', '010-2934-1991', '식물성 기름', to_char(sysdate, 'yyyymmdd'), to_char(sysdate, 'yyyymmdd'));

insert into TB_OD_1000MT 
values ( 'T'||LPAD(sq_od_1000mt.NEXTVAL, 4, '0'), 'Pla플라', '이수라', '010-1731-1791', '플라스틱', to_char(sysdate, 'yyyymmdd'), to_char(sysdate, 'yyyymmdd'));

insert into TB_OD_1000MT 
values ( 'T'||LPAD(sq_od_1000mt.NEXTVAL, 4, '0'), 'GASO레이트', '석가이', '010-1731-1791', '프탈레이트계 가소제', to_char(sysdate, 'yyyymmdd'), to_char(sysdate, 'yyyymmdd'));

update TB_OD_1000MT
set tel_no = '010-1856-9941'
where mngr_nm = '석가이';

// 기준관리 테이블 원자재 더미데이터 넣기
select * from tb_md_1000mt where tp_cls_val = '원자재';

update tb_md_1000mt
set mt_mng_nm = '황'
where mt_mng_cd = 'M0005';

update tb_md_1000mt
set mt_mng_nm = '고무'
where mt_mng_cd = 'M0025';

update tb_md_1000mt
set mt_mng_nm = '식물성 기름'
where mt_mng_cd = 'M0029';

commit;

INSERT INTO TB_MD_1000MT 
      (MT_MNG_NM, MT_MNG_CD, MT_MNG_DESC, TP_CLS_VAL, USE_YN, REG_DT, MOD_DT, IMG_PATH_ADR)
VALUES ('속돌가루', 'M'||LPAD(SQ_MD_1000MT_M.NEXTVAL, 4, '0'), '지우개원료', '원자재', 'Y', TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'YYYYMMDD'), null);

INSERT INTO TB_MD_1000MT 
      (MT_MNG_NM, MT_MNG_CD, MT_MNG_DESC, TP_CLS_VAL, USE_YN, REG_DT, MOD_DT, IMG_PATH_ADR)
VALUES ('플라스틱', 'M'||LPAD(SQ_MD_1000MT_M.NEXTVAL, 4, '0'), '지우개원료', '원자재', 'Y', TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'YYYYMMDD'), null);

INSERT INTO TB_MD_1000MT 
      (MT_MNG_NM, MT_MNG_CD, MT_MNG_DESC, TP_CLS_VAL, USE_YN, REG_DT, MOD_DT, IMG_PATH_ADR)
VALUES ('가소제', 'M'||LPAD(SQ_MD_1000MT_M.NEXTVAL, 4, '0'), '지우개원료', '원자재', 'Y', TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'YYYYMMDD'), null);

select * from tb_mr_1000mt;
select * from tb_fs_1000mt;
select * from tb_qa_1100dt;

// 완제품 로그 테이블에서 마지막 로그 찾기
select a.*
  from (
        select a.*, rownum as rn
          from TB_FS_1000HT a
         where a.FNSH_CODE = 'P0033'
        order by a.sn desc
      ) a
 where a.rn = 2;

select * from tb_fs_1000ht;

// 정상 코드 - sn이 varchar라서 100,10의 자리 숫자순으로 정렬된다
select a.*, rownum as rn
          from TB_FS_1000HT a
         where a.FNSH_CODE = 'P0033'
        order by a.sn desc;

// 이상한 코드 - sn이 varchar인데 number인거처럼 작동한다 -?
select a.*, rownum as rn
          from TB_MR_1000HT a
         where a.MTRL_CD = 'M0004'
        order by a.sn desc

// 정상화로 가는 코드
select a.*, rownum as rn
          from (select SN
                        FNSH_CODE
                        FNSHD_ITEM_NM
                        CRNT_CNT
                        IOB_SE_CD
                        WORK_NM
                        FNSHL_LOC_NM
                        RMRK
                        REG_DTTM
                        CRNT_AFTR_CNT
                        CHNG_DT
                        PROD_CD
          
          
          from TB_FS_1000HT a
         where a.FNSH_CODE = 'P0033'
        order by a.sn desc;

// 정상코드 - SN의 ROWNUM이 역순으로 나온다
select a.*, rownum as rn
  from (select to_number(SN) AS SN
             , FNSH_CODE
             , FNSHD_ITEM_NM
             , CRNT_CNT
             , IOB_SE_CD
             , WORK_NM
             , FNSHL_LOC_NM
             , RMRK
             , REG_DTTM
             , CRNT_AFTR_CNT
             , CHNG_DT
             , PROD_CD
          from TB_FS_1000HT
         
        ) a
 where a.FNSH_CODE = 'P0033'
 order by SN desc;

// 정상 코드 - 역순 SN의 ROWNUM이 나온다
select a.*, rownum as rn
  from (select to_number(SN) AS SN
             , FNSH_CODE
             , FNSHD_ITEM_NM
             , CRNT_CNT
             , IOB_SE_CD
             , WORK_NM
             , FNSHL_LOC_NM
             , RMRK
             , REG_DTTM
             , CRNT_AFTR_CNT
             , CHNG_DT
             , PROD_CD
          from TB_FS_1000HT
          order by to_number(SN) desc
        ) a
 where a.FNSH_CODE = 'P0033';


// 완제품 로그 테이블 마지막 로그 찾기 - 마지막 a.rn의 값이 2면 마지막 바로 전 로그가 나온다
select a.*
  from (
      --  select a.*, rownum as rn
      --    from TB_MR_1000HT a
      --   where a.MTRL_CD = 'M0004'
      --  order by a.sn desc
        
        select a.*, rownum as rn
          from (select to_number(SN) AS SN
                                      , FNSH_CODE
                                      , FNSHD_ITEM_NM
                                      , CRNT_CNT
                                      , IOB_SE_CD
                                      , WORK_NM
                                      , FNSHL_LOC_NM
                                      , RMRK
                                      , REG_DTTM
                                      , CRNT_AFTR_CNT
                                      , CHNG_DT
                                      , PROD_CD
                 from TB_FS_1000HT
                 order by to_number(SN) desc
               ) a
         where a.FNSH_CODE = 'P0033'
      ) a
 where a.rn = 1;


// 멤버 테이블에 데이터 넣기
select * from tb_mb_1000mt;

insert into tb_mb_1000mt values ('test1', 'test1', '박초코', 'N', sysdate, sysdate, '일반회원');
insert into tb_mb_1000mt values ('test2', 'test2', '김마리', 'N', sysdate, sysdate, '일반회원');
insert into tb_mb_1000mt values ('test3', 'test3', '나환장', 'N', sysdate, sysdate, '일반회원');
insert into tb_mb_1000mt values ('test4', 'test4', '최가추', 'N', sysdate, sysdate, '일반회원');
insert into tb_mb_1000mt values ('test6', 'test5', '이승행', 'N', sysdate, sysdate, '일반회원');

commit;