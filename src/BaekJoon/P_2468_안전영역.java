package BaekJoon;

import java.util.*;

//public class P_2468_안전영역 {
//
//	static int N, cnt, max;		// 안전 지역
//	static int[][] map;
//	static int[][] change;
//	static boolean[][] check;
//	
//	static int[] dr = {-1,1,0,0};	//상하좌우
//	static int[] dc = {0,0,-1,1};	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		map = new int[N][N];
//		max = 1;
//		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++)
//				map[i][j] = sc.nextInt();
//		}
//		
//		for(int i=1; i<=100; i++) {
//			change = new int[N][N];
//			check = new boolean[N][N];
//			cnt=0;
//			
//			// 높이가 해당 높이 보다 낮으면 0 높으면 1
//			for(int j=0; j<N; j++) {
//				for(int k=0; k<N; k++) {
//					if(map[j][k] <= i)
//						change[j][k]=0;
//					else
//						change[j][k]=1;
//				}
//			}
//			for(int j=0; j<N; j++) {
//				for(int k=0; k<N; k++) {
//					if(change[j][k]==1 && !check[j][k]) {
//						func(j,k);
//						cnt++;
//					}
//				}
//			}
//			max = Math.max(max,  cnt);
//		}
//		System.out.println(max);
//	}
//
//	static void func(int r, int c) {
//		check[r][c] = true;
//		
//		for(int i=0; i<4; i++) {
//			int nr = r+dr[i];
//			int nc = c+dc[i];
//			
//			if(nr>=0 && nc>=0 && nr<N && nc<N){
//				if(change[nr][nc]==1 && !check[nr][nc])
//					func(nr,nc);
//			}
//		}
//	}
//}

//public class P_2468_안전영역 {
//
//	static int N, cnt, max;
//	static int map[][];
//	static int change[][];
//	static boolean visited[][];
//	static int dr[] = {-1,1,0,0};
//	static int dc[] = {0,0,-1,1};
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		map = new int[N][N];
//		max=1;
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				map[i][j] = sc.nextInt();
//			}
//		}
//		
//		for (int i = 1; i <=100; i++) {
//			change = new int[N][N];
//			visited = new boolean[N][N];
//			cnt=0;
//			
//			for (int j = 0; j < N; j++) {
//				for (int k = 0; k < N; k++) {
//					if(map[j][k]<=i)
//						change[j][k]=0;
//					else
//						change[j][k]=1;
//				}
//			}
//			for (int j = 0; j < N; j++) {
//				for (int k = 0; k < N; k++) {
//					if(change[j][k]==1 && !visited[j][k]) {
//						dfs(j,k);
//						cnt++;
//					}
//				}
//			}
//			max = Math.max(max, cnt);
//		}
//		System.out.println(max);
//	}
//	
//	public static void dfs(int r, int c) {
//		visited[r][c]=true;
//		
//		for (int d = 0; d < 4; d++) {
//			int R = r + dr[d];
//			int C = c + dc[d];
//			
//			if(R>=0 && C>=0 && R<N && C<N)
//				if(change[R][C]==1 && !visited[R][C])
//					dfs(R,C);
//		}
//	}
//}


//public class P_2468_안전영역 {
//
//	static int N, cnt, max;
//	static int map[][];
//	static int change[][];
//	static boolean visited[][];
//	static int dx[] = {-1,1,0,0};
//	static int dy[] = {0,0,-1,1};
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		
//		for(int tc=1; tc<=T; tc++) {
//			N = sc.nextInt();
//			map = new int[N][N];
//			visited = new boolean[N][N];
//			change = new int[N][N];
//			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					map[i][j] = sc.nextInt();
//				}
//			}
//			
//			for (int i = 1; i <=100; i++) {
//				change = new int[N][N];
//				visited = new boolean[N][N];
//				cnt=0;
//				
//				for (int j = 0; j < N; j++) {
//					for (int k = 0; k < N; k++) {
//						if(map[j][k]<=i)
//							change[j][k]=0;
//						else
//							change[j][k]=1;
//					}
//				}
//				for (int j = 0; j < N; j++) {
//					for (int k = 0; k < N; k++) {
//						if(change[j][k]==1 && !visited[j][k]) {
//							dfs(j,k);
//							cnt++;
//						}
//					}
//				}
//				max = Math.max(max, cnt);
//			}
//			System.out.println("#"+tc+" "+max);
//		}	
//	}
//	
//	public static void dfs(int x, int y) {
//		visited[x][y]=true;
//		
//		for (int d = 0; d < 4; d++) {
//			int nx = x + dx[d];
//			int ny = y + dy[d];
//			
//			if(nx>=0 && ny>=0 && nx<N && ny<N)
//				if(change[nx][ny]==1 && !visited[nx][ny])
//					dfs(nx,ny);
//		}
//	}
//}


public class P_2468_안전영역 {

	static int N, cnt, max;
	static int map[][];
	static int change[][];
	static boolean visited[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			change = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 1; i <=100; i++) {
				change = new int[N][N];
				visited = new boolean[N][N];
				cnt=0;
				
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(map[j][k]<=i)
							change[j][k]=0;
						else
							change[j][k]=1;
					}
				}
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(change[j][k]==1 && !visited[j][k]) {
							dfs(j,k);
							cnt++;
						}
					}
				}
				max = Math.max(max, cnt);
			}
			System.out.println("#"+tc+" "+max);
		}	
	}
	
	public static void dfs(int x, int y) {
		visited[x][y]=true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N)
				if(change[nx][ny]==1 && !visited[nx][ny])
					dfs(nx,ny);
		}
	}
}