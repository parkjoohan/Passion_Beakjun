package BaekJoon;

import java.io.*;
import java.util.*;

public class P_3985_롤케이크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[L+1];
		int result1=0, result2=0;
		int max1=0, max2=0;
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			if(K-P > max1) {
				max1 = K - P;
				result1 = i;
			}
			
			for(int j=P; j<=K; j++) {
				if(arr[j]==0) {
					arr[j] = i;
					sum++;
				} 
			}
			
			if(sum > max2) {
				result2 = i;
				max2 = sum;
			}
		}
		System.out.println(result1);
		System.out.println(result2);
	}
}