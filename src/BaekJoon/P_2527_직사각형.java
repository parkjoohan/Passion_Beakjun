package BaekJoon;

import java.util.*;

public class P_2527_직사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();	// 첫번째 도형 왼쪽 하단 좌표
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();	// 첫번째 도형 오른쪽 상단 좌표
			int y2 = sc.nextInt();
			int x3 = sc.nextInt();	// 두번째 도형 왼쪽 하단 좌표
			int y3 = sc.nextInt();
			int x4 = sc.nextInt();	// 두번째 도형 오른쪽 상단 좌표
			int y4 = sc.nextInt();
			
			// 선분
			if((x2==x3 && y2!=y3) || (x1==x4 && y2!=y3) 
					|| (x2!=x3 && y1==y4) || (x1!=x4 && y1==y4))
				System.out.println("b");		
			// 점
			else if((x2==x3 && y2==y3) || (x2==x3 && y1==y4) 
				|| (x1==x4 && y2==y3) || (x1==x4 && y1==y4))
				System.out.println("c");
			
			// 겹치지 않을 때
			else if((x2<x3) || (x4<x1) || (y2<y3) || (y4<y1))
				System.out.println("d");
			// 직사각형 
			else 
				System.out.println("a");
		}
	}
}