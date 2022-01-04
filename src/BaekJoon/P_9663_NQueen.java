package BaekJoon;

import java.util.*;

/*public class P_9663_NQueen {

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
}*/

public class P_9663_NQueen {

	public static int N;
	public static int[] arr;
	public static int cnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		nQueen(0);
		System.out.println(cnt);
	}
	
	public static void nQueen(int depth) {
		// 모든 원소 다 채우면 cnt 증가, return
		if(depth==N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[depth]=i;
			
			// 놓을 수 있는 위치라면 재귀호출
			if(possibility(depth)) {
				nQueen(depth+1);
			}
		}
	}
	
	public static boolean possibility(int col) {
		for (int i = 0; i < col; i++) {
			// 해당 열의 행과 i열의 행이 일치할 때 (같은 행에 존재하는 경우)
			if(arr[col]==arr[i])	
				return false;
			
			// 대각선에 놓여있는 경우 (열의 차와 행의 차가 같은 경우, 대각선에 위치한 경우)
			else if(Math.abs(col-i)== Math.abs(arr[col]-arr[i]))
				return false;
		}
		return true;
	}
}