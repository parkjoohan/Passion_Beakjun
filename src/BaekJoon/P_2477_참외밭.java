package BaekJoon;

import java.util.*;

public class P_2477_참외밭 {
	
	static int K, area;
	static int[] side = new int[6];
	static int[] length = new int[6];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int sum=0, maxX=0, maxY=0;
		
		for (int i = 0; i < 6; i++) {
			int s = sc.nextInt();
			int l = sc.nextInt();
			side[i]=s;
			length[i]=l;
		}
		
		for (int i = 0; i < 6; i++) {
			sum += length[i%6] * length[(i+1)%6];
			
			if(side[i]>2)
				maxY = Math.max(maxY, length[i]);
			else
				maxX = Math.max(maxX,  length[i]);
		}
		area = (sum-(2*maxX*maxY));
		System.out.println(area*K);
	}
}