package BaekJoon;

import java.util.*;

public class P_2512_예산 {

	static int result=0;;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int max = sc.nextInt();
		
		int left=0;
		int right=arr[N-1];
		
		while(left<=right) {
			int mid=(left+right)/2;
			int sum=0;
			
			for(int money:arr) {
				// 세금을 낼 수 있는 지역
				if(money>=mid)
					sum+=mid;
				// 세금을 못 내는 지역
				else
					sum+=money;
			}
			
			// 내야하는 세금보다 많은 경우 세금을 줄인다.
			if(sum>max)
				right=mid-1;
			// 내야하는 세금보다 적은 경우 세금을 높인다.
			else {
				left=mid+1;
				result = Math.max(result, mid);
			}
		}
		System.out.println(result);
	}
}