package BaekJoon;

import java.util.*;
public class 회전하는큐_1021 {
	public static void main(String[] args) {
		
		// 1번 연산 : pollFirst();
		// 2번 연산 : pollFirst -> pushLast()
		// 3번 연산 : pollLast() -> pushFirst()
		Scanner sc = new Scanner(System.in); 
		LinkedList<Integer> list = new LinkedList<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 0;
		
		for(int i=1; i<=N; i++)
			list.add(i);
	
		for(int i=1; i<=M; i++) {
			int num = sc.nextInt();	
			// 덱에서 뽑으려나 숫자 위치 찾기
			int index = list.indexOf(num);
			int middle = list.size() / 2;
			
			if(index<=middle) {
				while(num!=list.getFirst()) {
					list.add(list.pollFirst());
					cnt++;
				}
			}
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