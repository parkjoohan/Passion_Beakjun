package BaekJoon;

import java.io.*;
import java.util.*;

public class AC_5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int TC = Integer.parseInt(br.readLine());
		
tc:		for (int i = 0; i < TC; i++) {
			// 기능 선택 (RDD)
			String func = br.readLine(); 
			boolean isReverse = false;
			// 배열에 들어있는 N의 개수 (4)
			int size = Integer.parseInt(br.readLine()); 
			Deque<Integer> deque = new LinkedList<>();
			// [] 형태로 들어있는 수 ([1,2,3,4])
			String temp = br.readLine().replace("[", "").replace("]", "").replace(",", " ");
			StringTokenizer st = new StringTokenizer(temp);
			
			// 덱 안에 추가 ([1,2,3,4])
			for (int j = 0; j < size; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			for (char c : func.toCharArray()) {
				// R은 뒤집기 기능
				if (c == 'R') {
					isReverse = !isReverse;
				} 
				// D 기능(버리기)
				else { 
					// 덱이 비어있으면 error 출력 후 tc 앞부분으로 리턴
					if (deque.isEmpty()) {
						sb.append("error").append("\n");
						continue tc;
					}
					// 역순일 때는 뒤부터 버리기
					if (isReverse) {
						deque.removeLast();
					} 
					// 정방향일 때는 앞부터 버리기
					else {
						deque.removeFirst();
					}
				}
			}
			
			sb.append("[");
			while (!deque.isEmpty()) {
				// 역순일 때
				if (isReverse) {
					// 1개만 있을 때
					if(size==1) {
						sb.append(deque.removeLast());
						continue;
					}
					sb.append(deque.removeLast()).append(",");
				} 
				// 정방향일 때
				else {
					sb.append(deque.removeFirst()).append(",");
				}
			}
			// 마지막 , 지우기
			if(size > 1 ) {
				sb.deleteCharAt(sb.lastIndexOf(","));	
			}			
			sb.append("]").append("\n");			
		}
		System.out.print(sb);
	}
}