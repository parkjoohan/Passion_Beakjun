package BaekJoon;

import java.util.*;

public class 창영이의일기장_2954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.replaceAll("apa", "a").replaceAll("epe", "e").replaceAll("ipi", "i")
				.replaceAll("opo", "o").replaceAll("upu", "u");
		System.out.println(str);
	}
}