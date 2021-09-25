package BaekJoon;

import java.io.*;
import java.util.*;

public class P_1504_특정한최단경로 {

	static int N, E;
	static ArrayList<Edge>[] list;
	static int[] dist;
	static boolean[] visited;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1-> v1 -> v2 -> N
		long res1=0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		
		// 1-> v2 -> v1 -> N
		long res2=0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);
		
		if (Math.min(res1, res2) >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(res1, res2));
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
            for (int i = 0; i < list[vertex].size(); i++) {
                int vertex2 = list[vertex].get(i).vertex;
                int weight2 = list[vertex].get(i).weight + weight;
                if (dist[vertex2] > weight2) { 
                    dist[vertex2] = weight2;
                    queue.add(new Edge(vertex2, weight2));
                }
            }
        }
        return dist[end];
        
		/*PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dist, INF);
		
		pq.add(new Edge(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visited[now.vertex])	continue;
			visited[now.vertex]=true;
			
			for(Edge next : list[now.vertex]) {
				if(visited[now.vertex])	continue;
				if(dist[next.vertex]>dist[now.vertex]+next.weight) {
					dist[next.vertex]=dist[now.vertex]+next.weight;
					pq.add(new Edge(next.vertex, dist[next.vertex]));
				}
			}
		}
		return dist[end];*/
	}
	private static class Edge implements Comparable<Edge>{
		int vertex; int weight;
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
