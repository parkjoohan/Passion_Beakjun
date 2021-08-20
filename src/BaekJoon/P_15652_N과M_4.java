package BaekJoon;

// 중복조합
import java.util.Scanner;

public class P_15652_N과M_4 {
	static int N, M;
	public static int[] arr;
	public static boolean[] check;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();
 
		arr = new int[M];
		check = new boolean[N];
		Result(1, 0);
 
	}
 
	public static void Result(int cnt, int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) { 
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
 
		for (int i = cnt; i <= N; i++) {
				arr[idx] = i;
				Result(i, idx + 1);	
		}
	}
}