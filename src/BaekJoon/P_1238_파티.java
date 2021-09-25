package BaekJoon;

import java.io.*;
import java.util.*;

public class P_1238_파티 {
	static final int INF = Integer.MAX_VALUE;
	static int N, M, X;
	static int[] dist;
	static boolean[] visit;
	static LinkedList<Edge>[] List;
	
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
		
		List = new LinkedList[N+1];
		for(int i=1; i<=N; i++) List[i] = new LinkedList<>();
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			List[from].add(new Edge(to, weight));
		}
		
		int res = 0;
		for(int i=1; i<=N; i++) {
			if(i == X) continue;
			res = Math.max(res, dijkstra(i, X) + dijkstra(X, i));
		}
		System.out.println(res);
	}
	
	private static int dijkstra(int start, int end) {
		dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        while (!queue.isEmpty()) {
        	Edge node = queue.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if (dist[vertex] < weight) { 
                continue;
            }
            for (int i = 0; i < List[vertex].size(); i++) {
                int vertex2 = List[vertex].get(i).vertex;
                int weight2 = List[vertex].get(i).weight + weight;
                if (dist[vertex2] > weight2) { 
                    dist[vertex2] = weight2;
                    queue.add(new Edge(vertex2, weight2));
                }
            }
        }
        return dist[end];
	}
}