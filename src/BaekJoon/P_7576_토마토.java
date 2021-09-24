package BaekJoon;

import java.util.*;
public class P_7576_토마토 {

	static int N, M; 
	static int[][] arr;
	static int max = Integer.MIN_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<tomato> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		q = new LinkedList<tomato>();
		
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				// 익은 토마토는 큐에 넣기
				if(arr[i][j]==1)
					q.add(new tomato(i,j));
			}
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		while (!q.isEmpty()) { 
			tomato t = q.remove();
			
			int x = t.x;
			int y = t.y;
			// 동, 서, 남, 북 탐색
			for (int i = 0; i < 4; i++) { 
				int X = x + dx[i];
				int Y = y + dy[i];
 
				// 범위 안에서 안 익은 토마토는 익은 토마토로 추가
				if(X>=0 && Y>=0 && X<N && Y<M) {
					if(arr[X][Y]==0) {
						q.add(new tomato(X,Y));
					
						// 익은 날짜를 알기 위해 전 값에 +1
						arr[X][Y] = arr[x][y]+1;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				// 안 익은 토마토
				if(arr[i][j] == 0) 
					return -1;
				max = Math.max(max, arr[i][j]);
			}
		}
		
		// 토마토 모두 익었을 때
		if(max==1)
			return 0;
		// 전체 일수는 최대 날짜 -1
		else
			return max-1;
	}
}

class tomato {
	int x;
	int y;
	
	tomato(int x, int y){
		this.x = x;
		this.y = y;
	}
}