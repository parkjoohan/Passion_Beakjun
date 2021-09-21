package BaekJoon;

import java.util.*;

public class P_11404_플로이드 {

	static int N, M;
	static int INF = 10000001;
	static int[][] dp = new int[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = INF;
			}
		}
		
		// 간선 입력받기
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			dp[a][b] = Math.min(dp[a][b], c);
		}
		
		// 플로이드-워샬
		// 경유노드
		for(int k = 1; k <= N; k++){
			// 시작노드
            for(int i = 1; i <= N; i++){
            	//도착노드
                for(int j = 1; j <= N; j++){
                    if(i!=j && dp[i][k]!=INF && dp[k][j]!=INF){
                        dp[i][j] = Math.min(dp[i][j] , dp[i][k] + dp[k][j]);
                    }
                }
            }
        }
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 갈 수 없는 경우 0 출력
				if(dp[i][j]==INF)
					System.out.print(0+" ");
				else
					System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
}