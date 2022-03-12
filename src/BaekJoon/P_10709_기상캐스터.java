package BaekJoon;

import java.util.*;

public class P_10709_기상캐스터 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int cnt=0;
		
		for (int i = 0; i < H; i++) {
			String str = sc.next();
			for (int j = 0; j < W; j++) {
				if(str.charAt(j)=='.' && cnt==0)
					System.out.print(-1+" ");
				else if(str.charAt(j)=='.' && cnt!=0) {
					System.out.print(cnt+" ");
					cnt++;
				}
				else if(str.charAt(j)=='c') {
					System.out.print(0+" ");
					cnt=1;
				}
			}
			System.out.println();
			
			cnt=0;
		}
	}
}