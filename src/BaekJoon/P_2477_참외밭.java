package BaekJoon;

import java.util.*;

public class P_2477_참외밭 {

	static int N, result;
	static int big, small, all;
	static int[] dir = new int[6];
	static int[] len = new int[6];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < 6; i++) {
			dir[i] = sc.nextInt();
			len[i] = sc.nextInt();
		}
		
		big = len[0] * len[1];
		small = Math.abs(len[0] - len[2]) * len[3];
		
		all = big - small;
		result = all * N;
		
		System.out.println(result);
	}
}