package BaekJun_Study;

import java.util.*;

public class 돌게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String answer = N%2==1 ? "SK" : "CY"; 
		
		System.out.println(answer);
	}
}