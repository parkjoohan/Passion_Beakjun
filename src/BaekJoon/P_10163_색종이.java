package BaekJoon;

import java.io.*;
import java.util.*;

public class P_10163_색종이 {
	
	static int N;
	static int[][] map;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[101][101];
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + a; j++) {
                for (int k = y; k < y + b; k++) {
                    map[j][k] = i;
                }
            }
        }
        for (int z = 1; z <= N; z++) {
            int cnt = 0;
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] == z) 
                    	cnt++;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
    }
}