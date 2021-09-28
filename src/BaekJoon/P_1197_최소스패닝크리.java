package BaekJoon;

import java.io.*;
import java.util.*;

public class P_1197_최소스패닝크리 {

	static int V, E;
	static int start = 1;
	static ArrayList<node>[] arr; 
	static PriorityQueue<node> pq = new PriorityQueue<>();
	static boolean[] visited;
	static long answer =0;
	
	public static class node implements Comparable<node>{
		int vertex;
		int weight;
		
		public node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		visited	 = new boolean[V+1]; // 각 정점은 1부터 시작한다.
		
		arr = new ArrayList[V+1];
		for ( int i=0; i<=V; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 정점간 연결 
		for( int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[from].add(new node(to,weight));
			arr[to].add(new node(from,weight));
		}
		
		// 1번 부터 시작하자 (프림 사용)
		prim();
		System.out.println(answer);
	}
	private static void prim() {
		// 1번부터 시작해서 연결되어 있는 곳 모두 탐색하자.
		pq.add(new node(start,0));
		int count =0;
		while(!pq.isEmpty()) {
			// 꺼내오기
			node cur = pq.poll();
			// 방문했던 곳은 패스
			if(visited[cur.vertex]) continue;
			// 방문처리
			visited[cur.vertex] = true;
			// 방문한 것은 가중치 처리
			answer += cur.weight;
			
			for ( node next : arr[cur.vertex]) {
				if ( !visited[next.vertex]) {
					pq.add(next);
				}
			}
			if ( ++ count == V ) break;
		}	
	}
}