package BaekJoon;

import java.util.*;

public class P_2292_벌집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int layer=1, num=0, total=1;
		
		while(true) {
			if(N <= total)
				break;
			else {
				num += 6;
				total += num;
				layer++;
			}
		}
		System.out.println(layer);
	}
}