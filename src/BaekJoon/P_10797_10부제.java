package BaekJoon;

import java.util.*;

public class P_10797_10부제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt=0;
		
		for (int i = 0; i < 5; i++) {
			int num = sc.nextInt();
			if(N==num)	cnt++;
		}
		System.out.println(cnt);
	}
}