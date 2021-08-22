package BaekJoon;

import java.util.*;

public class P_1436_영화감독숌 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
 
		int num = 666;
		int cnt = 1;
        
		while(cnt != N) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
	}
}