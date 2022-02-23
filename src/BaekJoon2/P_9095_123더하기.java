package BaekJoon2;

import java.util.*;

public class P_9095_123더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] arr = new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt();
			
			for (int j = 4; j <= N; j++) {
				arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
			}
			System.out.println(arr[N]);
		}
	}
}