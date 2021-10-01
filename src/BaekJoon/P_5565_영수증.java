package BaekJoon;

import java.util.*;

public class P_5565_영수증 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int sum2=0;
		int res=0;
		
		for (int i = 0; i < 9; i++) {
			int num = sc.nextInt();
			sum2+=num;
		}
		res = sum-sum2;
		System.out.println(res);
	}
}