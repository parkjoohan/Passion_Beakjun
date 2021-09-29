package BaekJoon;

import java.util.*;

public class P_14465_소가길을건너간이유5 {

	static int N, K, B;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		B = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = 1;
		}
		
		for (int i = 0; i < B; i++) {
			arr[i] = -1;
		}
		System.out.println(func(arr, B));
	}

	public static int func(int[] arr, int K) {
		int answer=0;
		int sum=0;
		int start=0;
		int end;
		
		for (end = 0; end < arr.length-K+1; end++) {
			sum+=arr[end];
			
			if(end>=(K-1)) {
				answer=Math.max(answer, sum);
				sum-=arr[start];
				start++;
			}
		}
		return answer;
	}
}
