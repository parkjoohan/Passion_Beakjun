package BaekJoon;

import java.util.*;
public class P_1021_회전하는큐 {
	public static void main(String[] args) {
		
		// 1번 연산 : pollFirst();
		// 2번 연산 : pollFirst -> pushLast()
		// 3번 연산 : pollLast() -> pushFirst()
		Scanner sc = new Scanner(System.in); 
		LinkedList<Integer> list = new LinkedList<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 0;
		
		// 큐에 입력
		for(int i=1; i<=N; i++)
			list.add(i);
	
		for(int i=1; i<=M; i++) {
			int num = sc.nextInt();	
			// 큐에서 뽑으려나 숫자 위치 찾기
			int index = list.indexOf(num);
			int middle = list.size() / 2;
			
			// 찾을 숫자가 반보다 작을 때
			if(index<=middle) {
				while(num!=list.getFirst()) {
					list.add(list.pollFirst());
					cnt++;
				}
			}
			// 클 때
			else {
				while(num!=list.getFirst()) {
					list.addFirst(list.pollLast());
					cnt++;
				}
			}
			list.remove();
		}
		System.out.println(cnt);
	}
}