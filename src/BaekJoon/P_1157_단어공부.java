package BaekJoon;

import java.util.*;

public class P_1157_단어공부 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		int max = -1;
		char ch = '?';
		String str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			if('A'<=str.charAt(i) && str.charAt(i)<='Z')
				arr[str.charAt(i) - 'A']++;
			else
				arr[str.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			if(arr[i]>max) {
				max=arr[i];
				ch=(char)(i+65);
			}
			else if(arr[i]==max)
				ch='?';
		}
		System.out.println(ch);
	}
}