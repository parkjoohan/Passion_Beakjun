package BaekJoon;

import java.util.*;

public class 도영이가만든맛있는음식_2961 {

	static int N;
	static int S[];
	static int B[];
	static boolean[] check;
	static int min = Integer.MAX_VALUE;
	static int cnt;
	
	private static void sub(int idx, int cnt) {
		
		if(idx == N) {
			if(cnt>0) {
				int a=1, b=0;
				for(int i=0; i<N; i++) {
					if(check[i]) {
						a*= S[i];
						b+= B[i];
					}
				}
				min = Math.min(min, Math.abs(a-b));				
			}
			return;
		}
		check[idx] = true;
		sub(idx+1, ++cnt);
		check[idx] = false;
		sub(idx+1, --cnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N];
		B = new int[N];
		check = new boolean[N];

		for(int i=0; i<N; i++) {
			S[i] = sc.nextInt();	//곱하기
			B[i] = sc.nextInt();	//더하기
		}
		
		sub(0,0);
		System.out.println(min);		
	}
}