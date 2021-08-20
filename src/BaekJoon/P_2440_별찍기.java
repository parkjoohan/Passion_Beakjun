package BaekJoon;

import java.util.*;

public class P_2440_별찍기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<=N; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}