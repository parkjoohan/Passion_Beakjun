package BaekJoon;

//중복조합
import java.util.*;
import java.io.*;

//public class P_15654_N과M_5 {
//	static int N, M;
//	public static int[] arr;
//	public static int[] result;
//	public static boolean[] check;
// 
//	public static void main(String[] args) {
// 
//		Scanner sc = new Scanner(System.in);
// 
//		N = sc.nextInt();
//		M = sc.nextInt();
// 
//		arr = new int[N];
//		result = new int[M];
//		check = new boolean[N];
//		
//		for(int i=0; i<N; i++)
//			arr[i] = sc.nextInt();
//		
//		Arrays.sort(arr);
//		Result(0);
//	}
// 
//	public static void Result(int idx) {
//		if (idx == M) {
//			for (int num : result) 
//				System.out.print(num + " ");
//			System.out.println();
//			return;
//		}
// 
//		for (int i = 0; i < N; i++) {
//			if (!check[i]) {
//				check[i] = true;
//				result[idx] = arr[i];
//				Result(idx + 1);
//				check[i] = false;
//			}
//		}
//	}
//}

public class P_15654_N과M_5 {
	static int N, M;
	static int[] arr;
	static int[] res;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		func(0);
		System.out.println(sb);
	}
	
	public static void func(int idx) {
		if(idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[idx] = arr[i];
				func(idx+1);
				visited[i] = false;
			}
		}
	}
}