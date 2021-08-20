package BaekJoon;

import java.util.*;

public class P_1924_이천칠년 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int day = sc.nextInt();
		int[] mon_days = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

		int sum = day;
		
		for(int i=0; i<month-1; i++) {
			sum += mon_days[i];
		}
		System.out.println(days[sum%7]);
	}
}
