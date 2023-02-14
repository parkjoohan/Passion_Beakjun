package BaekJun_Study;

import java.util.*;

public class 숫자카드2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		int M = sc.nextInt();
		int[] arr2 = new int[M];
		int[] answer = new int[M];
		for(int i=0; i<M; i++) {
			arr2[i] = sc.nextInt();
			answer[i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(arr2[i] == arr[j])
					answer[i]++;
			}
		}
		
		for(int i=0; i<answer.length; i++)
			System.out.print(answer[i] + " ");
	}
}