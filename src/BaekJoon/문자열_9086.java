package BaekJoon;

import java.util.*;

public class 문자열_9086 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			String a = sc.next();
			System.out.println(a.charAt(0)+""+a.charAt(a.length()-1));
		}
	}
}
