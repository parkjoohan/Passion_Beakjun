package BaekJoon;

import java.util.*;

public class 카드2_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		while(queue.size()>1) {
			queue.poll();		// 첫번째 버리기
			// 버리고 난 뒤 첫번째 수 다시 아래러 입력
			queue.offer(queue.poll());		
		}
		
		System.out.println(queue.poll());		// 마지막 출력
	}
}