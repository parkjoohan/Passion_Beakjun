package BaekJoon;

import java.util.*;

public class P_11050_이항계수1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K =sc.nextInt();
		
		System.out.println(fac(N)/(fac(N-K)*fac(K)));
	}
	
	static int fac(int n) {
		int i=1;
		for (int j = 1; j <= n; j++) {
			i*=j;
		}
		return i;
	}
}