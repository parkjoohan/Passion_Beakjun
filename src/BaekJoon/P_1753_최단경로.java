package BaekJoon;

import java.io.*;
import java.util.*;

/*public class dijkstra {
	
	static int V, E, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();	// 정점의 개수
		E = sc.nextInt(); 	// 간선의 개수
		K =sc.nextInt();	// 시작 정점의 번호(
		
		
	}
}*/

public class P_1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int start = 0;
		int end =  V-1; //도착점 인덱스
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		int[] distance = new int[V];	// 갱신되는 거리들을 저장할 배열 
		boolean[] visited = new boolean[V];		// 확보된 정점을 저장하는 배열
		
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim(), " ");
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;	// 시작 지점의 dist를 0으로 준다.
		
		int min=0, current=0;
		for(int i=0; i<V; ++i){
			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			min = INFINITY;
			for(int j=0; j<V; ++j){
				if(!visited[j] && distance[j] < min){
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true; // 선택 정점 방문 처리
			if(current == end){ // 선택 정점이 도착정점이면 탈출.
				break;
			}
			
			//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리(갱신)
			for(int c=0; c<V; ++c){
				// 확보하지 않았으면서 !visited[c]
				
				// 나와 경로가 존재하고 matrix[current][c] != 0
				 
				// 해당 정점까지의 미리 알려진 거리가 (distance[c])
				// 이번에 선택된 정점까지 거리(min) + 해당지점까지 가는 거리 (matrix[current][c]) 
				// 보다 작으면 갱신
				if(!visited[c] && matrix[current][c] != 0
						&&  distance[c] > min+matrix[current][c]){
					distance[c] = min+matrix[current][c];
				}
			}
		}
		System.out.println(distance[end]);	
	}
}