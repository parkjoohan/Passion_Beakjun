package BaekJoon;

// 중복순열
import java.util.*;
import java.io.*;

public class P_15651_N과M_3 {
	public static int[] arr;
	public static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
 
		arr = new int[N+1];
		check = new boolean[N+1];
		Result(M, N, 0);
		
		System.out.println(sb); 
	}
 
	public static void Result(int M, int N, int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) { 
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
 
		for (int i = 1; i <= N; i++) {
				arr[idx] = i;
				Result(M, N, idx + 1);	
		}
	}
}