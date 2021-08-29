package BaekJoon;

import java.util.*;

public class P_14696_딱지놀이 {

	static int N; // 총 라운드 수
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	
		for ( int i=0; i<N; i++) {
			int A = sc.nextInt();
			int[] cardA = new int[5];
			for(int j=0; j<A; j++) {	// A 어린이 카드 개수 저장
				cardA[sc.nextInt()]++;
			}
			
			int B = sc.nextInt();
			int[] cardB = new int[5];
			for(int j=0;j<B;j++) {	// B 어린이 카드 개수 저장
				cardB[sc.nextInt()] ++;
			}
			
			boolean flag = false;
			for(int j=4;j>0;j--) {
				if(cardA[j]>cardB[j]) {		// 4의 개수 체크
					System.out.println("A");
					break;
				}
				else if(cardA[j]<cardB[j]){
					System.out.println("B");
					break;
				}
				if(j==1 && cardA[j]==cardB[j]) 
					flag = true;
			}
			if(flag) 	// 만약 비겼으면 D 출력
				System.out.println("D");
		}
	}
}