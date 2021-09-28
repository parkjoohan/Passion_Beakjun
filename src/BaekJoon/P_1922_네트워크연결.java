package BaekJoon;

import java.util.*;

class P_1922_네트워크연결 {
	static PriorityQueue<Node> pq;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		pq=new PriorityQueue<>();
		parent=new int[N+1];
		for(int i=1;i<=N;i++) 
			parent[i]=i; // 부모는 자기 자신
		
		for(int i=0;i<M;i++) {
			int to = sc.nextInt();
			int from = sc.nextInt();
			int weight = sc.nextInt();
			pq.offer(new Node(to, from, weight));
		}
		System.out.println(func());
	}
	
	// 크루스칼 사용
	public static int func() {
		int sum=0;
		// 가중치 작은 것 먼저 뽑음
		while(!pq.isEmpty()) { 
			Node now=pq.poll();
			int parent_Start=find(now.start);
			int parent_End=find(now.end);
			// 둘이 연결되어 있는 경우이므로 패스
			if(parent_Start==parent_End) 
				continue; 
			// 둘을 연결
			union(parent_Start, parent_End);
			// 최소비용 추가 
			sum+=now.weight; 
		}
		return sum;
	}
	
	// x의 최상위 부모 리턴
	public static int find(int x) { 
		if(x==parent[x]) 
			return x;
		else 
			return parent[x]=find(parent[x]);
	}
	
	// a, b를 연결
	public static void union(int a, int b) { 
		parent[a]=b;
	}
	public static class Node implements Comparable<Node>{
		int start; int end; int weight;
	
		public Node(int start, int end, int weight) {
			this.start=start;
			this.end=end;
			this.weight=weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
}