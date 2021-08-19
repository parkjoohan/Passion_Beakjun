package BaekJoon;

import java.util.*;

public class N_Queen_9663 {

	static int N, cnt;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		cnt=0;

		NQueen(1);
		System.out.println(cnt);
	}
	
	static void NQueen(int rowNo) {
		if(rowNo > N) {
			cnt++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			arr[rowNo] = i;
			if(isAvailable(rowNo)) {
				NQueen(rowNo + 1);
			}
		}
	}
	
	static boolean isAvailable(int rowNo) {
		
		for (int k = 1; k < rowNo; k++) {	// k : 이전 퀸
			if(arr[rowNo] == arr[k] || Math.abs(arr[rowNo] - arr[k]) == Math.abs(rowNo-k))
				return false;
		}
		return true;
	}
}
