package BaekJoon;

import java.util.*;

public class P_2902_KMP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		for (int i = 0; i < str.split("-").length; i++) {
			String str2 = str.split("-")[i];
			System.out.print(str2.charAt(0));
		}
	}
}