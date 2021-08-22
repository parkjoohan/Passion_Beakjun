package BaekJoon;

import java.util.*;

public class P_10819_차이를최대로 {
	
	static int N, MAX;
	static int[] arr;
	static int[] arr2;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		arr2 = new int[N];
		check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		func(0);
		System.out.println(MAX);
	}
	
	static void func(int cnt) {
		if(cnt == N) {
			int sum=0;
			
			for(int i=0; i<N-1; i++) {
				sum += Math.abs(arr2[i]-arr2[i+1]);
			}
			MAX = Math.max(MAX, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!check[i]) {
				arr2[cnt] = arr[i];
				check[i] = true;
				func(cnt+1);
				check[i] = false;
			}
		}
	}
}