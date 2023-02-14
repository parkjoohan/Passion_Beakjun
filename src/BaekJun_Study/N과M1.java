package BaekJun_Study;

import java.util.*;

public class N과M1 {

	static int N, M;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N+1];
		arr = new int[N+1];
		
		back(0);
	}
	
	private static void back(int index) {
		if(index == M) {
			for(int i=0; i<M; i++) 
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i])	continue;
			visited[i] = true;
			arr[index] = i;
			back(index+1);
			visited[i] = false;
		}
	}
}