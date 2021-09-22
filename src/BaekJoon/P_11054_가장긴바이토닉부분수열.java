package BaekJoon;

import java.util.*;

public class P_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr= new int[N];
		int[] LIS = new int[N];
		int[] LIS2 = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			LIS[i]=1;
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && LIS[i]<LIS[j]+1)
					LIS[i]=LIS[j]+1;
			}
			
		}
		
		for (int i = N-1; i >= 0; i--) {
			LIS2[i]=1;
			for (int j = N-1; j > i; j--) {
				if(arr[j]<arr[i] && LIS2[i]<LIS2[j]+1)
					LIS2[i]=LIS2[j]+1;
			}
			
		}
		int max=0;
		for (int i = 0; i < N; i++) {
			 if(max<LIS[i]+LIS2[i])	max=LIS[i]+LIS2[i];
		}
		System.out.println(max-1);
	}
}