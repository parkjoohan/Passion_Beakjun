package BaekJoon;

import java.util.*;
import java.io.*;

public class P_2407_조합 {

	static int N, M;
	static int totalCnt;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		totalCnt=0;
				
		Combination(0,0);
		System.out.println(totalCnt);
	}
	
	private static void Combination(int cnt, int start) {
		if(cnt == M) {
			return;
		}
		
		for(int i=start; i<=N; i++) {
			numbers[cnt] = i;
			Combination(cnt+1, i+1);
			totalCnt++;
		}
	}
}
