package BaekJoon;

import java.util.*;
public class 시험감독_13458 {

	public static void main(String[] args) {

/*		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		for(int j=0; j<N; j++) {
			if(arr[j] <= B)
				arr[j]=1;
			else if(arr[j] > B) {
				arr[j] = arr[j]-B;
				if(arr[j]<=C) {
					arr[j]=2;
				}
				else if(arr[j]>C){
					arr[j]=arr[j]/C + 2;
				}
			}
			sum += arr[j];
		}
		System.out.println(sum);*/
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum = 0; 
		int[] a = new int[n]; 
		
		for(int i=0; i<n; i++) 
			a[i] = sc.nextInt();
		
		int b = sc.nextInt(); 
		int c = sc.nextInt(); 
		
		for(int i=0; i<n; i++) {
			a[i]-=b;
			sum++;
			
			if(a[i]<=0) 
				continue;
			else {
				sum += a[i]/c;
				if(a[i]%c > 0) 
					sum++;
			}
		}
		System.out.println(sum);
	}
		
}

