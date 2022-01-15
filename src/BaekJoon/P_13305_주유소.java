package BaekJoon;

import java.util.*;

public class P_13305_주유소 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] road = new int[N-1];
		int[] oil = new int[N];
		
		for (int i = 0; i < N-1; i++) {
			road[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			oil[i] = sc.nextInt();
		}
		long sum = 0;
		long min = oil[0];
		
		for (int i = 0; i < N-1; i++) {
			if(oil[i]<min)
				min=oil[i];
			
			sum += (min * road[i]);
		}
		System.out.println(sum);
	}
} 