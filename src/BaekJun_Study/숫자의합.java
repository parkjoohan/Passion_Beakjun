package BaekJun_Study;

import java.util.*;

public class 숫자의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		char[] arr = str.toCharArray();
		int sum = 0;;
		
		for(int i=0; i<arr.length; i++)
			sum += arr[i] - '0';
		
		System.out.println(sum);
	}
}