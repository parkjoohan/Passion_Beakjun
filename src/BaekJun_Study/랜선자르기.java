package BaekJun_Study;

import java.util.*;

public class 랜선자르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<K; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		long max = arr[arr.length-1];
		long min = 1;
		long mid = 0;
		
		while(min <= max) {
			mid = (max + min) / 2;
			long cnt = 0;
			
			for(int i=0; i<arr.length; i++) {
				cnt += (arr[i]/mid);
			}
			
			if(cnt>=N)
				min = mid + 1;
			else if(cnt<N)
				max = mid - 1;
		}
		
		System.out.println(max);
	}
}