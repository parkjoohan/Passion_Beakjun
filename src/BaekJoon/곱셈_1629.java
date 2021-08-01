package BaekJoon;

import java.util.*;

public class 곱셈_1629 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		long mul=0;
		long result = 0;
		
		mul = (long) Math.pow(A, B);
		result = mul % C;
		
		System.out.println(result);
	}
}