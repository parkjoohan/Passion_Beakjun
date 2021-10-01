package BaekJoon;

import java.util.*;

public class P_1259_팰린드롬수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.next();
			
			if(str.equals("0"))		break;
			
			String[] arr = new String[str.length()];
			String[] arr2 = new String[str.length()];
			
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.substring(i,i+1);
			}
			
			for (int i = 0; i < str.length(); i++) {
				arr2[i] = arr[str.length()-1-i];
			}
			
			int cnt=0;
			for (int i = 0; i < str.length(); i++) {
				if(arr[i].equals(arr2[i]))	cnt++;
			}
			
			if(cnt==str.length())	System.out.println("yes");
			else	System.out.println("no");
		}
	}
}