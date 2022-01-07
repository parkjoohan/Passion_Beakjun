package BaekJoon;

import java.util.*;

public class P_1037_약수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			max = N > max ? N : max;
			min = N < min ? N : min;
		}
		System.out.println(max*min);
	}
}