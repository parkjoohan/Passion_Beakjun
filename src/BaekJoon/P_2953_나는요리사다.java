package BaekJoon;

import java.util.*;

public class P_2953_나는요리사다 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6];
		int max=Integer.MIN_VALUE;
		int res=0;
		
		for (int i = 1; i <= 5; i++) {
			int sum=0;
			for (int j = 1; j <= 4; j++) {
				int num = sc.nextInt();
				
				sum+=num;
				arr[i]=sum;
			}
		}
		
		for (int i = 1; i <= 5; i++) {
			if(max<arr[i]) {
				max=arr[i];
				res=i;
			}
		}
		System.out.println(res+" "+max);
	}
}