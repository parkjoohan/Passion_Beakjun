package BaekJoon2;

import java.util.*;

public class P_1799_비숍 {

	static int N, cnt=0;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][N+1];

		backtracking(1);
		System.out.println(cnt);
	}

	public static void backtracking(int depth) {
		
	}
	
	public static boolean available(int depth) {
		for (int i = 1; i < depth; i++) {
			if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i]))
		}
	}
}
