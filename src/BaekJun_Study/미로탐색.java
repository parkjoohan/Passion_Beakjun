package BaekJun_Study;

import java.io.*;
import java.util.*;

public class 미로탐색 {

	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static boolean[][] visited;
	static int[][] arr;
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		
		BFS(0,0);
		System.out.println(arr[N-1][M-1]);
	}

	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});	// 먼저, 첫번째 값 넣어주기
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			visited[i][j] = true;
			
			for(int k=0; k<4; k++) {
				int x= now[0] + dx[k];
				int y= now[1] + dy[k];
				
				if(x>=0 && y>=0 && x<N && y<M) {		// 배열 넘어가면 안됨
					if(arr[x][y]!=0 && !visited[x][y]) {	// 0이여서 갈 수 없거나 기방문한 곳이면 안됨
						visited[x][y]=true;
						arr[x][y] = arr[now[0]][now[1]] + 1;
						queue.add(new int[] {x, y});
					}
				}
			}
		}
	}
}
