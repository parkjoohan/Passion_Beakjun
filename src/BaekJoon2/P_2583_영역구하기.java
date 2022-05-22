package BaekJoon2;

import java.util.*;

public class P_2583_영역구하기 {

	static int N,M,K, cnt=0;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[M][N];
		
		for (int i = 0; i < K; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					map[j][k]=1;
				}
			}
		}
		
		// 영역 넒이 저장
		list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0) {
					cnt = 0;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		
		for(Integer c : list)	System.out.print(c+" ");
	}
	
	public static void dfs(int r, int c) {
		map[r][c] = 1;
		cnt++;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr>=0 && nc>=0 && nr<M && nc<N)
				if(map[nr][nc]==0)
					dfs(nr, nc);
		}
	}
}