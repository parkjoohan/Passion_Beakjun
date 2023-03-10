package BaekJun_Study;

import java.util.*;

public class 예산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		long M = sc.nextInt();
		long answer = 0;
		
		Arrays.sort(arr);
		long min = 0;
		long max = arr[arr.length-1];
		long mid = 0;
		
		while(min <= max) {
			mid = (max + min) / 2;
			long sum = 0;
			
			for(int money : arr) {
				if(money >= mid)	sum += mid;
				else	sum += money;
			}
			
			if(sum > M)
				max = mid - 1;
			else {
				min = mid + 1;
				answer = Math.max(answer, mid);
			}
				
		}
		
		System.out.println(answer);
	}
}