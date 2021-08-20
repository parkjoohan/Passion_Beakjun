package BaekJoon;

/*import java.util.*;

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
}*/

import java.util.*;

public class P_2961_도영이가만든맛있는음식 {

	static int N;
	static int[] S;        // 신맛
	static int[] B;     // 쓴맛
	static int min;        // 신맛과 쓴맛이 가장 작은 요리
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    
		N = sc.nextInt();
		S = new int[N];
		B = new int[N];
		min = Integer.MAX_VALUE;
    
		for(int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		cooking(0, 1, 0);
		System.out.println(min);
	}
	
	private static void cooking(int index, int sumS, int sumB) {
		if(index == N) {
			// 아무 재료도 선택하지 않았을 경우: 공집합
			if(sumS == 1 && sumB == 0) return;
        
			int result = Math.abs(sumS - sumB);
			if(result < min) min = result;
			return;
    }
    
    cooking(index + 1, sumS * S[index], sumB + B[index]);
    cooking(index + 1, sumS, sumB);
	}
}