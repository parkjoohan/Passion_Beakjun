package BaekJoon;

import java.util.*;

public class 종이의개수_1780 {
	 
		static int N;
		static int[][] board;
		static int GRAY = 0, WHITE = 0, BLACK = 0;	
	 
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in); 
			int N = sc.nextInt();
			board = new int[N][N];
	 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			dfs(0, 0, N);
			System.out.println(GRAY);	// -1
			System.out.println(WHITE);	// 0
			System.out.println(BLACK);	// 1
		}
	 
		
		public static void dfs(int r, int c, int size) {
	 
			// 만약 같은 색상으로 이루어져있다면 해당 색상 카운트를 증가시킨다.
			if (check(r, c, size)) {
				if(board[r][c] == -1) { 
					GRAY++;
				}
				else if(board[r][c] == 0) {
					WHITE++;
				}
				else {
					BLACK++;
				}
				return;
			}	 
			int newSize = size / 3;	
			dfs(r, c, newSize);								// 왼쪽 위
			dfs(r, c + newSize, newSize);					// 중앙 위
			dfs(r, c + 2 * newSize, newSize);				// 오른쪽 위
			
			dfs(r + newSize, c, newSize);					// 왼쪽 중간
			dfs(r + newSize, c + newSize, newSize);			// 중앙 중간
			dfs(r + newSize, c + 2 * newSize, newSize);		// 오른쪽 중간
			
			dfs(r + 2 * newSize, c, newSize);				// 왼쪽 아래
			dfs(r + 2 * newSize, c + newSize, newSize);		// 중앙 아래
			dfs(r + 2 * newSize, c + 2 * newSize, newSize);	// 오른쪽 아래 
		}
	 
		// 해당 영역이 같은 색인지 검사하는 메소드
		public static boolean check(int r, int c, int size) {
			int color = board[r][c];
	 
			// 각 블럭의 시작점(row, col)부터 블럭의 끝(row + size, col + size)까지 검사
			for (int i = r; i < r + size; i++) {
				for (int j = c; j < c + size; j++) {
					if (color != board[i][j]) {
						return false;
				}
			}
		}
		return true;
	}
}