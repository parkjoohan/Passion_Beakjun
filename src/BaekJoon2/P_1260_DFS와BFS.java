package BaekJoon2;

import java.util.*;

public class P_1260_DFS와BFS {
	public static int[][] arr;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		arr = new int[N+1][N+1];
		
		for(int i=1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
        // 깊이우선탐색
		visited = new boolean[N+1];
		dfs(V); 
		
		System.out.println();
        
        // 너비우선탐색
		visited = new boolean[N+1];
		bfs(V); 

		
	}
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start+ " ");
		
		if(start == arr.length) {
			return;
		}

		for(int i=1; i<arr.length; i++) {
			if(arr[start][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
			
	}
	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>(); 
		
		que.add(start);
		visited[start] = true;
 		System.out.print(start+ " ");
		
		while(!que.isEmpty()) {
			
			int temp = que.peek();
			que.poll();
			for(int i=1; i<arr.length;i++) {
				if(arr[temp][i] ==1 && visited[i] == false) {
					que.add(i);
					visited[i] = true;
					System.out.print(i+ " ");
				}
			}
		}
	}
}