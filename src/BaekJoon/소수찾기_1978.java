package BaekJoon;

import java.util.*;

public class 소수찾기_1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		int cnt2=0;
		
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			int cnt1=0;
			
			for(int j=1; j<=N; j++){
				if(N % j == 0)
					cnt1++;
			}
			
			if(cnt1 == 2)
				cnt2 = cnt2+1;
				
		}
		System.out.print(cnt2);
	}
}
