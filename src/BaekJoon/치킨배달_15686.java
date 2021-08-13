package BaekJoon;

/*import java.util.*;
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
}*/


import java.util.*;

//5 5
//1 2 0 0 0
//1 2 0 0 0
//1 2 0 0 0
//1 2 0 0 0
//1 2 0 0 0
public class 치킨배달_15686 {
	static class Point{
		int r,c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int N;
	static int M;
	static int[][] map;
	static List<Point> houses = new ArrayList<>();
	static List<Point> chickens = new ArrayList<>();
	static Point[] sel;
	static int ans = 987654321;
	//chickens갯수 중에 M개를 고를거임.
	private static void combination(int cnt,int start) {
		if(cnt == M) {
			//각 집별로 M개의 선택된 치킨집 중 가장 가까운 치킨집까지의 거리를 구해서
			//다 더한다.
			int sum = 0;
			for(int i = 0; i < houses.size(); i++) {
//				Point house = houses.get(i);
//				sum += (Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c));
				int tmp = 987654321;
				Point house = houses.get(i);
				for(int j = 0; j < M; j++) {
					Point chicken = sel[j];
					int dist = (Math.abs(house.r - chicken.r) 
							+ Math.abs(house.c - chicken.c));
					tmp = Math.min(tmp, dist);
				}
				sum += tmp;
			}
			
			//그 다 더한값이 젤 작으면 그게 정답
			ans = Math.min(ans, sum);
			return;
		}
		// start 위치의 수부터 가능한 수 모두 고려
		for (int i = start; i < chickens.size(); i++) { // i : 인덱스
			sel[cnt] = chickens.get(i);
			// 다음 자리순열 뽑으로 gogo
			combination(cnt+1,i+1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new Point[M];
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if( map[i][j] == 2 ) {
					chickens.add(new Point(i, j));
				}
				else if( map[i][j] == 1 )
					houses.add(new Point(i, j));
			}
		}
		combination(0, 0);
		System.out.println(ans);
		
	}
}