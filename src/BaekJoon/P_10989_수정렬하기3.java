package BaekJoon;

import java.util.*;

public class P_10989_수정렬하기3 {

	public static void main(String[] args) extends Ex{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[10];

		for(int i=0; i<T; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);	
		
		for(int k=0; k<T; k++) {
			System.out.println(arr[k]);
		}	
	}
}
