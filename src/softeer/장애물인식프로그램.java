package softeer;

import java.util.*;

public class 장애물인식프로그램 {

    static int N, count = 0;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++) {
            int num = result.get(i);
            System.out.println(num);
        }
	}

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                if (map[nx][ny] == 1) {
                    count++;
                    dfs(nx, ny);
                }
            }
        }
    }
}
