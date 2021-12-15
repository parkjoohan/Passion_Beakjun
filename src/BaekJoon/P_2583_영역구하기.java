package BaekJoon;

import java.util.*;

public class P_2583_영역구하기 {

	static int M, N ,K;
	static int map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int cnt = 0;
	static ArrayList<Integer> list = new ArrayList<Integer>();
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
			
			for (int a = y1; a < y2; a++) {
				for (int b = x1; b < x2; b++) {
					map[a][b]=1;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0) {
					cnt=0;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int c : list)
			System.out.print(c+" ");
	}
	public static void dfs(int r, int c) {
		map[r][c]=1;
		cnt++;
		
		for (int d = 0; d < 4; d++) {
			int R = r + dr[d];
			int C = c + dc[d];
			
			if(R>=0 && C>=0 && R<M && C<N)
				if(map[R][C]==0)
					dfs(R,C);
		}
	}
}
