package BaekJoon2;

import java.util.*;

public class P_11050_이항계수1 {

	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		System.out.println(func(N) / (func(N-K) * func(K)));
	}
	
	public static int func(int N) {
		if(N <= 1)
			return 1;
		
		return N * func(N-1);
	}
}