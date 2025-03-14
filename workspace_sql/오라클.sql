select * from emp; 

select * from emp where emp.job = 'SALESMAN' and ename = 'WARD' or deptno = 30;

desc emp;
desc dept;

select * from dept;

select grade, hisal from salgrade;

desc salgrade;

select empno, ename, sal from emp;

select distinct deptno from emp;

select distinct job from emp;

select ename, sal, sal * 12 + comm, comm from emp;

select ename, sal, sal * 12 + comm as "올해 연봉", comm from emp;

select * from emp order by sal;

select * from emp order by sal desc;

select * from emp order by ename asc, sal desc;

select * from emp order by job;

select * from emp order by job asc, sal asc;

select * from emp order by empno desc, job asc, sal asc;

select distinct job from emp;

select empno employee_no, ename employee_name, job, mgr manager, hiredate, sal salary, comm commission, deptno department_no
from emp order by deptno desc, ename asc;

select * from emp where deptno = 30;

select * from emp where empno = 7782;

select * from emp where deptno = 30 and job = 'SALESMAN';

select * from emp where deptno = 20 or job = 'SCRE';

select * from emp where empno = 7499 and deptno = 30;

select * from emp where deptno = 20 or job ='SALESMAN';

select * from emp where ename = 'WARD' or job = 'CLERK' or deptno = 20;

select * from emp where (ename = 'WARD' or job = 'CLERK') and deptno = 20;

select * from emp where sal * 12 = 36000;

select * from emp where sal > 3000;

select * from emp where sal <= 2000 order by sal;

select * from emp where sal >= 2500 and job = 'ANALYST';

select * from emp where sal >= 2000 and sal < 3000;

select * from emp where ename >= 'F';

select * from emp where ename <= 'FORZ';

select * from emp where sal != 3000;

select * from emp where sal <> 3000;

select * from emp where sal ^= 3000;

// 문제1 부서번호가 20이 아닌 목록
select * from emp where deptno != 20;

// 문제2 부서번호가 20도 아니고 10도 아닌 목록
select * from emp where deptno != 20 and deptno != 10;

// 문제3 부서번호가 30이면서 봉급 2000 이하
select * from emp where deptno = 30 and sal < 2000;

select * from emp where not sal = 3000;

select * from emp where sal < 2000 or sal >= 3000;

select * from emp where not (sal >= 2000 and sal < 3000);

select * from emp where job = 'MANAGER' or job = 'SALESMAN' or job = 'CLERK';

select * from emp where job in ('MANAGER', 'SALESMAN', 'CLERK');

select * from emp where job != 'MANAGER' and job <> 'SALESMAN' and job ^= 'CLERK';

select * from emp where job not in ('MANAGER', 'SALESMAN', 'CLERK');

select * from emp where deptno in (10, 20);

select * from emp where deptno not in (10, 20);

select * from emp where sal >= 2000 and sal <= 3000;

select * from emp where sal between 2000 and 3000;

select * from emp where sal not between 2000 and 3000;

select * from emp where ename like 'S%';

select * from emp where ename like '_L%';

select * from emp where ename like '%AM%';

select * from emp where ename not like '%AM%';

select * from emp where ename like 'A\_A' escape '\';

select * from emp where comm <= 400;

select * from emp where comm is null;

select * from emp where comm is not null;

select comm, comm + 10 from emp;

select * from emp where mgr is null;

select * from emp where deptno = 10 
    union 
select * from emp where deptno = 20;

select empno, ename, sal, deptno from emp where deptno = 10
    union
select empno, ename, sal, deptno from emp where deptno = 20;

select empno, ename, sal, deptno from emp where deptno = 10
    union
select ename, empno, deptno, sal from emp where deptno = 20;

select empno, ename, sal, deptno from emp where deptno = 10
    union
select empno, ename, sal, deptno from emp where deptno = 10;

select empno, ename, sal, deptno from emp where deptno = 10
    union all
select empno, ename, sal, deptno from emp where deptno = 10;

select empno, ename, sal, deptno from emp
    minus
select empno, ename, sal, deptno from emp where deptno = 10;

select empno, ename, sal, deptno from emp
    intersect
select empno, ename, sal, deptno from emp where deptno = 10;

// 문제1
select * from emp where ename like '%S';

// 문제2
select empno, ename, job, sal, deptno from emp where deptno = 30 and job = 'SALESMAN';

// 문제3-1 집합 연산자 x
select empno, ename, job, sal, deptno from emp where deptno in (20, 30) and sal > 2000;

// 문제3-2 집합 연산자 o
select empno, ename, job, sal, deptno from emp where deptno = 20 and sal > 2000
    union all
select empno, ename, job, sal, deptno from emp where deptno = 30 and sal > 2000;

// 문제4
select * from emp where sal < 2000 or sal > 3000; // not (sal >= 2000 and sal <= 3000)

// 문제5
select ename, empno, sal ,deptno from emp where deptno = 30 and ename like '%E%' and sal not between 1000 and 2000;

// 문제6
select * from emp where comm is null and mgr is not null and job in ('CLERK', 'MANAGER') and ename not like '_L%';

select * from dual;

select upper('abcDe') from dual;

select lower('abcDe') from dual;

select lower(ename) from emp;

select upper(ename) from emp;

select * from emp where ename like '%A%' or ename like '%a%';

select * from emp where lower(ename) like '%a%';

select ename, length(ename) from emp;

select length('abc'), length('한글') from dual;

select ename, length(ename) from emp where length(ename) >= 5;

select length('한'), lengthb('한') from dual;

select '123456', substr('123456', 3, 2), substr('123456', 2, 3) from dual;

select job, substr(job, 1, 2), substr(job, 0, 2), substr(job, 3, 3), substr(job, 4), substr(job, 44, 100), length(substr(job, 4)), substr(job, length(job) - 2, 3), substr(job, -3) from emp;

select substr(ename, 3) from emp; 

select job, substr(job, -length(job)), substr(job, -length(job), 2), substr(job, -3) from emp;

select instr('HELLO, ORACLE!', 'L') as instr_1, instr('HELLO, ORACLE!', 'L', 5) as instr_2, instr('HELLO, ORACLE!', 'L', 2, 2) as instr_3 from dual;

select '010-1234-5678' as replace_before, replace('010-1234-5678','-', ' ') as replace_1, replace('010-1234-5678','-') as replace_2, replace('010-1234-5678','-', '**') as replace_3 from dual;

select ename, replace(ename, 'A', '❤♥') from emp;

// 문제1 ename에서 앞 2글자 출력
select ename, substr(ename, 1, 2) from emp;

// 문제2 ename에서 앞 2글자 **표시
select ename, replace(ename, substr(ename, 1, 2), '**') from emp;

// 문제3 ename의 반절에 해당하는 길이 출력
select ename, length(ename) / 2 from emp;

// 문제3-1 ename의 앞의 반을 모두 *표시
select ename, replace(ename, substr(ename, 1, length(ename) / 2), '*') from emp;

// 문제3-2 ename의 뒤의 반을 모두 *표시
select ename, replace(ename, substr(ename, -(length(ename) / 2)), '*') from emp;

// 복습 문제 3-2만 다시 풀기
select ename, replace(ename, substr(ename, (length(ename) / 2) + 1), '**') from emp;

-- 시험
-- 문제1
-- 1-1
select empno, ename from emp;

-- 1-2
select empno, ename from emp order by empno desc;

-- 1-3
select replace(empno, substr(empno, (length(empno)/2) + 1), '**') as empno from emp;

-- 문제2
-- 2-1
select e.empno, e.ename, d.dname, d.loc from emp e, dept d where e.deptno = d.deptno;

-- 2-2
select e.empno, e.ename, d.dname, d.loc from emp e, dept d where e.deptno = d.deptno order by d.dname desc;

select 'oracle', lpad('oracle', 10, '#') lpad_1, rpad('oracle', 10, '*') rpad_1, lpad('oracle', 10) lpad_2, rpad('oracle', 10) rpad_1 from dual;

select 'oracle', lpad('oracle', 3) lpad_1 from dual;

select rpad('971111-', 14, '*') rpad_jmno, rpad('010-1234-', 13, '*') rpad_phone from dual;

select ename, rpad(ename, 6, '*') from emp;

select ename, lpad(ename, length(ename) * 2, '*') from emp;

// 문제1 전화번호 뒤 4자리를 *로 바꾸기. replace 사용 x
select '010-9282-6150', length('010-9282-6150'), substr('010-9282-6150', 1, length('010-9282-6150') - 4), rpad(substr('010-9282-6150', 1, length('010-9282-6150') - 4), length('010-9282-6150'), '*') from dual;

// 문제2 사원의 이름을 앞에 두글자만 보이게하고 나머지는 *로 표시. replace 사용 x
select ename, length(ename), substr(ename, 1, 2), rpad(substr(ename, 1, 2), length(ename), '*') from emp;

// 문제3 사원 이름의 앞글자 하나만 *로 표시. replace 사용 x
select ename, length(ename), substr(ename, -length(ename) + 1), lpad(substr(ename, -length(ename) + 1), length(ename), '*') from emp;

// 문제4 job을 대상으로 20자 크기의 공간에서 가운데 정렬
select (lpad('1234', 20, '+')) from dual;
select substr(lpad('1234', 20, '+'), -length(lpad('1234', 20, '+'))) from dual;
select lpad(job, 20, '*' ), rpad(job, 20, '*' ) from emp;
select substr(lpad(job, 20, '*' ), -((20 - length(job)))), substr(rpad(job, 20, '*' ), 1, ((20 - length(job)))) from emp;
select substr(lpad(job, 20, '*' ), -((20 - length(job)))), substr(rpad(job, 20, '*' ), 1, ((20 - length(job)))) from emp;

select lpad(rpad(job, 14, '*'), 20, '*') from emp; // 꼼수
select lpad(rpad(job, (20 - (20 - length(job)) / 2), '*'), 20, '*') from emp; // 완성
********CLERK******* = 20;

select (20 - length(job)) / 2 from emp;
select substr(lpad(job, (20 - length(job)) / 2, '*' ), -length(lpad('1234', 20, '+'))) from emp;

select job, length(job), rpad(job, length(job)) as a, lpad(job, (20 - length(job) / 2), '*'),
lpad(rpad(job, 13), 20) from emp;


select concat(empno, ename), concat(empno, concat(' : ', ename)) from emp where ename = 'SCOTT';

select empno || ename, empno || ' : ' || ename from emp where ename = 'SCOTT';

select '[' || trim(' _ _oracle_ _ ') || ']' as trim, '[' || trim(leading from ' _ _oracle_ _ ') || ']', '[' || trim(trailing from' _ _oracle_ _ ') || ']',  '[' || trim(both from' _ _oracle_ _ ') || ']' from dual;

select ' a b    cd       ', trim(' a b    cd       ') from dual;

select round(1234.5678) as round, round(1234.5678, 0) as round_0, round(1234.5678, 1) as round_1, round(1234.5678, 2) as round_2, round(1234.5678, -1) as round_minus_1, round(1234.5678, -2) as round_minus2 from dual;

select trunc(1234.5678) as trunc, trunc(1234.5678, 0) as trunc_0, trunc(1234.5678, 1) as trunc_1, trunc(1234.5678, 2) as trunc_2, trunc(1234.5678, -1) as trunc_minus_1, trunc(1234.5678, -2) as trunc_minus2 from dual;

select ceil(3.14), floor(3.14), ceil(-3.14), floor(-3.14) from dual;

select mod(15, 6), mod(10, 2), mod(11, 2) from dual;

select sysdate as now, sysdate-1 as yesterday, sysdate+1 as tomorrow, sysdate - (sysdate+1) from dual;

select sysdate, add_months(sysdate, 3) from dual;

select empno, ename, hiredate, sysdate from emp where add_months(hiredate, 484) > sysdate;

select empno, empno + '500' from emp;  // 컬럼에 + 적으면 모두 숫자로 적용

select empno, empno || 500 from emp; // || 적으면 모두 문자로 적용

select to_char(sysdate, 'w month ddd day  yyyy"년" mm"년" dd"일" hh24:mi:ss a.m.') as 현재날짜시간 from dual;

select sal, to_char(sal, '$999,999'), to_char(sal, 'l999,999') from emp;

select '1900' - '1500' from dual;

select to_date('2024-11-15', 'yyyy-mm-dd') as todate1 from dual;

select to_char(to_date('2024-11-15', 'yyyy-mm-dd'), 'yyyy"년" mm"년" dd"일" hh24:mi:ss a.m.') from dual;

select to_date('2024-11-15 18', 'yyyy-mm-dd hh24') - to_date('2024-11-16', 'yyyy-mm-dd') from dual;

select sysdate - to_date('2024-11-11', 'yyyy-mm-dd') from dual;

select sysdate - to_date('2024-11-25', 'yyyy-mm-dd') from dual;

select * from emp where hiredate > to_date('1981/06/01', 'yyyy/mm/dd');

select comm, sal, comm + sal, nvl(comm, 0), nvl(comm, 0) + sal from emp;

select empno, ename, comm, nvl2(comm, 'o', 'x'), nvl2(comm, sal * 12 + comm, sal * 12) from emp;

select empno, ename, job, sal, decode(job, 'MANAGER', sal*1.1, 'SALESMAN', sal*1.05, 'ANALYST', sal, 'CLERK', sal*1.2, sal*1.03) as upsal from emp;

// 문제1 이름, 봉급, 성과급, 봉급 + 성과급(decode사용)
select ename, sal, comm, sal + decode(comm, null, 0, comm) from emp;

select empno, ename, job, sal, 
    case job
        when 'MANAGER' then sal*1.1
        when 'SALESMAN' then sal*1.05
        when 'ANALYST' then sal
        else sal*1.03
    end as upsal
from emp;

select empno, ename, comm,
    case
        when comm is null then '해당사항 없음'
        when comm = 0 then '수당없음'
        when comm > 0 then '수당 : ' || comm
    end as comm_text
from emp;

// 문제1 comm이 null인 경우 'N/A' 출력, null이 아닌 경우 comm 출력
select empno, ename, comm,
    case
        when comm is null then 'n/a'
        when comm is not null then '' || comm
        else '' || comm
    end
from emp;

select empno, ename, sal, trunc(sal / 21.5, 2) as day_pay, round(sal / 21.5 / 8, 1) as time_pay from emp;

select empno, ename, mgr, 
    case 
        when mgr is null then '0000'
        when mgr like '75%' then '5555'
        when mgr like '76%' then '6666'
        when mgr like '77%' then '7777'
        when mgr like '78%' then '8888'
        else '' || mgr
    end as chg_mgr
from emp;

select empno, replace(empno, substr(empno, 3, 2), '**') as masking_empno, ename, rpad(substr(ename, 1, 1), length(ename), '*') as masking_ename from emp where length(ename) >= 5 and length(ename) < 6;

select empno, ename, hiredate, next_day(add_months(hiredate, 3), '월요일') as r_job, nvl2(comm, ''||comm, 'n/a') from emp;

select comm, nvl(to_char(comm), 'n/a'), nvl2(comm, ''||comm, 'n/a') from emp;

select sum(comm) from emp;

select sum(sal + nvl(comm,0)) from emp;

select count(*), count(sal), count(comm), sal from emp;

select count(*) from emp where deptno = 30 and comm is not null;

select max(sal), max(ename), min(sal), min(hiredate), min(comm) from emp;

select count(*) from emp where ename like '%A%';

select * from emp where sal = max(sal);

select avg(sal) from emp;

select '10', sum(sal), avg(sal) from emp where deptno = 10
union all
select '20', sum(sal), avg(sal) from emp where deptno = 20
union all
select '30', sum(sal), avg(sal) from emp where deptno = 30;

select deptno, job, avg(sal), sum(sal), count(*) from emp group by deptno, job order by deptno, job;

select max(sal) from emp where count(*) > 2 group by deptno;

select job, count(*) as cnt from emp where sal > 1000 group by job having count(*) >= 3 order by cnt desc;

select deptno, job, avg(sal) from emp group by deptno, job having avg(sal) >= 500 order by deptno, job;

select deptno, trunc(avg(sal),0) avg_sal, max(sal) max_sal, min(sal) min_sal, count(*) cnt from emp group by deptno; 

select job, count(*) from emp group by job having count(*) >= 3;

select substr(to_char(hiredate), 1, 2) hire_year, deptno, count(*) cnt from emp group by deptno, substr(to_char(hiredate), 1, 2) order by deptno desc;

select nvl2(comm, '0', 'x') exist_comm, count(*) from emp group by nvl2(comm, '0', 'x');

select deptno, substr(to_char(hiredate), 1, 2) hire_year, count(*) cnt, max(sal) max_sal, sum(sal) sum_sal, avg(sal) avg_sal from emp group by deptno, substr(to_char(hiredate), 1, 2) order by deptno asc;


// 문제1 1981년에 입사한 사원 중에서 급여가 가장 낮은 사원의 급여를 출력
select min(sal) from emp group by substr(to_char(hiredate), 1, 2) having substr(to_char(hiredate), 1, 2) like '81%';

// 문제2 1981년에 입사한 사원 중에서 급여가 1981년 평균 급여보다 높은 사원의 수를 출력
select count(*) cnt from emp group by substr(to_char(hiredate), 1, 2) having substr(to_char(hiredate), 1, 2) like '81%' and sal > avg(sal);

// 문제3 각 부서별로 급여가 가장 높은 사원가 가장 낮은 사원의 급여 차이를 출력
select deptno, max(sal) - min(sal) from emp group by deptno;
select deptno, max(sal), min(sal) from emp group by deptno;

select * from dept;

select * from emp, dept where emp.deptno = dept.deptno order by empno;

select ename, d.deptno from emp e, dept d where e.deptno = d.deptno order by empno;

select ename, d.deptno, e.* from emp e, dept d where e.deptno = d.deptno order by empno;

select * from salgrade;

select * from emp e, salgrade s where e.sal >= s.losal and e.sal <= s.hisal;

select * from emp;
select e.ename, e.mgr, m.ename, m.empno, m.mgr, p.ename, p.empno from emp e, emp m, emp p where e.mgr = m.empno and m.mgr = p.empno;

select e.ename, e.mgr, m.ename, m.empno, m.mgr from emp e, emp m where e.mgr = m.empno;

select e.ename, e.mgr, m.ename, m.empno, m.mgr from emp e, emp m where e.mgr = m.empno(+);

select e.ename, e.mgr, m.ename, m.empno, m.mgr from emp e, emp m where e.mgr(+) = m.empno;

select * from emp join dept using(deptno);

select * from emp e join dept d on(e.deptno = d.deptno) where sal <= 3000;

select * from emp e left outer join emp e1 on(e.mgr = e1.empno);

select e.deptno, d.dname, e.empno, e.sal from emp e, dept d where e.deptno = d.deptno and sal > 2000 order by e.deptno asc;
select deptno, d.dname, e.empno, e.sal from emp e natural join dept d where sal > 2000 order by deptno asc;
select deptno, d.dname, e.empno, e.sal from emp e join dept d using(deptno) where sal > 2000 order by deptno asc;
select e.deptno, d.dname, e.empno, e.sal from emp e join dept d on(e.deptno = d.deptno) where sal > 2000 order by e.deptno asc;

select e.deptno, d.dname, floor(avg(sal)) avg_sal, max(sal) max_sal, min(sal) min_sal, count(*) cnt from emp e, dept d where e.deptno = d.deptno group by e.deptno, d.dname;
select deptno, d.dname, floor(avg(sal)) avg_sal, max(sal) max_sal, min(sal) min_sal, count(*) cnt from emp e natural join dept d group by deptno, d.dname;
select deptno, d.dname, floor(avg(sal)) avg_sal, max(sal) max_sal, min(sal) min_sal, count(*) cnt from emp e join dept d using(deptno) group by deptno, d.dname;
select e.deptno, d.dname, floor(avg(sal)) avg_sal, max(sal) max_sal, min(sal) min_sal, count(*) cnt from emp e join dept d on(e.deptno = d.deptno) group by e.deptno, d.dname;

select d.deptno, d.dname, e.empno, e.ename, e.job, e.sal from emp e, dept d where e.deptno(+) = d.deptno order by deptno asc, ename asc;
select deptno, d.dname, e.empno, e.ename, e.job, e.sal from emp e right outer join dept d using(deptno) order by deptno asc, ename asc;
select d.deptno, d.dname, e.empno, e.ename, e.job, e.sal from emp e right outer join dept d on(e.deptno = d.deptno) order by deptno asc, ename asc;

// 풀아우터 조인 사용
select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal, s.losal, s.hisal, s.grade, e2.empno mgr_empno, e2.ename mgr_ename from emp e1, emp e2, dept d, salgrade s where e1.deptno = d.deptno and e1.mgr = e2.empno and e1.sal between s.losal and s.hisal order by e1.deptno, e1.empno asc;
select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal, s.losal, s.hisal, s.grade, e2.empno mgr_empno, e2.ename mgr_ename from emp e1 left outer join emp e2 on(e1.mgr = e2.empno) right outer join dept d on(e1.deptno = d.deptno) left join salgrade s on (e1.sal between s.losal and s.hisal) order by d.deptno, e1.empno asc;
select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal, s.losal, s.hisal, s.grade, e2.empno mgr_empno, e2.ename mgr_ename from emp e1 right outer join dept d on(e1.deptno = d.deptno) left outer join emp e2 on(e1.mgr = e2.empno) left outer join salgrade s on (e1.sal between s.losal and s.hisal) order by d.deptno, e1.empno asc;
select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal, s.losal, s.hisal, s.grade, e2.empno mgr_empno, e2.ename mgr_ename from emp e1 full join dept d on(e1.deptno = d.deptno) left join emp e2 on(e1.mgr = e2.empno) left join salgrade s on (e1.sal between s.losal and s.hisal) order by d.deptno, e1.empno asc;

// 문제1. 사원번호, 이름, 부서명, 급여등급 출력 : 14줄
select e.empno, e.ename, d.dname, s.grade from emp e, dept d, salgrade s where e.deptno = d.deptno and sal >= losal and sal <= hisal order by grade;   
select e.empno, e.ename, d.dname, s.grade from emp e join dept d on(e.deptno = d.deptno) join salgrade s on(sal >= losal and sal <= hisal) order by grade;
select * from salgrade;
select * from emp;

// 문제2. 상사보다 월급이 높은 사원의 이름 , 급여, 상사이름, 상사급여
select e1.ename, e1.sal, e2.ename, e2.sal from emp e1, emp e2 where e1.mgr = e2.empno and e1.sal > e2.sal;
select e1.ename, e1.sal, e2.ename, e2.sal from emp e1 join emp e2 on(e1.mgr = e2.empno) where e1.sal > e2.sal;

select ename, sal from emp where sal > (select sal from emp where ename ='JONES');

select * from emp where sal in (select max(sal) from emp group by deptno);

// 문제1. blake보다 높은 연봉을 받는 사원 출력
select * from emp where sal > (select sal from emp where ename = 'BLAKE');
select sal from emp where ename = 'BLAKE';

// 문제2. jones랑 같은 job을 가진 사원 출력
select * from emp where job = (select job from emp where ename = 'JONES') and ename not like 'JONES';

select * from (select empno, deptno, ename from emp where deptno = 10);

select * from (select rownum as r, emp.* from emp ) where r = 3;

select rownum as r, e.* from (select * from emp order by ename) e; 

select job, count(*) from emp group by job having count(*) >= 3;

select * from (select job, count(*) cnt from emp group by job) where cnt >= 3;

with e10 as (select * from emp where deptno = 10), d as (select * from dept)
select e10.empno, e10.ename, e10.deptno, d.dname, d.loc from e10, d where e10.deptno = d.deptno;


select e.job, e.empno, e.ename, e.sal, e.deptno, d.dname from emp e, dept d where e.deptno = d.deptno and job = (select job from emp where ename like 'ALLEN') order by sal desc, ename asc;

select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal, s.grade from emp e, dept d, salgrade s where e.deptno = d.deptno and e.sal between s.losal and s.hisal and e.sal > (select floor(avg(sal)) from emp) order by sal desc, empno asc;  

select e.empno, e.ename, e.job, e.deptno, d.dname, d.loc from emp e, dept d where e.deptno = d.deptno and e.deptno = 10 and e.job not in (select job from emp where deptno = 30);
select job from emp where deptno = 30;

select e.empno, e.ename, e.sal, s.grade from emp e, salgrade s where e.sal > (select max(sal) from emp where job = 'SALESMAN') and e.sal between losal and hisal order by empno asc; // 다중행 함수 사용
select e.empno, e.ename, e.sal, s.grade from emp e, salgrade s where e.sal > all(select sal from emp where job = 'SALESMAN') and e.sal between losal and hisal order by empno asc;   // 다중행 서브쿼리 사용

create table emp_ddl (
    empno number(4),
    ename varchar2(10),
    job varchar2(9),
    mgr number(4),
    hiredate date,
    sal number(7, 2),
    comm number(7, 2),
    denptno number(2)
);
desc emp_ddl;

create table dept_ddl as select * from dept;
select * from dept_ddl;

create table emp_ddl_30 as select * from emp where deptno = 30;
select * from emp_ddl_30;

create table empdept_ddl as select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, d.deptno, d.dname, d.loc from emp e, dept d where 1 != 1;
select * from empdept_ddl;

drop table empedpt_ddl;

create table emp_alter as select * from emp;
select * from emp_alter;

alter table emp_alter add hp varchar2(20);

alter table emp_alter rename column hp to tel;

alter table emp_alter modify empno number(5);
desc emp_alter;

alter table emp_alter drop column tel;

rename emp_alter to emp_rename;
select * from emp_rename;

truncate table emp_rename;

drop table emp_rename;

create table dept_temp as select * from dept;

insert into dept_temp (deptno, dname, loc) values (50, 'DATABASE', 'SEOUL');
select * from dept_temp;

insert into dept_temp (deptno, dname, loc) values (111, 'DATABASE', 'seoul' );

insert into dept_temp values (60, 'NETWORK', 'BUSAN');

insert into dept_temp (deptno, dname, loc) values (70, 'WEB', null);

insert into dept_temp (deptno, loc) values (90, 'INCHEON');

create table emp_temp as select * from emp where 1 <> 1;
select * from emp_temp;

insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (2111, '이순신', 'MANAGER', 9999, to_date('2001-01-07'), 4000, null, 20);
insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (1111, '홍길동', 'MANAGER', 9999, to_date('2011-05-15', 'yyyy/mm/dd'), 4000, null, 20);
insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (3111, '춘향이', 'MANAGER', 9999, sysdate, 4000, null, 20);

delete from emp_temp where ename = '홍길동';

insert into emp_temp select * from emp where deptno = 10;

create table dept_temp2 as select * from dept;
select * from dept_temp2;

update dept_temp2 set loc = 'SEOUL';
rollback;
update dept_temp2 set dname = 'DATABASE', loc  = 'SEOUL' where deptno = 40;

select * from emp_temp where sal <= 2500;
update emp_temp set comm = 50 where sal <= 2500;

// 문제1. emp 테이블을 복사한 emp_temp2에서 연봉이 1000 이하인 사원의 연봉을 1.3% 인상
create table emp_temp2 as select * from emp;
select * from emp_temp2 where sal <= 1000;
update emp_temp2 set sal = sal * 1.013 where sal <= 1000;
rollback;

delete from emp_temp2 where job = 'MANAGER';
rollback;

select * from emp_temp2;
delete from emp_temp2 where deptno = 10;

create table emp_temp3 as select * from emp;
delete emp_temp3 where deptno = 10;

select * from user_tables;
select * from user_indexes;

create index idx_emp_sal on emp(sal asc);
select * from user_ind_columns;

-- 강제 힌트
select --+ index(idx_emp_sal)
    * from emp where sal = 3000 order by sal;
select --+ index(e)
    * from emp e where sal = 3000 order by sal asc;
    
drop index idx_emp_sal;

// empno가 입사 순서대로 발행되는 번호라고 할 때, 다음 입사자의 empno? '신입이'를 입사
insert into emp_temp3(empno, ename) values ((select max(empno) +1 from emp_temp3), '신입이');
select * from emp_temp3;

create sequence seq_empno
start with 8000
increment by 10;

select seq_empno.nextval from dual; // 다음 시퀀스 값
select seq_empno.currval from dual; // 현재 시퀀스 값

insert into emp_temp3(empno, ename) values (seq_empno.nextval, '신입3');

drop sequence seq_empno;

create table table_notnull (
    login_id varchar2(20) not null,
    login_pwd varchar2(20) not null,
    tel varchar2(20)
);
insert into table_notnull (login_id, login_pwd, tel) values ('TEST_ID_01', null, '010-1234-5678');
select * from user_constraints;
insert into table_notnull (login_id, login_pwd, tel) values ('TEST_ID_01', '1234', null);
select * from table_notnull;
update table_notnull set tel = '0' where tel is null;
alter table table_notnull modify(tel null);
desc table_notnull;

create table table_pk (
    login_id varchar2(20) primary key,
    login_pwd varchar2(20) not null,
    tel varchar2(20)
);
select * from user_constraints;
select * from user_indexes;
insert into table_pk(login_id, login_pwd, tel) values ('TEST_ID_01', 'PWD01', '010-1234-5678');
insert into table_pk(login_id, login_pwd, tel) values (null, null, null);

create table table_name (
    col1 varchar2(20),
    col2 varchar2(20),
    col3 varchar2(20),
    
    primary key(col1, col2), // 복합키
    unique (col1)
);
insert into table_name values ('id1', 'pw1', null);
insert into table_name values ('id2', 'pw1', null);
select * from table_name;

create table dept_fk (
    deptno number(2) primary key,
    dname varchar2(14),
    loc varchar2(13)
);
create table emp_fk (
    empno number(4),
    ename varchar2(10),
    deptno number(2) references dept_fk(deptno),
    deptno1 number(2),
    foreign key(deptno1) references dept_fk(deptno)
);
insert into dept_fk values (1, 'aaaa', 'AAAA');
insert into emp_fk values (1, 'a', 1, 1);
update dept_fk set deptno = 3 where deptno = 1;
select *from dept_fk;

create table dept_fk1 (
    d1 number(2),
    d2 varchar2(14),
    d3 varchar2(13),
    
    primary key(d3, d2)  // == primary key(d2, d3) ?
);
create table emp_fk1 (
    e1 number(4),
    e2 varchar2(14),
    e3 varchar2(13),
    foreign key(e2, e3) references dept_fk1(d3, d2) -- 참조하려는 테이블의 기본키가 복합키면 외래키도 복합키로 만들어야함(데이터 타입도 같아야한다)
);
drop table emp_fk1;

// 조인쓸 때 outer 빼도 작동, 한 테이블에 기본키가 2개 (복합키 x)




create table emp_hw (
    empno number(4),
    ename varchar2(10),
    job varchar2(9),
    mgr number,
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number
);
desc emp_hw;

alter table emp_hw add bigo varchar2(20);
alter table emp_hw modify bigo varchar2(30);
alter table emp_hw rename column bigo to remark;
insert into emp_hw(empno, ename, job, mgr, hiredate, sal, comm, deptno) select * from emp;
select * from emp_hw;

drop table emp_hw;

create table chap10hw_emp as select * from emp;
create table chap10hw_dept as select * from dept;
create table chap10hw_salgrade as select * from salgrade;

insert into chap10hw_dept(deptno, dname, loc) values (50, 'ORACLE', 'BUSAN');
insert into chap10hw_dept values (60, 'SQL', 'ILSAN');
insert into chap10hw_dept values (70, 'SELECT', 'INCHEON');
insert into chap10hw_dept values (80, 'DML', 'BUNDANG');
select * from chap10hw_dept;

insert into chap10hw_emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values (7201, 'TEST_USER1', 'MANAGER', 7788, '2016-01-02', 4500, null, 50);
insert into chap10hw_emp values (7202, 'TEST_USER2', 'CLERK', 7201, '2016-02-21', 1800, null, 50);
insert into chap10hw_emp values (7203, 'TEST_USER3', 'ANALYST', 7201, '2016-04-11', 3400, null, 60);
insert into chap10hw_emp values (7204, 'TEST_USER4', 'SALESMAN', 7201, '2016-05-31', 2700, 300, 60);
insert into chap10hw_emp values (7205, 'TEST_USER5', 'CLERK', 7201, '2016-07-20', 2600, null, 70);
insert into chap10hw_emp values (7206, 'TEST_USER6', 'CLERK', 7201, '2016-09-08', 2600, null, 70);
insert into chap10hw_emp values (7207, 'TEST_USER7', 'LECTURER', 7201, '2016-10-28', 2300, null, 80);
insert into chap10hw_emp values (7208, 'TEST_USER8', 'STUDENT', 7201, '2018-03-09', 1200, null, 80);
select * from chap10hw_emp;

update chap10hw_emp set deptno = 70 where sal > (select avg(sal) from chap10hw_emp where deptno  = 50);
select * from chap10hw_emp order by deptno;

update chap10hw_emp set deptno = 80 , sal = sal * 1.1 where hiredate > (select min(hiredate) from chap10hw_emp where deptno = 60);
select * from chap10hw_emp order by deptno;

delete from chap10hw_emp where empno in (select empno from chap10hw_emp ce, salgrade s where ce.sal between s.losal and s.hisal and s.grade = 5);
select * from chap10hw_emp;






create table menu (
    menunum number(4) not null,
    menuname varchar(10) not null,
    menuprice number(5) not null,
    primary key (menunum)
);

create table eating_house (
    num number(5) not null,
    name varchar(10) not null,
    address varchar(20) not null,
    callnum varchar(12) not null,
    primary key (num),
    foreign key (menunum) references menu(menunum)
);

create table user (
    usernum number(4) not null,
    userid varchar(20) not null,
    useraddress varchar(20) not null,
    usercallnum varchar(13) not null,
    primary key (usernum)
);

create table order (
    ordernum number(4) not null,
    request varchar(40) null,
    allpay number(5) not null,
    packdeli varchar(10) not null,
    paystatus number(1) not null,
    orderdate date not null,
    primary key (ordernum),
    foreign key (usernum) references user(usernum),
    foreign key (num, menunum) references eating_house(num, menunum)
);

select * from order;

create table todo (
    todo_id number primary key,
    todo varchar2(4000) not null,
    create_date date not null,
    modify_date date,
    done char(1) not null
);

create sequence seq_todo;

select * from todo;

insert into todo values ( seq_todo.nextval,'test', sysdate, null, 'N'); 
commit;

update todo set done = 'y' where todo_id = 4;

























/*지출 - 식비, 통신비, 보험비, 로또
식비 - 5500 (돈까스)   통신비 - 25000   보험비 - 27500 로또 - 5000 기타 - 47200(도넛), 교통비 - 1500(버스)
한달 예상 지출(20일 기준) = 110000(식비) 52500(통신+보험) 20000(로또) 47200(도넛) 6000(버스4회) = 235700(최소) / 182500(도넛, 교통비제외)
*/ 
