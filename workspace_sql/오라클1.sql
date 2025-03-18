select * from tb_md_1000mt;
// 기준관리 테이블

select * from tb_mr_1000mt;
// 원자재 현황 테이블

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
select a.*
  from (
        select a.*, rownum as rn
          from TB_MR_1000HT a
         where a.MTRL_CD = 'M0004'
        order by a.sn desc
      ) a
 where a.rn = 2;
 
select * from TB_FS_1000HT;
select * from TB_QA_1100DT;
select * from TB_QA_1000DT;

select * from TB_MR_1000HT;

insert into TB_MR_1000HT
values (SQ_MR_1000HT.NEXTVAL, 'M0004', '염화비닐', 1000, 1000, 'y', 'i', '김철수', 'm창고', '없음', sysdate, 1500, to_char(sysdate, 'yyyymmdd'));
