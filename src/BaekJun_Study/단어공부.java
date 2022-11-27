package BaekJun_Study;

import java.util.*;

public class 단어공부 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		int[] count = new int[26];
		int max = 0;
		char answer = '?';
		
		for(int i=0; i<str.length(); i++) {
			int num = str.charAt(i)-'A';
			count[num]++;
		}
		
		for(int i=0; i<count.length; i++) {
			if(max == count[i]) {
				answer = '?';
			} else if(max<count[i]) {
				max = count[i];
				answer = (char)(i+'A');
			}
		}
		
		System.out.println(answer);
	}
}