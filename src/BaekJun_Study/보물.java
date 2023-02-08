package BaekJun_Study;

import java.util.*;

public class 보물 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		Integer[] arr2 = new Integer[N];
		int answer = 0;
		
		for(int i=0; i<N; i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);
		
		for(int i=0; i<N; i++)
			arr2[i]=sc.nextInt();
		
		Arrays.sort(arr2, Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			answer += (arr[i] * arr2[i]);
		}
		
		System.out.println(answer);
	}
}