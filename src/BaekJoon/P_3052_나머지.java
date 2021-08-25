package BaekJoon;

import java.util.*;

public class P_3052_나머지 {
	
	static int cnt;
	static int[] num = new int[10];
	static int[] rest = new int[42];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++)
			num[i] = sc.nextInt();
		
		for (int i = 0; i < 10; i++) 
			rest[num[i] % 42] = 1;
			
		for (int i = 0; i < 42; i++) {
			if(rest[i]==1)
				cnt++;
		}
		System.out.println(cnt);
	}
}