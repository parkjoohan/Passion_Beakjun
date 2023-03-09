package BaekJun_Study;

import java.util.*;

public class 나무자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int start = 0, end = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			
			if(end < arr[i])
				end = arr[i];
		}
		
		while(start < end) {
			int mid = (start+end)/2;
			long sum = 0;
			
			for(int num : arr) {
				if(num - mid > 0)
					sum += (num - mid);
			}
			
			if(sum < M)
				end = mid;
			else
				start = mid + 1;
		}
		
		System.out.println(start-1);
	}
}