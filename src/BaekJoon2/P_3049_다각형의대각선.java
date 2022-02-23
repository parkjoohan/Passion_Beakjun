package BaekJoon2;

import java.util.*;

public class P_3049_다각형의대각선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println((N*(N-1)*(N-2)*(N-3)) / 24);
	}
}