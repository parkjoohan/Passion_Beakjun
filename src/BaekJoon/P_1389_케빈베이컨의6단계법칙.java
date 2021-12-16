package BaekJoon;

import java.util.*;

public class P_1389_케빈베이컨의6단계법칙 {

	static int N, M;
	static int map[][];
	static int INF = 987654321;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j]=INF;
				if(i==j) map[i][j]=0;
			}
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		
		// 플로이드-와샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j]>map[i][k]+map[j][k])
						map[i][j]=map[i][k]+map[j][k];
				}
			}
		}
		
		// 최소 구하기
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			int sum=0;
			for (int j = 1; j <= N; j++) {
				sum += map[i][j];
			}
			
			if(max>sum) {
				max=sum;
				min=i;
			}
		}
		System.out.println(min);
	}
}