package BaekJoon;

import java.util.Scanner;

public class P_9656_돌게임2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();

		if((N%2==0))
			System.out.println("SK");
		else
			System.out.println("CY");
	}
}