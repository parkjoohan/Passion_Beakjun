package BaekJoon;

import java.util.*;

public class P_10163_색종이 {

	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[101][101];

		for(int tc=1; tc<=N; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
	
			for(int i=x; i<x+a; i++) {
				for(int j=y; j<y+b; j++) {
					map[i][j] = tc;
				}
			}
		}
		for(int tcc=1; tcc<=N; tcc++) {
			int cnt=0;
			for(int i=0; i<101; i++) {
				for(int j=0; j<101; j++) {
					if(map[i][j] == tcc)	cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}