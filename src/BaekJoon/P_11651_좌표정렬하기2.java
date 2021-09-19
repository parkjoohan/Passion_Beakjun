package BaekJoon;

import java.util.*;

public class P_11651_좌표정렬하기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(arr, new Comparator<int []>() {
			public int compare(int o1[], int o2[]) {
				if(o1[1]==o2[1])
					return o1[0]-o2[0];
				else
					return o1[1]-o2[1];
			}
		});
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}