package BaekJoon;

import java.util.*;

public class P_1712_손익분기점 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(B>=C)
			System.out.println("-1");
		else 
			System.out.println(A/(C-B)+1);
	}
}

// Ci > A + Bi
// i > A / (C - B)