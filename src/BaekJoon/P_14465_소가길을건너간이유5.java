package BaekJoon;

import java.util.*;

public class P_14465_소가길을건너간이유5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int B = sc.nextInt();
		
		int[] sum = new int[N+1];
		boolean[] Broken = new boolean[N+1];
		// 고장난 신호등 B개
		for(int i = 0; i < B; i++) {
			int num = sc.nextInt(); 
			Broken[num] = true;
		}
		
		int cnt = 0;
		for(int i = 1; i < K + 1; i++) { // 연속한 K개 신호등 수리
			if(Broken[i]) cnt++; // 망가진 개수 카운트
		}
		
		// 연속한 K 개의 신호등이 존재하도록 함
		sum[K] = cnt;
		int res = Integer.MAX_VALUE;
		
		for(int i = K + 1; i <= N; i++) { 
			// 모든 K길이 구간에 대해 가장 적게 고장난 신호등 개수 구하기
			int tmp = sum[i-1];
			// 이번 횡단보도가 망가졌다면
			if(Broken[i]) tmp++;
			// K번째 전에 망가진 횡단보도가 있었다면
			if(Broken[i-K]) tmp--;
			
			sum[i] = tmp;
			res = Math.min(res,  tmp);
		}
		System.out.println(res);		
	}
} 