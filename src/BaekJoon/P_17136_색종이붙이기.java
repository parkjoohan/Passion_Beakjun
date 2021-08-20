package BaekJoon;

import java.util.*;
 
public class P_17136_색종이붙이기 {
	static int[][] arr;		
	static int[] arr_num = {5,5,5,5,5};	// 각각의 색종이 개수
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0,0,0);
		
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}
	
	static void dfs(int r, int c, int cnt) {
		// (0,0)부터 마지막(9,9)까지 갈 경우에 색종이 최소값 구한다.
		if(r>=9 && c>9) {
			result = Math.min(result, cnt);
			return;
		}
		// cnt가 result보다 크거나 같으면 시간 낭비. 따라서 종료
		if(cnt>=result)
			return;
		// 줄마다 마지막 칸을 넘을 경우 다음 줄로 가기
		if(c>9) {
			dfs(r+1,0,cnt);
			return;
		}
		// 색종이 제일 큰 거 부터
		if(arr[r][c]==1) {
			for(int i=4; i>=0; i--) {
				if(arr_num[i]>0 && check(r,c,i+1)) {
					add(r,c,i+1);
					// 색종이 개수 줄이기
					arr_num[i]--;
					// 계속 붙이기
					dfs(r,c+1,cnt+1);
					// 색종이 제거
					remove(r,c,i+1);
					// 색종이 떼서 개수 늘리기
					arr_num[i]++;
				}
			}
		}
		// 배열 값에 1이 없으면
		else
			dfs(r,c+1,cnt);
	}
	
	// 색종이 붙이기
	static void add(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				arr[i][j]=0;
			}
		}
	}
	
	// 색종이 제거
	static void remove(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				arr[i][j]=1;
			}
		}
	}
	
	// 색종이 붙일 수 있는지
	static boolean check(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(!range(i,j) || arr[i][j] != 1)
					return false;
			}
		}
		return true;
	}
	
	// 범위 확인
	static boolean range(int r, int c) {
		return r>=0 && c>=0 && r<10 && c<10;
	}
}