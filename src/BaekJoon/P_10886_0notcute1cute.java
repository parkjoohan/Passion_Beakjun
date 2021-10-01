package BaekJoon;

import java.util.*;

public class P_10886_0notcute1cute {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt=0, cnt2=0;
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			if(N==1)	cnt++;
			else if(N==0)	cnt2++;
		}
		
		if(cnt>cnt2)	System.out.println("Junhee is cute!");
		else	System.out.println("Junhee is not cute!");
	}
}