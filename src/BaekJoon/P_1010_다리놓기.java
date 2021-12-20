package BaekJoon;

import java.util.*;

public class P_1010_다리놓기 {

	static int T, N, M, cnt;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			visited = new boolean[M+1];
			cnt=0;
			
			System.out.println(comb(M, N));
		}
	}
	
	public static int comb(int n, int r) {
		int result=1;
		for (int i = 1; i <= r; i++) {
			result = result * (n - i + 1) / i;
		}
		return result;
	}
}