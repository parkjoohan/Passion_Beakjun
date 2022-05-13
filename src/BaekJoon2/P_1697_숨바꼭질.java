package BaekJoon2;

import java.util.*;

public class P_1697_숨바꼭질 {

	static int N, K;
	static int[] map = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		bfs();
		
		System.out.println(map[K]);
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		
		while(!q.isEmpty()) {
			N = q.poll();
			
			if(N == K)	break;
			
			if(N-1>=0 && map[N-1]==0) {
				q.offer(N-1);
				map[N-1] = map[N] + 1;
			}
			
			if(N+1<=100000 && map[N+1]==0) {
				q.offer(N+1);
				map[N+1] = map[N] + 1;
			}
			
			if(N*2<=100000 && map[N*2]==0) {
				q.offer(N*2);
				map[N*2] = map[N] + 1;
			}
		}
	}
}