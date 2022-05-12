//package BaekJoon2;
//
//import java.util.*;
//
//public class P_2667_단지번호붙이기 {
//
//	static int N;	// 지도 크기
//	static int[][] map;		// 2차원 배열 지도
//	static int cnt;			// 집의 숫자
//	static int dx[] = {0,0,1,-1};	// 상하좌우
//	static int dy[] = {1,-1,0,0};
//	static ArrayList<Integer> list;		// 집의 수 저장 
//	static boolean[][] check;	// 방문체크
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();	// 지도 크기
//		map = new int[N][N];	// 2차원 배열 지도
//		check = new boolean[N][N];	// 방문 체크
//		
//		// 지도 배열값 입력
//		for (int i = 0; i < N; i++) {
//			String input = sc.next();
//			for (int j = 0; j < N; j++) {
//				map[i][j] = input.charAt(j)-'0';
//			}
//		}
//		
//		// 단지 집의 숫자
//		cnt = 0;
//		
//		// 단지 집의 수 결과 저장
//		list = new ArrayList<>();
//		
//		// 지도 전체 탐색
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				
//				// 현재 위치의 값이 1이고 true라면
//				if(map[i][j]==1 && !check[i][j]) {
//					
//					// 맨 처음이므로 cnt +1 증가
//					cnt=1;
//					Search(i, j);
//					list.add(cnt);
//				}
//			}
//		}
//		
//		Collections.sort(list);
//		System.out.println(list.size());
//		for(int c : list)
//			System.out.println(c);
//	}
//	
//	public static int Search(int x, int y) {
//		
//		check[x][y] = true;
//		
//		// 4방향 확인
//		for (int i = 0; i < 4; i++) {
//			int nx = x + dx[i];
//			int ny = y + dy[i];
//			
//			if(nx>=0 && ny>=0 && nx<N && ny<N) {
//				if(map[nx][ny]==1 && !check[nx][ny]) {
//					Search(nx, ny);
//					cnt++;
//				}
//			}
//		}
//		return cnt;
//	}
//}

package BaekJoon2;

import java.util.*;

public class P_2667_단지번호붙이기 {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int N, cnt;
	static int[][] map;
	static boolean[][] check;
	static ArrayList<Integer> list = new ArrayList<>();;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		check = new boolean[N][N];
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1 && !check[i][j]) {
					cnt=1;
					Search(i, j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int c : list)	System.out.println(c);
	}
	
	public static int Search(int x, int y) {
		check[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(map[nx][ny]==1 && !check[nx][ny]) {
					Search(nx, ny);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}