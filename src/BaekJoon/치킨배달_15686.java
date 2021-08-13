package BaekJoon;

import java.util.*;
import java.io.*;

public class 치킨배달_15686 {
	static int N, M;
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	
	static ArrayList<Site> home = new ArrayList();
	static ArrayList<Site> market = new ArrayList();
	static boolean[] check; // 뽑은 치킨집 체크
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]==1)
					home.add(new Site(i,j));
				else if(map[i][j]==2)
					market.add(new Site(i,j));
			}			
		}
		
		check = new boolean[market.size()];
		// M개의 치킨집을 뽑는다
		function(0, 0);
		System.out.println(result);
		
	}
	
	static void function(int idx, int cnt) {
		if(idx == M) { 
            int sum = 0; 
            for(int i = 0; i < home.size(); i++) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < market.size(); j++) {
                	if(check[j] == true) { 
                		int distance = Math.abs(home.get(i).x - market.get(j).x)
                				+ Math.abs(home.get(i).y - market.get(j).y);
                		min = Math.min(min, distance);
                	}
                }
                sum += min;
            }
            result = Math.min(sum, result);
            return;
        }
        for(int i = cnt; i < market.size(); i++) {
            if(check[i] == false) {
            	check[i] = true;
            	function(idx + 1, i + 1);
                check[i] = false;
            }
        }
	}

	static class Site {
		int x, y;
		
		public Site(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}