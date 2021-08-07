package BaekJoon;

import java.io.*;
import java.util.*;

public class AC_5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		
tc:		for (int i = 0; i < TC; i++) {
			Deque<Integer> deque = new LinkedList<>();
			boolean isReverse = false;
			
			// 기능 입력
			String func = br.readLine(); 
			// 수열의 수 개수 입력
			int num = Integer.parseInt(br.readLine()); 
			// 배열에 들어가는 수 
			String temp = br.readLine().replace("[", "").replace("]", "").replace(",", " ");
			StringTokenizer st = new StringTokenizer(temp);
			for (int j = 0; j < num; j++) { 
				deque.add(Integer.parseInt(st.nextToken()));
			}

			// 기능 구현
			for (char c : func.toCharArray()) {
				// R 가능
				if (c == 'R') {
					isReverse = !isReverse;
				} 
				// D 기능
				else if (c == 'D'){
					if (deque.isEmpty()) {
						sb.append("error").append("\n");
						continue tc;
					}
					if (isReverse) {// 역순이면
						deque.removeLast();
					}
					else {
						deque.removeFirst();
					}
				}

			}
			sb.append("[");
			while (!deque.isEmpty()) {
				if (isReverse) {
					if(num==1) {
						sb.append(deque.removeLast());
						continue;
					}
					sb.append(deque.removeLast()).append(",");
				} else {
					sb.append(deque.removeFirst()).append(",");
				}
			}
			if(num > 1 ) {
				sb.deleteCharAt(sb.lastIndexOf(","));	
			}			
			sb.append("]").append("\n");		
		}
		System.out.print(sb);
	}
}