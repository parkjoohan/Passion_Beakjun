package BaekJoon;

import java.util.*;
import java.io.*;
import java.math.*;

/*public class P_2407_조합 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		System.out.println(comb(N, M));
	}
	
	public static int comb(int r, int c) {
		if(r==c||c==0)
			return 1;
		return comb(r-1, c-1) + comb(r-1, c);
	}
}*/

public class P_2407_조합 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		
		for (int i = 0; i < M; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(N-i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(n1.divide(n2));
	}
}