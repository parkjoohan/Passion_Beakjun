package BaekJun_Study;

import java.util.*;

public class ZOCA4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int height = H%(N+1) == 0 ? H/(N+1) : H/(N+1)+1;
		int width = W%(M+1) == 0 ? W/(M+1) : W/(M+1)+1;
		
		System.out.println(height * width);
	}

}
