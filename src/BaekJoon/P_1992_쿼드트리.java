package BaekJoon;

import java.util.*;

public class P_1992_쿼드트리 {

	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		dfs(0,0,N);
		System.out.println(sb);
	}
	
	public static void dfs(int r, int c, int size) {
		if(check(r, c, size)) {
			sb.append(arr[r][c]);
			return;
		}
		
		int newSize = size / 2;
		sb.append('(');
		dfs(r, c, newSize);
		dfs(r, c+newSize, newSize);
		dfs(r+newSize, c, newSize);
		dfs(r+newSize, c+newSize, newSize);
		sb.append(')');
	}
	
	public static boolean check(int r, int c, int size) {
		int color = arr[r][c];
		
		for(int i = r; i < r + size; i++) 
			for(int j = c; j < c + size; j++) 
				if(color != arr[i][j]) 
					return false;
					
		return true;
	}
}
