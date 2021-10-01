package BaekJoon;

import java.util.*;

public class P_10025_게으른백곰 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
	
		int arr[] = new int[1000001];
	
		for(int i=0; i<N; i++) {
			int W = sc.nextInt();
			int P = sc.nextInt();
			arr[P] = W;
		}
		
		int sum = 0, max = 0;
		int window = 1 +(2*K);
	
		for(int i=0; i<=1000000; i++) {
			// 초반 k-1범위 전까지는 sum을 max랑 비교하면안됨.
			if(i >= window) {
				sum -= arr[i-window];
			}
			sum += arr[i];
			if(sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}