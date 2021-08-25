package BaekJoon;

import java.util.*;

public class P_2851_슈퍼마리오 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mush = new int[10];
		int result=0;
		
		for (int i = 0; i < 10; i++) 
			mush[i] = sc.nextInt();
			
		for (int i = 0; i < 10; i++) {
			result += mush[i];
			
			if(Math.abs((result - mush[i])-100) < result-100) {
				result = result - mush[i];
				break;
			}		
		}
		System.out.println(result);
	}
}