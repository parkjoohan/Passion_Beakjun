package BaekJoon;

import java.util.*;

public class P_3184_양 {
	static int R,C;
	static int sheep, wolf;
	static String maps[];
	static char dist[][];
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Node {
	int x, y;
	Node(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		maps = new String[R+1];
		dist = new char[R+1][C+1];
		visit = new boolean[R+1][C+1];
		
		for(int i = 0;i<R;i++) {
			maps[i] = sc.next();
			for(int j = 0; j < maps[i].length(); j++ ) {
				dist[i][j] = maps[i].charAt(j);
			}
		}
		
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				if (dist[i][j] == 'o') {
					sheep++;
				}
				
				if (dist[i][j] == 'v' ) {
					wolf++;
				}
			}
		}
		
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				if (visit[i][j]) continue;
				if (dist[i][j] == 'o' || dist[i][j] == 'v') {
					bfs(i,j);
				}
			}
		}
		System.out.println(sheep + " "+  wolf);
	}

	static void bfs(int i,int j){
		int curWolf = 0, curSheep = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i, j));
		visit[i][j] = true;
		
		if (dist[i][j] == 'o') curSheep++;
		if (dist[i][j] == 'v') curWolf++;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			
			for(int k = 0; k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if (nx < 0  || R <= nx  || ny < 0 || C <= ny) continue;
				if (visit[nx][ny]) continue;
				
				if (dist[nx][ny] == '#') continue;
				
				if (dist[nx][ny] == 'o') curSheep++;
	
				if (dist[nx][ny] == 'v') curWolf++;
	
				visit[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
		if (curSheep > curWolf) wolf -= curWolf;		
		else sheep -= curSheep;
	}
}