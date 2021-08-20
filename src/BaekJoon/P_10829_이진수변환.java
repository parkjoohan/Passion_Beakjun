package BaekJoon;

import java.util.*;

public class P_10829_이진수변환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		
		func(N);

	}

	static long func(long num) {
		long tmp = 0;
		
		if(num>-2) {
			tmp = num%2;
			System.out.print(tmp);
			return func(num/2);
		}
		else {
			tmp = num%2;
			System.out.print(tmp);
			return num;
		}
	}
}
