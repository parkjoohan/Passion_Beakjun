package BaekJun_Study;

import java.util.*;

public class 등수구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int newScore = sc.nextInt();
		int P = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		if(N==P && arr[N-1]>=newScore) {
			System.out.println(-1);
			System.exit(0);
		}
		
		int rank = 1;
		for(int i=0; i<N; i++) {
			if(arr[i]>newScore)
				rank++;
			else 
				break;
		}
		
		System.out.println(rank);
	}
}