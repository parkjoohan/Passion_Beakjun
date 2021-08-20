package BaekJoon;

import java.util.*;

public class P_1934_최소공배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int c = gcd(a, b);
			System.out.println(a*b/c);
		}
	}
	
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
}