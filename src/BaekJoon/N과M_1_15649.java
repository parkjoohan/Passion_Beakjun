package BaekJoon;

/*import java.util.*;

public class N과M_1_15649 {
	// N과 M을 입력받는다.
	static int M,N;
	// 숫자의 방문여부를 체크 할 방문배열과 결과를 저장 할 배열을 선언
	static int list[],check[];
	
	
	// DFS메소드, 반복횟수를 인자로 받는다. 초기 0부터 시작
	static void dfs(int cnt) { 
		// 0부터 M번까지 반복했으면 하나의 처리가 완성
        // M보다 큰 횟수는 고려하지 않고 배제한다.	
		if(cnt == M) { 
			// 현재 결과배열을 출력
			for(int i=0;i<M;i++) { 
				System.out.print(list[i]+" ");
			}
			System.out.println();
			// DFS 종료 
			return; 
		}
		
		// 수의 범위는 1부터 N까지이다.
		for(int i =1;i<=N;i++) { 
			
			if(check[i]==1) 
				// 이미 방문한 배열이면 건너뛴다.
				continue;
			// 방문하지 않았다면, 방문처리 후
			// 현재 반복횟수에 해당하는 배열에 i값을 넣는다.
			check[i]=1;
			list[cnt]=i; 
			// 반복횟수를 증가시킨다.
			dfs(cnt+1); 
			// dfs가 종료 후에는 다시 방문여부를 0으로 초기화한다.
			check[i]=0; 
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		
		check = new int[N+1]; // n과 m의 최대범위
		list = new int [M+1];
		dfs(0);
	}	
}*/

// 순열
import java.util.Scanner;

public class N과M_1_15649 {
 
	public static int[] arr; 
	public static boolean[] check;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
		int M = in.nextInt();
 
		arr = new int[M];
		check = new boolean[N];
		Result(N, M, 0);
 
	}
 
	public static void Result(int N, int M, int idx) {
		if (idx == M) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[idx] = i + 1;
				Result(N, M, idx + 1);
				check[i] = false;
			} 
		} 
	}
}