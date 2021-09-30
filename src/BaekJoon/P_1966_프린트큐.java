package BaekJoon;

import java.util.*;

public class P_1966_프린트큐 {

	static int N, M, cnt;
	static int[] arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			LinkedList<int[]> queue = new LinkedList<>();
			N = sc.nextInt();	// 문서 개수
			M = sc.nextInt();	// 궁금한 문서의 Queue 내 위치
			cnt=0;
						
			for (int i = 0; i < N; i++) {
				queue.add(new int[] {i,sc.nextInt()});
			}
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				
			}
		}
	}

}
