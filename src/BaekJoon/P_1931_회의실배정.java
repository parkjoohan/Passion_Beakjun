package BaekJoon;

import java.util.*;

public class P_1931_회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int cnt=0;
		int endTime=0;
		
		for (int i = 0; i < N; i++) {
			if(arr[i][0]>=endTime) {
				endTime=arr[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}