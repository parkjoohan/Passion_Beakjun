package BaekJoon2;

import java.util.*;

public class P_10974_모든순열 {

	static int N;
	static int[] numbers;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		visited = new boolean[N];
		
		perm(0);
	}
	
	public static void perm(int cnt) {
		if(cnt==N) {
			for (int i = 0; i < N; i++) {
				System.out.print(numbers[i]+ " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])
				continue;
			
			numbers[cnt] = i+1;
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;			
		}
	}
}