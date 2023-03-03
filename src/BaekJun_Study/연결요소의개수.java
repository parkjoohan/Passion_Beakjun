package BaekJun_Study;

import java.io.*;
import java.util.*;

public class 연결요소의개수 {

	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list[start].add(end);
			list[end].add(start);
		}
		
		int cnt = 0;
		
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				cnt++;
				DFS(i);
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void DFS(int v) {
		// TODO Auto-generated method stub
		if(visited[v])		return;
		
		visited[v] = true;
		
		for(int i : list[v]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
}