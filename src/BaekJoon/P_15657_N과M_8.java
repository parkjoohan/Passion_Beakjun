package BaekJoon;

import java.util.*;

public class P_15657_N과M_8 {
	static int N, M;
	public static int[] arr;
	public static int[] result;
	static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
		M = sc.nextInt();
 
		arr = new int[N];
		result = new int[M];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		Result(0, 0);
		System.out.println(sb);
	}
 
	public static void Result(int cnt, int idx) {
		if (idx == M) {
			for (int num : result) 
				sb.append(num + " ");
			sb.append("\n");
			return;
		}
 
		for (int i = cnt; i < N; i++) {
			result[idx] = arr[i];
			Result(i, idx + 1);
		}
	}
}