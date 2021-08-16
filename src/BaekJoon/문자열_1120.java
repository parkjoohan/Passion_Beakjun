package BaekJoon;

import java.util.*;

public class 문자열_1120 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		int result = a.length();
		
		for(int i=0; i<b.length() - a.length()+1; i++) {
			int cnt=0;
			
			for(int j=0; j<a.length(); j++) {
				if(a.charAt(j) != b.charAt(i+j))
					cnt++;
			}
			result = Math.min(result, cnt);
		}
		System.out.println(result);
	}
}
