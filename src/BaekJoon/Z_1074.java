package BaekJoon;

import java.util.*;

/*public class Z_1074 {
	
	static int N, r, c, cnt;
	static int[] dx = {0,1,0,1};
	static int[] dy = {0,0,1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int)Math.pow(2, sc.nextInt());	// N : 배열 크기
		r = sc.nextInt();	// r : 행
		c = sc.nextInt();	// c : 열

		func(N,0,0);
	}
	
	static void func(int num, int row, int col) {
		if(num == 2) {
			for(int i=0; i<4; i++) {
				int r2 = row + dy[i];
				int c2 = col + dx[i];
				if(r2 == r && c2 == c) {
					System.out.println(cnt);
					System.exit(0);
				}
				cnt++;
			}
			return;
		}
		func(num/2, row, col);
		func(num/2, row, col+num/2);	// 우측
		func(num/2, row+num/2, col);	// 좌측
		func(num/2, row+num/2, col+num/2);	// 대각선하단
	}

}*/

public class Z_1074 {
	static int N, r, c;
	static int size;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.next().split(" ");
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		size = (int)Math.pow(2, N);
		
		int result = func(0,0,size);
		System.out.println(result);
	}
	
	static void func(int nr, int nc, int size) {
		if(size==1)
			return 0;
		if()
	}
}