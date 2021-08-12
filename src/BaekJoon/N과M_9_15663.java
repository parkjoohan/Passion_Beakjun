package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_9_15663 {
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
			for (int num : result) 
				sb.append(num + " ");
			sb.append("\n");
			return;
		}
		int before=0;
		for (int i = 0; i < N; i++) {
			if (check[i])continue;
			else if(!(check[i] && (i==0 || before !=arr[i]))){
				before =arr[i];	
				result[idx] = arr[i];
				check[i] = true;
				Result(idx + 1);
				check[i] = false;
			}
		}
	}
}