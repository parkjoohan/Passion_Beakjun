package BaekJoon;

import java.util.*;

public class P_1158_요세푸스문제 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 리스트에 수 입력
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		System.out.print("<");

		// 비어질 떄까지 반복
		while(q.size()!=1) {
			for(int j=0; j<K-1; j++)
				q.offer(q.poll());
			System.out.print(q.poll()+", ");
		}	
		System.out.println(q.poll()+">");
	}
}




/*import java.util.*;

public class 요세푸스문제_1158 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 리스트에 수 입력
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		System.out.print("<");
		
		int cnt=0;
		// 비어질 떄까지 반복
		while(!q.isEmpty()) {
			cnt++;
			if(cnt%K==0) {
				System.out.print(q.poll()+", ");
				if(q.size()==1)
					System.out.print(q.poll());
			}	
			else
				q.offer(q.poll());
		}
		System.out.print(">");
	}
}*/