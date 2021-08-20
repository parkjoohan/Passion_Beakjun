package BaekJoon;

import java.util.Scanner;

public class 행렬제곱_10830 {
 
	final static int MOD = 1000;
	public static int N;
	public static int[][] origin;	// A^1 일 때의 배열(초기 배열)
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[][] result = pow(origin, B);
		N = in.nextInt();
		long B = in.nextLong();	// 타입 주의
		origin = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				origin[i][j] = in.nextInt() % MOD;
			}			
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
 
	// 행렬 제곱 분할정복 메소드
	public static int[][] pow(int[][] A, long exp) {
		// 지수가 1일 땐 A를 return한다.
		if(exp == 1L) {
			return A;
		}
		
		// 지수를 절반으로 분할하여 재귀호출
		int[][] ret = pow(A, exp / 2);
		
		// 하위 재귀에서 얻은 행렬을 제곱해준다.
		ret = multiply(ret, ret);
		
		// 만약 지수가 홀수라면 마지막에  A^1 (origin)을 곱해준다.
		if(exp % 2 == 1L) {
			ret = multiply(ret, origin);
		}	
		return ret;
	}
	
	// o1과 o2 행렬을 곱해주는 메소드
	public static int[][] multiply(int[][] o1, int[][] o2) {
		
		int[][] ret = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {				
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD;	// 행렬 원소 연산이 끝나면 MOD로 나머지연산
				}
			}
		}
		return ret;
	}
}