package BaekJoon;

import java.util.*;

public class 안전영역_2468 {

	static int N, cnt, max;		// 안전 지역
	static int[][] map;
	static int[][] change;
	static boolean[][] check;
	
	static int[] dr = {-1,1,0,0};	//상하좌우
	static int[] dc = {0,0,-1,1};	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		max = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				map[i][j] = sc.nextInt();
		}
		
		for(int i=1; i<=100; i++) {
			change = new int[N][N];
			check = new boolean[N][N];
			cnt=0;
			
			// 높이가 해당 높이 보다 낮으면 0 높으면 1
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k] <= i)
						change[j][k]=0;
					else
						change[j][k]=1;
				}
			}
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(change[j][k]==1 && !check[j][k]) {
						func(j,k);
						cnt++;
					}
				}
			}
			max = Math.max(max,  cnt);o
		}
		System.out.println(max);
	}

	static void func(int r, int c) {
		check[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=0 && nc>=0 && nr<N && nc<N){
				if(change[nr][nc]==1 && !check[nr][nc])
					func(nr,nc);
			}
		}
	}
}
