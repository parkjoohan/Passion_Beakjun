package BaekJoon;

import java.util.*;

public class P_2630_색종이만들기 {
	
	static int[][] arr;
	static int BLUE=0, WHITE=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,0,N);
		System.out.println(WHITE);
		System.out.println(BLUE);
	}
	
	static boolean check(int row, int col, int size) {
		
		int color = arr[row][col];	// 첫 번째 원소를 기준으로 검사
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				// 색상이 같이 않다면 false를 리턴 
				if(arr[i][j] != color) {
					return false;
				}
			}
		}
		// 검사가 모두 통과했다는 의미이므로 true 리턴
		return true;
	}
	
	static void dfs(int row, int col, int size) {

		if(check(row, col, size)) {
			if(arr[row][col] == 0) {
				WHITE++;
			}
			else {
				BLUE++;
			}
			return;
		}
		
		int newSize = size / 2;	
		// 재귀 호출
		dfs(row, col, newSize);							// 2사분면
		dfs(row, col + newSize, newSize);				// 1사분면
		dfs(row + newSize, col, newSize);				// 3사분면
		dfs(row + newSize, col + newSize, newSize);		// 4사분면
	}
}
