package BaekJoon;

import java.util.*;

public class P_2525_오븐시계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int hour = sc.nextInt(); 
		int minute = sc.nextInt() + sc.nextInt(); 
		
		while (minute > 59) { 
			hour++; 
			minute -= 60; 
		} 
		
		while (hour > 23) 
			hour -= 24; 
		
		System.out.printf("%d %d", hour, minute);
	}
}