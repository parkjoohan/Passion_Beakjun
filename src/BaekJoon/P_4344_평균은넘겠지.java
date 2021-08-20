package BaekJoon;

import java.util.*;

public class P_4344_평균은넘겠지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			double sum = 0;
			
			for(int j=0; j<N; j++) {
				int score = sc.nextInt();
				arr[j] = score;
				sum += score;
			}
			double avg = sum / N;
			int cnt = 0;
			
			for(int k=0; k<N; k++) {
				if(arr[k] > avg) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%", ((double)cnt/N)*100);
			System.out.println();
		}
		
	}
}
