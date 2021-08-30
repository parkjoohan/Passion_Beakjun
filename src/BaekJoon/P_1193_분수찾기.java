package BaekJoon;

import java.util.*;

public class P_1193_분수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i;
		
		for (i = 0; i < num; i++) {
			num = num-i;
		}
		
		if(i%2==1)
			System.out.printf("%d/%d", i-(num-1), num);
		else
			System.out.printf("%d/%d", num, i-(num-1));
	}
}