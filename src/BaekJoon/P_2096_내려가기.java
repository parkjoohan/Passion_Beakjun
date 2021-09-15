package BaekJoon;

import java.util.Scanner;

public class P_2096_내려가기 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] arr = new int[N+1][3];
        for(int i = 1; i <= N; i++) 
            for(int j = 0; j < 3; j++) 
                arr[i][j] = sc.nextInt();
        
        int[][] maxdp = new int[N+1][3];    
        int[][] mindp = new int[N+1][3];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i <= N; i++) {
        	maxdp[i][0] += Math.max(maxdp[i-1][0], maxdp[i-1][1]) + arr[i][0];
        	maxdp[i][1] += Math.max(Math.max(maxdp[i-1][0], maxdp[i-1][1]), maxdp[i-1][2]) + arr[i][1];
        	maxdp[i][2] += Math.max(maxdp[i-1][1], maxdp[i-1][2]) + arr[i][2];
            
        	mindp[i][0] += Math.min(mindp[i-1][0], mindp[i-1][1]) + arr[i][0];
        	mindp[i][1] += Math.min(Math.min(mindp[i-1][0], mindp[i-1][1]), mindp[i-1][2]) + arr[i][1];
        	mindp[i][2] += Math.min(mindp[i-1][1], mindp[i-1][2]) + arr[i][2];
        }
        
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, mindp[N][i]);
            max = Math.max(max, maxdp[N][i]);
        }
        System.out.println(max+" "+min);
    }
} 