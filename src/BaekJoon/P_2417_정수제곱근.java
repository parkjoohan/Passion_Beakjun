package BaekJoon;

import java.util.*;

public class P_2417_정수제곱근 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		System.out.println(func(N));
	}
	public static long func(long N) {
		if((long)Math.sqrt(N)>=N)
			return (long)Math.sqrt(N);
		else
			return (long)Math.sqrt(N)+1;
	}
}