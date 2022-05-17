package BaekJoon2;

import java.util.*;

public class P_1965_상자넣기 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        
        int n = sc.nextInt();
        int a[] = new int[n];
        int dp[] = new int[n];
        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();
        
        int max = 0;
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(a[i] > a[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            if(max < dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}