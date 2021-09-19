package BaekJoon;

import java.util.*;

public class P_2443_별찍기6 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N =sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = (2*N)-(i*2-1); j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}