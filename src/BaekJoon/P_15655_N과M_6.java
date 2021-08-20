package BaekJoon;

import java.util.*;

public class P_15655_N과M_6 {
	static int N, M;
	public static int[] arr;
	public static int[] result;
	public static boolean[] check;
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
		M = sc.nextInt();
 
		arr = new int[N];
		result = new int[M];
		check = new boolean[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		Result(0, 0);
	}
 
	public static void Result(int idx, int cnt) {
		if (idx == M) {
			for (int num : result) 
				System.out.print(num + " ");
			System.out.println();
			return;
		}
 
		for (int i = cnt; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				result[idx] = arr[i];
				Result(idx + 1, i+1);
				check[i] = false;
			}
		}
	}
}