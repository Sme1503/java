package sec01.exam01;

public class lottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] lotto = new int[6];
		// 로또 다른 방법
		boolean flag = false;
		for (int j = 0; j < lotto.length; j++) {
			do {
				lotto[j] = (int) (Math.random() * 45) + 1;
				flag = false;
				for (int i = 0; i < j; i++) {
					if (lotto[i] == lotto[j]) {
						flag = true;
						break;
					}
				}
			} while (flag);
		}
		for (int i = 0; i < lotto.length; i++) {

			// System.out.println(lotto[i]);
			if (i != 0) {
				System.out.print(", " + lotto[i]);
			} else {
				System.out.print(lotto[i]);
			}
		}
		System.out.println();

		lotto = new int[6]; // 1차원 배열

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1; // 난수 생성

			if (i == 0) { // 처음 한번은 비교없이 진행
				System.out.print(lotto[i]);
				continue;
			} else { // 두번째부터 바로 이전 값과 비교

				for (int j = 0; j < i; j++) { // 배열[i]를 배열[0]부터 베열[i-1]까지 비교
					if (lotto[i] == lotto[j]) { // 새로운 값과 이전 값이 같으면
						
						System.out.print(" 중복 발생 " + lotto[i] + " 중복발생 ");
						
						lotto[i] = (int) (Math.random() * 45) + 1; // 새로운 난수 생성
						// 똑같은게 또 나왔을 때 거를 수가 없다.  >> 실패
					}
				}

			}
			System.out.print(", " + lotto[i]); // 출력
		}

//		for (int i = 0; i < lotto.length; i++) {
//			if (i != 0) {
//				System.out.print(", " + lotto[i]);
//			} else {
//				System.out.print(lotto[i]);
//			}
//		}
//		System.out.println();
	}

}
