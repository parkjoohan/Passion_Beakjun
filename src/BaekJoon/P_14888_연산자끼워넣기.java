package BaekJoon;

import java.util.*;

public class P_14888_연산자끼워넣기 {
	
	static int T;
	static int[] num;
	static int[] operator; 
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
						
		Scanner sc = new Scanner(System.in);
		T =sc.nextInt();
		
		num = new int[T];
		for (int i = 0; i < T; i++) {
			num[i] = sc.nextInt();
		}
		
		operator = new int[4];
		for (int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}
		
		dfs(num[0], 1);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	static void dfs(int number, int cnt) {
		if(cnt == T) {
			MAX = Math.max(MAX, number);
			MIN = Math.min(MIN, number);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(operator[i]>0) {
				operator[i]--;
				
				if(i==0)
					dfs(number + num[cnt], cnt+1);
				else if(i==1)
					dfs(number - num[cnt], cnt+1);
				else if(i==2)
					dfs(number * num[cnt], cnt+1);
				else if(i==3)
					dfs(number / num[cnt], cnt+1);
				
				operator[i]++;
			}
		}
	}
}
