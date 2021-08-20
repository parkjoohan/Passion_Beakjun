package BaekJoon;

import java.util.*;

public class P_9655_돌게임1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();

		if((N%2==1))
			System.out.println("SK");
		else
			System.out.println("CY");
	}
}
