package BaekJoon;

import java.util.*;

public class P_5086_배수와약수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a==0 && b==0)	break;
			
			if(a<b && b%a==0)	System.out.println("factor");
			else if(a>b && a%b==0)	System.out.println("multiple");
			else	System.out.println("neither");
		}
	}
}