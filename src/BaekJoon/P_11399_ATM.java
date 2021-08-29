package BaekJoon;

import java.util.*;

public class P_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int sum=0, result=0;;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			sum+=arr[i];
			result+=sum;
		}
		System.out.println(result);
	}
}