package BaekJoon;

import java.util.*;

public class P_10872_팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		int result=1;
		
		for(int i=1; i<=T; i++) {
			result *= i;
		}
		if(T==0) 
			System.out.println("1");
		else		
			System.out.println(result);
	}
}
