package BaekJoon2;

import java.util.*;

public class P_5568_카드놓기 {

	static int N, K;
	static boolean[] visit;
	static int[] arr;
	static int[] list;
	
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		list = new int[N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		dfs(0);
		
		System.out.println(set.size());
	}
	
	public static void dfs(int depth) {
		if(depth == K) {
			String sum = "";
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			set.add(Integer.parseInt(sum));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = list[i];
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
}