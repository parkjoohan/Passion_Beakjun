package BaekJoon;

import java.util.*;

public class P_17413_단어뒤집기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<Character>();
		StringBuilder result = new StringBuilder();
		String str = sc.nextLine();
		int check = 0; 
		
		for(char ch : str.toCharArray()) {
			if(ch == '<') {
				check+=1; // 태그 안을 의미.
				// 태그 전까지의 문자 뒤집기.
				while(!st.isEmpty()) {
					result.append(st.pop());
				}
				result.append("<");
			} else if(ch == '>') {
				check-=1; // 태그 탈출.
				result.append(">");
			} else if(ch == ' ') {
				while(!st.isEmpty())
					result.append(st.pop());
				result.append(" ");
			} else {
				if(check == 0) // 태그 밖
					st.push(ch);
				else // 태그 안.
					result.append(ch);
			}
		}
		while(!st.isEmpty())
			result.append(st.pop());
		
		System.out.println(result);
		sc.close();
		return;
	}
}