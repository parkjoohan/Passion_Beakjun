package BaekJun_Study;

import java.util.*;

public class N과M1 {

	public static int[] arr;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[M];
		visited = new boolean[N];
		dfs(N, M, 0);
	}
	
	public static void dfs(int N, int M, int depth) {
		// 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
		if(depth == M) {
			for(int val : arr)
				System.out.print(val + " ");
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			// 만약 해당 노드(값)을 방문하지 않았다면?
			if(!visited[i]) {
				visited[i] = true;		// 해당 노드를 방문상태로 변경
				arr[depth] = i+1;		// 해당 깊이를 index로 하여 i+1 값 저장
				dfs(N, M, depth+1);		// 다음 자식 노드 방문을 위해 depth을 1 증가시키면서 재귀호출
				visited[i] = false;		// 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
			}
		}
	}
}