package BaekJoon;

import java.util.*;

public class 크로아티아알파벳_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] arr = new String[s.length()];
		String[] arr2 = {"c=", "c-", "dz=", ""};
		
		for(int i=0; i<s.length(); i++) {
			arr[i] = s.substring(2*i,2*i+2);
		}
		

	}

}
