package BaekJun_Study;

import java.util.*;

public class 평균 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		long max = 0;
		long sum = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max)	max = arr[i];
			sum += arr[i];
		}
		
		System.out.println(sum*100.0/max/N);
	}
}