package BaekJoon;

import java.util.*;

public class P_2805_나무자르기 {

	static int N, M;
	static long max = 0;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		
		long start=0;
		long end=max;
		
		while(start<=end) {
			long mid = (start+end)/2;
			long sum=0;
			
			for(int tree:arr) {
				// 자를수있는 나무인 경우
				if(tree>mid)
					sum+=tree-mid;
			}
			
			// 잘라낸 나무들의 합이 최소한으로 가져야 하는 나무 길이보다 큰 경우
			if(sum>=M)
				start=mid+1;
			// 잘라낸 나무들의 합이 최소한으로 가져야 하는 나무 길이보다 작은 경우
			else
				end=mid-1;
		}
		System.out.println(end);
	}
}