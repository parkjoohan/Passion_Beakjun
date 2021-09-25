package BaekJoon;

import java.io.*;
import java.util.*;

public class P_1238_파티 {
	static final int INF = Integer.MAX_VALUE;
	static int N, M, X;
	static int[] distance;
	static boolean[] visit;
	static LinkedList<Edge>[] adjList;
	
	private static class Edge implements Comparable<Edge> {
		int vertex, weight;
		public Edge(int vertex, int weight) { this.vertex = vertex; this.weight = weight; }
		
		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 학생/마을 수
		M = Integer.parseInt(st.nextToken());	// 도로의 수
		X = Integer.parseInt(st.nextToken());	// 도착 마을
		
		adjList = new LinkedList[N+1];
		for(int i=1; i<=N; i++) adjList[i] = new LinkedList<>();
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Edge(to, weight));
		}
		
		int res = 0;
		for(int i=1; i<=N; i++) {
			if(i == X) continue;
			res = Math.max(res, dijkstra(i, X) + dijkstra(X, i));
		}
		System.out.println(res);
	}
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance = new int[N+1];
		Arrays.fill(distance, INF);
		visit = new boolean[N+1];
		
		pq.add(new Edge(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visit[now.vertex]) continue;
			visit[now.vertex] = true;
			
			for(Edge next : adjList[now.vertex]) {
				if(visit[next.vertex]) continue;
				if(distance[now.vertex] + next.weight < distance[next.vertex]) {
					distance[next.vertex] = distance[now.vertex] + next.weight;
					pq.add(new Edge(next.vertex, distance[next.vertex]));
				}
			}
		}
		return distance[end];
	}
}