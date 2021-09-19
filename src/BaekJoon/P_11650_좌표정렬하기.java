package BaekJoon;

import java.util.*;

public class P_11650_좌표정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(arr, new Comparator<int []>() {
			public int compare(int o1[], int o2[]) {
				// 1열의 길이 같을 경우 2열의 값을 비교, 작은 값이 위로 가게 정렬
				if(o1[0] == o2[0])
					return o1[1]-o2[1];
				// 1열부터 값이 차이가 있는 경우 1열을 기준으로 정렬
				else
					return o1[0]-o2[0];
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