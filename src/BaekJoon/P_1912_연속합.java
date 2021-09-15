package BaekJoon;

import java.util.Scanner;

public class P_1912_연속합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum=0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			sum+=num;
			max = Math.max(max, sum);
			if(sum<0)	sum=0;
		}
		System.out.println(max);
	}
} 