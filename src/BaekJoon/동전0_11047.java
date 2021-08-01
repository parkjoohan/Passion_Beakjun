package BaekJoon;

import java.util.*;

public class 동전0_11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		int cnt=0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int j=N-1; j>=0; j--) {
			if(arr[j]<=K) {
				cnt += (K/arr[j]);
				K = K % arr[j];
			}
		}
		System.out.println(cnt);
	}
}