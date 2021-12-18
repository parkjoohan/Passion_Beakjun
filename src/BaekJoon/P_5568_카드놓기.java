package BaekJoon;

import java.util.*;

public class P_5568_카드놓기 {

	static int N, K;
	static boolean[] visited;
	static int[] list;
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		list = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		func(0, "");
		System.out.println(set.size());
	}
	
	public static void func(int idx, String str) {
		if(idx==K) {
			set.add(str);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				func(idx+1, str+list[i]);
				visited[i]=false;
			}
		}
	}
}