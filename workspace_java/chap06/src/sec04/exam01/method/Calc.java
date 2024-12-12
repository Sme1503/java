package sec04.exam01.method;

import java.util.ArrayList;

public class Calc {
	
	boolean isOn = false; // 전원, false = 꺼짐, true = 켜짐
	
	// 전원을 켜는 메소드
	void powerOn() {
		
		isOn = true;
		System.out.println("전원을 켭니다.");
	}
	
	// 전원을 끄는 메소드
	void powerOff() {
		isOn = false;
		System.out.println("전원을 끕니다.");
	}
	
	/**
	 *  더하기
	 *  두 수를 입력받아서 더한 결과를 돌려줌
	 *  
	 *  메소드 이름 : plus
	 *  전달인자    : int, int
	 *  리턴타입 	: int (두 수의 합)
	 *  @param : int x, int y
	 *  @return: int
	 *  @author: dddmddddmdd
	 */
	int plus(int x, int y) {
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		int result = x + y;
		return result;
	}
	
	
	/**
	 * 나누기
	 * 두 정수를 입력받아서 나누기한 결과를 돌려줌
	 * 
	 * 메소드 이름 : div
	 * 전달인자	   : int, int
	 * 리턴타입	   : double
	 * @param : int x, int y
	 * @return: double
	 * @author: adadadad
	 */
	double div(int x, int y) {
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		
		double result =0;
		if(y == 0) {
			System.out.println("0으로 나눌  수 없습니다.");
		} else {
			result = (double) x / y;			
		}
		
		return result;
		
	}
	
	// 배열 전달할 때 얕은 복사로 생기는 문제
	int sum1(int[] values) {
		int sum = 0;
		for(int i = 0; i< values.length; i++) {
			sum += values[i];
		}
		
		return sum;
	}
	
	
	// 매개 변수의 개수를 모를때 ... 사용
	int sum2(int ... values) {
		int sum = 0;
		for(int i = 0; i< values.length; i++) {
			sum += values[i];
		}
		
		return sum;
	}
	
	// arraylist 사용
	int sum3(ArrayList x) {
		int sum = 0;
		for(int i =0; i<x.size(); i++) {
			
			//sum += x.get(i);
		}
		
		return sum;
	}
}
