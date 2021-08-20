package BaekJoon;

import java.util.*;

public class P_10870_피보나치수5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] arr = new long[91];
		int n = sc.nextInt();
		
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i=2; i<=n; i++)
			arr[i] = arr[i-1] + arr[i-2];

		System.out.println(arr[n]);
	}
}
