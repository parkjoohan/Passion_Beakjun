package BaekJoon;

import java.util.*;

public class P_10773_제로 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if(num==0)
				stack.pop();
			else
				stack.push(num);
		}
		
		int sum=0;
		
		for(int i : stack)
			sum += i;
		
		System.out.println(sum);
	}
}