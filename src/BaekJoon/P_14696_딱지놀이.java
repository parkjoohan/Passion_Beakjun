package BaekJoon;

import java.util.*;

public class P_14696_딱지놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int[] A = new int[100];
		int[] B = new int[100];
		
		for (int i = 0; i < N; i++) {
			int T = sc.nextInt();
			for (int j = 0; j < T; j++) {
				A[j] = sc.nextInt();
			}
			int R = sc.nextInt();
			for (int j = 0; j < R; j++) {
				B[j] = sc.nextInt();
			}
		}

	}

}
