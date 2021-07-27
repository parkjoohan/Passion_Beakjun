package BaekJoon;

import java.util.*;

public class 열개씩끊어출력하기_11721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.next();

		for(int i=0; i<T.length(); i++) {
			System.out.print(T.charAt(i));
			if(i%10 == 9)
				System.out.println();
		}
	}
}
