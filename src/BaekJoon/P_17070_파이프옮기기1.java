package BaekJoon;

/*import java.util.*;

public class 파이프옮기기1_17070 {

	static int N, cnt;
	static int[][] arr;
	public static boolean check(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 시작부분이 (0,0), (0,1)이므로
		move(0,1,0);		
		System.out.println(cnt);
	}
	
	public static void move(int r, int c, int d) {
		
		// N*N에 도착, 파이프 없을 경우
		if(r == N-1 && c == N-1 && arr[r][c] != 1) {
			cnt++;
			return;
		}
		
		// 파이프 가로 일때
		if(d == 0) {
			// 다음이 가로
			if(check(r, c+1) && arr[r][c+1] == 0)
				move(r, c+1, 0);			
			// 다음이 오른쪽 아래 대각선
			if(check(r+1, c+1) && arr[r+1][c+1] == 0 && arr[r+1][c] == 0 && arr[r][c+1] == 0) 
				move(r+1, c+1, 2); 
		} 
		// 파이프 세로 일때
		else if(d == 1) { 
			// 다음이 세로
			if(check(r+1, c) && arr[r+1][c] == 0) 
				move(r+1, c, 1);			
			// 다음이 오른쪽 아래 대각선
			if(check(r+1, c+1) && arr[r+1][c+1] == 0 && arr[r][c+1] == 0 && arr[r+1][c] == 0)
				move(r+1, c+1, 2);
		} 
		// 파이프 오른쪽 아래 대각선 일때
		else if(d == 2) {	
			// 다음이 가로
			if(check(r, c+1) && arr[r][c+1] == 0) 
				move(r, c+1, 0);			
			// 다음이 세로
			if(check(r+1, c) && arr[r+1][c] == 0) 
				move(r+1, c, 1);			
			// 다음이 오른쪽 아래 대각선
			if(check(r+1, c+1) && arr[r+1][c+1] == 0 && arr[r][c+1] == 0 && arr[r+1][c] == 0) 
				move(r+1, c+1, 2);	
		}
	}
}*/




import java.util.*;

public class P_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		}
		dfs(0, 1, 0);
		System.out.println(ans);
	}
	static void dfs(int r, int c, int dir) {
		if( r == N-1 && c == N-1) {
			ans++;
			return;
		}
		if( dir != 1 && c + 1 < N && map[r][c+1] == 0 )
			dfs(r, c+1, 0);
		if( dir != 0 && r + 1 < N && map[r+1][c] == 0 )
			dfs(r+1, c, 1);
		if( r + 1 < N && c + 1 < N && map[r][c+1] + map[r+1][c] + map[r+1][c+1] == 0){
			dfs(r+1, c+1, 2);
		}
	}
}