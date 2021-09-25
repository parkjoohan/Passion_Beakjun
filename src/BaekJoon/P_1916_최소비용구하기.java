package BaekJoon;

import java.io.*;
import java.util.*;

public class P_1916_최소비용구하기 {
	private static int N, M, ans;
	private static final int INF = Integer.MAX_VALUE;
	private static ArrayList<Path>[] adjList;
	private static int[] weight;
	private static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[N+1];
		weight = new int[N+1];
		visited = new boolean[N+1];
		ans = 0;
		
		//인접리스트 초기화
		for (int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[start].add(new Path(end, weight)); 
		}
		st = new StringTokenizer(br.readLine());
		int startPos= Integer.parseInt(st.nextToken());
		int endPos = Integer.parseInt(st.nextToken());
		
		ans = dijkstra(startPos, endPos);
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	private static int dijkstra(int start, int end) {
		//여기서 선언하면 sample data가 여러개라도 매번 queue clear 할 필요 없음
		PriorityQueue<Path> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			weight[i] = INF;
		}
		Arrays.fill(visited, false);
		weight[start] = 0;
		
		pq.add(new Path(start, 0));
		
		while (!pq.isEmpty()) {
			Path now = pq.poll();
		
			//간선 가중치가 변하는 문제라면 visited 대신 이걸 써야 함
			//if (weight[now.vertex] < now.weight) continue;			
			
			if(visited[now.vertex]) continue;
			visited[now.vertex] = true;
			
			for (Path next : adjList[now.vertex]) {
				//now.weight 자체가 이미 now.vertex까지의 현재 기준 누적 최소 weight 이기 때문에
				//굳이 now.weight + weight[now.vertex] 로 할필요 없음
				if(weight[next.vertex] > next.weight + now.weight) {
					weight[next.vertex] = next.weight + now.weight;
					pq.add(new Path(next.vertex, weight[next.vertex]));
				}
			}			
		}
		return weight[end];
	}
	
	private static class Path implements Comparable<Path>{
		int vertex, weight;
		public Path(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Path o) {
			return this.weight - o.weight;			
		}
	}
}