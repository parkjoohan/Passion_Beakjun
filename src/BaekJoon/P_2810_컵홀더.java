package BaekJoon;

import java.util.*;

public class P_2810_컵홀더 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		int cnt=1;		// 마지막에 무조건 컵이 있으므로 1을 잡고 시작
		
		for (int i = 0; i < N; i++) {
			char ch = str.charAt(i);
			
			if(ch=='S')
				cnt++;
			
			else if(ch=='L') {
				i++;
				cnt++;
			}			
		}
		if(cnt>N)
			System.out.println(N);
		else
			System.out.println(cnt);
	}
}