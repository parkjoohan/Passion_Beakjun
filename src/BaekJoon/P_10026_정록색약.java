package BaekJoon;

import java.util.*;

public class P_10026_정록색약 {

	static int N;
	static String str;
	static char map[][];
	static boolean visited[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 정상인
		int cnt1=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					cnt1++;
				}
			}
		}
		
		// 정록색약(G를 R로 바꿈)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='G')
					map[i][j]='R';
			}
		}
		int cnt2=0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int R = r + dr[d];
			int C = c + dc[d];
			
			if(R>=0 && C>=0 && R<N && C<N) {
				if(map[R][C]==map[r][c] && !visited[R][C])
					dfs(R, C);
			}
		}
	}
}