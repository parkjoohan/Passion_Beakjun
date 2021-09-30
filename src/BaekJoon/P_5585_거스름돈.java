package BaekJoon;

import java.util.*;

public class P_5585_거스름돈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = {500,100,50,10,5,1};
		int range = 1000-N;
		int cnt=0;

		for (int i = 0; i < 6; i++) {
			if(range/arr[i]>0) {
				cnt+=range/arr[i];
				range=range%arr[i];
			}
		}
		System.out.println(cnt);
	}
}