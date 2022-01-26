package BaekJoon;

import java.util.*;

public class P_1015_수열정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		
		int[] arr2 = new int[N];
		for (int i = 0; i < N; i++) {
			arr2[i] = arr[i];
		}
		Arrays.sort(arr2);
		
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i] == arr2[j]) {
					arr2[j] = 0;
					result[i] = j;
					break;
				}
			}
		}
		
		for (int i = 0; i < N; i++)
			System.out.printf("%d ", result[i]);
	}
}