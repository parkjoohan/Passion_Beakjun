package BaekJoon;

import java.util.*;

public class 모든순열_10974 {

	static int N;
	static int numbers[];
	static boolean isSelected[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		numbers = new int[N];
		isSelected = new boolean[N];
		
		Permutation(0);
	}
	
	static void Permutation(int cnt) {
		if(cnt==N) {
			for(int i=0; i<N; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return ;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i])
				continue;
			numbers[cnt] = i+1;
			isSelected[i]= true;
			Permutation(cnt+1);
			isSelected[i]= false;
		}
	}
}