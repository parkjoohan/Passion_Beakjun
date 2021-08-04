package BaekJoon;

import java.util.*;

public class 검증수_2475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr =new int[6];
		int sum=0;
		int result=0;
		
		for(int i=1; i<=5; i++) {
			arr[i] = sc.nextInt();
			
			sum += (int)Math.pow(arr[i], 2);
			result = sum%10;
		}
		System.out.println(result);
	}
}