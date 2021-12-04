package BaekJoon;

import java.io.*;
import java.util.*;

public class P_10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if(input.contains("push")) {
				int input2 = Integer.parseInt(st.nextToken());
		    	stack.push(input2);
		    }else if(input.equals("pop")){
		    	System.out.println(stack.isEmpty()?-1:stack.pop());
		    }else if(input.equals("size")) {
		    	System.out.println(stack.size());
		    }else if(input.equals("empty")) {
		    	System.out.println(stack.isEmpty()?1:0);
		    }else if(input.equals("top")) {
		  		System.out.println(stack.isEmpty()?-1:stack.peek());
		    }
		}
	}
}