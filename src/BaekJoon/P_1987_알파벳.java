package BaekJoon;

import java.util.*;

public class P_1987_알파벳 {

	static int R, C, max = 0;
	static int[][] arr;
	static boolean[] check = new boolean[26];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j) - 'A';
			}
		}
		dfs(0, 0, 0);
		System.out.println(max);
	}
	
	public static void dfs(int r, int c, int cnt) {
		if (check[arr[r][c]]) { 
			max = Math.max(max, cnt); 
			return;
		} else {
			check[arr[r][c]] = true;
			for (int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];

				if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
					dfs(nr, nc, cnt + 1);
				}
			}
			check[arr[r][c]] = false;
		}
	}
}