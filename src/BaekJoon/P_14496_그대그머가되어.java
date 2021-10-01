package BaekJoon;

import java.util.*;

public class P_14496_그대그머가되어 {

	static ArrayList<Node> li[] ;
	static boolean visited[] ;
	static int dist[] ;
	static int a, b, N, M ;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N+1] ;
		dist = new int[N+1] ;
		Arrays.fill(dist, Integer.MAX_VALUE) ;
		li = new ArrayList[N+1] ;
		
		for (int i = 1 ; i <= N ; i++) 
			li[i] = new ArrayList<Node>();
			
		for (int i = 0 ; i < M ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			li[x].add(new Node(y, 1)) ;
			li[y].add(new Node(x, 1)) ;
		}
		
		dijkstra(a) ;

		if (dist[b] == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(dist[b]);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>() ;
		pq.add(new Node(start, 0)) ;
		visited[start] = true ;
		dist[start] = 0 ;
		
		while (!pq.isEmpty()) {
			Node now = pq.poll() ;
			int TO = now.to ;
			
			if (TO == b) return ;
			
			for (Node next : li[TO]) {
				if (visited[next.to] == true ) continue ;
				if (dist[next.to] > dist[TO] + next.dis) {
					dist[next.to] = dist[TO] + next.dis ;
					visited[next.to] = true ;
					pq.add(new Node(next.to, dist[next.to])) ;
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int to, dis ;
		public Node(int to, int dis) {
			this.to = to ;
			this.dis = dis ;
		}
		@Override
		public int compareTo(Node o) {
			return dis - o.dis ;
		}
	}
}