package BaekJoon;

import java.util.*;

public class P_2609_최대공약수최소공배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int c = gcd(a,b);
		
		System.out.println(c); // 최대공약수
		System.out.println(a*b/c); //최소공배수
	}
	
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
}