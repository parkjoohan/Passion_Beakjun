package BaekJoon;

import java.util.*;

public class P_1065_한수 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		System.out.println(dfs(N));
	}
	
	public static int dfs(int x) {
		int cnt=0;
		if(x<100)
			return x;
		else {
			cnt=99;
			if(x==1000)
				x=999;
		}
		
		for (int i = 100; i <= x; i++) {
			int a = i/100;
			int b = (i/10)%10;
			int c = i%10;
			
			if((a-b)==(b-c))
				cnt++;
		}
		return cnt;
	}
}