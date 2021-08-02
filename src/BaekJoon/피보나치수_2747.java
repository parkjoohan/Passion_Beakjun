package BaekJoon;

import java.util.*;

public class 피보나치수_2747 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		System.out.println(fibo(N));
//			
//	}
//	
//	public static long fibo(int n) {
//		if(n<=1)
//			return n;
//		else
//			return fibo(n-1)+fibo(n-2);
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = 0;
		int b = 1;
		int c=a+b;
		
		if(N==1)
			System.out.println(1);
		else {
			for(int i=1; i<N; i++) {
				c=a+b;
				a=b;
				b=c;
			}
			System.out.println(c);
		}	
	}
}
