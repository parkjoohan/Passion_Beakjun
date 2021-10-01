package BaekJoon;

import java.util.*;

public class P_18352_특정거리의도시찾기 {

	static class Node implements Comparable<Node> {
		int vertex, cost;
		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return cost-o.cost;
		}
	}
	
	static int N, M, K, X;
	static int[] dist;
	static ArrayList<Node>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();
		dist = new int[N+1];
		list = new ArrayList[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		// 경로 초기화
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			// A 도시에서 B 도시로 리동하는 단방향 도로가 존재
			list[start].add(new Node(end, 1));
		}
		// 출발도시
		dist[X]=0;
		// 다익스트라
		dijkstra();
		
		int res=0;
		for (int i = 1; i < dist.length; i++) {
			int distance = dist[i];
			if(distance==K) {
				System.out.println(i);
				res++;
			}
		}
		if(res==0)	System.out.println(-1);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(X,0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int vertex = now.vertex;
			int cost = now.cost;
			
			if(dist[vertex]<cost)	continue;
			
			for (int i = 0; i < list[vertex].size(); i++) {
				int vertex2 = list[vertex].get(i).vertex;
				int cost2 = list[vertex].get(i).cost + cost;
				
				if(dist[vertex2]>cost2) {
					dist[vertex2]=cost2;
					q.add(new Node(vertex2, cost2));
				}
			}
		}
	}

}