package BaekJoon;

import java.util.*;

public class P_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[100][100];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int j=a; j<a+10; j++)
				for (int k = b; k < b+10; k++)
					map[j][k]=1;
		}
			
		for(int j=0; j<100; j++)
			for (int k=0; k<100; k++)
				if(map[j][k]==1)
					cnt++;

		System.out.println(cnt);
	}
}