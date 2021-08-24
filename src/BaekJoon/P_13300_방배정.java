package BaekJoon;

import java.util.*;

public class P_13300_방배정 {

	static int N, K, S, Y, cnt=0;
	static int[][] student = new int[2][7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			S = sc.nextInt();
			Y = sc.nextInt();
			student[S][Y]++;
		}
		
		for(int i=0; i<2; i++) {
			for(int j=1; j<7; j++) {
				int num = student[i][j];
				
				if(num%K != 0)
					cnt++;

				cnt += num / K;	
			}
		}
		System.out.println(cnt);
	}
}