package BaekJoon;

import java.util.*;

public class P_1182_부분수열의합 {

	static int N, S, cnt; 
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr= new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		dfs(0,0);
		System.out.println(S==0? --cnt : cnt);
	}
	
	public static void dfs(int depth, int sum) {
		if(depth==N) {
			if(sum==S)
				cnt++;
			return;
		}
		
		// dfs 호출 시, 지금 원소를 합에 더하는 부분
		dfs(depth+1, sum+arr[depth]);
		// dfs 호출 시, 지금 원소를 빼고 구하는 부분
		dfs(depth+1, sum); 
	}
}
