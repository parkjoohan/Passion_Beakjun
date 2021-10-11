package BaekJoon;

import java.util.Scanner;

public class P_10039_평균점수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			int T = sc.nextInt();
			
			if(T<40) 
				T = 40;
			sum += T;
		}
		int avg = sum / 5;
		System.out.println(avg);
	}
}