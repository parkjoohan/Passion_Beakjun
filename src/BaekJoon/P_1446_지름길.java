package BaekJoon;

import java.util.*;
import java.io.*;

public class P_1446_지름길 {
	private static int N, D;
	private static List<List<Node>> list;
	private static boolean visited[];
	private static int distance[];
	private static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		D = sc.nextInt();
		visited = new boolean[D+1];
		distance = new int[D+1];
		list = new ArrayList<List<Node>>();
		
		Arrays.fill(distance, INF);
		list.add(new ArrayList<>());
		
		for(int i = 0; i < D; i++) {
			list.add(new ArrayList<Node>());
			list.get(i).add(new Node(i+1, 1));
		}
		
		for(int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(a > D || b > D) continue;
			list.get(a).add(new Node(b, c));
		}
		dijstra();
		System.out.println(distance[D]);
	}
	
	private static void dijstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		distance[0] = 0;
		
		pq.add(new Node(0, 0));
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node node : list.get(now)) {				
				if(distance[node.index] > distance[now] + node.dist) {
					distance[node.index] = distance[now] + node.dist;
					pq.add(new Node(node.index, distance[node.index]));
				}
			}
		}
	}
	
	private static class Node implements Comparable<Node> {
		int index, dist;
		public Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return dist - o.dist;
		}
	}
}