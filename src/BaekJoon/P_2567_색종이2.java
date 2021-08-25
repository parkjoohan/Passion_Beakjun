package BaekJoon;

import java.util.*;

public class P_2567_색종이2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[101][101];
		int cnt=0;

		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for (int j = a; j < a+10; j++) {
				for (int k = b; k < b+10; k++) {
					if(arr[j][k]==1)
						continue;
					else
						arr[j][k] =1;
				}
			}
		}
			
		for (int j = 0; j < arr.length; j++) {
			for (int k = 0; k < arr.length; k++) {
				if(j>0 && k>0 && arr[j][k]==1) {
					if(arr[j][k-1] == 0)	// 좌 
						cnt++;
					if(arr[j][k+1] == 0)	// 우 
						cnt++;
					if(arr[j-1][k] == 0)	// 상 
						cnt++;
					if(arr[j+1][k] == 0)	// 하 
						cnt++;
				}
			}
		}
		System.out.println(cnt);
	}	
}