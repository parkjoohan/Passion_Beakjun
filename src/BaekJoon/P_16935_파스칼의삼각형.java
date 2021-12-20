package BaekJoon;

import java.util.*;

public class P_16935_파스칼의삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(comb(N-1, K-1));
	}
	
	public static int comb(int n, int k) {
		if(n==k || k==0)	return 1;
		return comb(n-1, k-1) + comb(n-1, k);
	}
}