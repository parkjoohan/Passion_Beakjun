package BaekJoon;

import java.util.*;

public class P_8958_OX퀴즈 {
	 public static void main(String args[]) {

		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt(); 
		 
		 for(int i = 0; i < N; i++) {
			 String str = sc.next();
			 int sum = 0, cnt = 0;
			 
			 for(int j = 0; j < str.length(); j++) {
				 if(str.charAt(j) == 'O') { 
					 cnt++;
					 sum += cnt;
				 }
				 else if(str.charAt(j) == 'X') {
					 cnt = 0; 
				 }
			 }
			 System.out.println(sum);
		 }
	 }
}