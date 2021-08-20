package BaekJoon;

import java.util.*;

public class P_15663_N과M_9 {
	static int N, M;
	public static int[] arr;
	public static int[] result;
	public static boolean[] check;

	static StringBuilder sb = new StringBuilder();
 
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
		Result(0);
		System.out.println(sb);
	}
 
	public static void Result(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) 
				sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}
		else {
			int before=0;	// 이전 값
			for (int i = 0; i < N; i++) {
				if (check[i])	// 뽑았던 거일때
					continue;
				else if(before!=arr[i]){
					check[i] = true;
					result[idx] = arr[i];
					before = arr[i];
					Result(idx + 1);
					check[i] = false;
				}
			}
		}
	}
}