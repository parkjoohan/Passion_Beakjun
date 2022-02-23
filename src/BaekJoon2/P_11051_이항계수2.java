package BaekJoon2;

import java.util.*;

public class P_11051_이항계수2 {

	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		System.out.println((func(N) / (func(N-K) * func(K))) % 10007);
	}

	static int func(int n) {
		int i=1;
		for (int j = 1; j <= n; j++) {
			i*=j;
		}
		return i;
	}
}