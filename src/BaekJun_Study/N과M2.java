package BaekJun_Study;

import java.util.*;

public class N과M2 {
	
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		visited = new boolean[N+1];
		
		back(0);
	}

	private static void back(int index) {
		if(index == M) {
			for(int i=0; i<M; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
                arr[index] = i;
                visited[i] = true;
                back(index + 1);
                // 재귀 호출이 끝난 후에 현재 i만 true로 해두고 나머지는 false로 바꾼다.
                for (int j = i + 1; j <= N; j++) {
                    visited[j] = false;
                }
            }
		}
	}
}