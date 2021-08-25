package BaekJoon;

import java.util.*;

public class P_2941_크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=","z="};
		
		String a = sc.nextLine();
		
		for(int i=0; i<str.length; i++) {
			if(a.contains(str[i]))
				a = a.replace(str[i], " ");
		}
		System.out.println(a.length());
	}
}