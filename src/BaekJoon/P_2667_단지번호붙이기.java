package BaekJoon;

import java.util.*;

//public class P_2667_단지번호붙이기 {
//
//	static int N,cnt;
//	static int[][]map;
//	static int[][]check;
//	
//	static ArrayList<Integer> list = new ArrayList<Integer>();
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		map = new int[N][N];
//		check = new int[N][N];
//    
//		for(int i=0; i<N; i++) {
//			String input = sc.next();
//			for(int j=0; j<N; j++)
//				map[i][j] = input.charAt(j)-'0';
//		}
//    
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) 
//				// 맵상 값이 1이고, 방문하지 않았다면
//				if(map[i][j] == 1 && check[i][j] == 0) {
//					// 첫번째 1 방문의 경우 단지 숫자 1부여, 그 후 재귀를 통해 단지 수 높아진다.
//					cnt = 1;
//					func(i,j);
//					list.add(cnt);
//				}
//		}   
//		Collections.sort(list);
//		System.out.println(list.size());
//		for(int i=0;i<list.size();i++)
//			System.out.println(list.get(i));
//
//	}
//
//	static int func(int r, int c) {
//		check[r][c] = 1;
//    
//		for(int i=0;i<4;i++){
//			int nr = r+dr[i];
//			int nc = c+dc[i];
//    
//			if(nr>=0 && nc>=0 && nr<N && nc<N) {
//				if(map[nr][nc] == 1 && check[nr][nc] == 0){
//					func(nr,nc);
//                	cnt++;
//				}
//			}
//		}
//		return cnt;
//	}
//	static int dr[] = {-1, 1, 0, 0};
//	static int dc[] = {0, 0, -1, 1};
//}

public class P_2667_단지번호붙이기 {
	static int N, cnt;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		cnt=0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					cnt=1;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (int i : list) 
			System.out.println(i);
	}
	
	public static int dfs(int r, int c) {
		visited[r][c]=true;
		
		for (int d = 0; d < 4; d++) {
			int R = r + dr[d];
			int C = c + dc[d];
			
			if(R>=0 && C>=0 && R<N && C<N) {
				if(map[R][C]==1 && !visited[R][C]) {
					dfs(R,C);
					cnt++;
				}
			}
		}
		return cnt;
	}
}