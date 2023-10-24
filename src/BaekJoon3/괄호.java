package BaekJoon3;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			Stack<Character> stack = new Stack<>();
			String str = sc.next();
			boolean VFS = true;
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == '(') {
					stack.push('(');
				} else if(str.charAt(j)==')') {
					if(!stack.isEmpty())
						stack.pop();
					else {
						VFS = false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty() || VFS==false)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}