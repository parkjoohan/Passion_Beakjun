package BaekJoon;

import java.util.*;

public class P_14465_소가길을건너간이유5 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int B = sc.nextInt();
        int[] arr = new int[N+1];
        
        for(int i = 1; i <= B; i++) {
        	int num = sc.nextInt();
        	arr[num] = 1;
        }
    	
        int MIN = Integer.MAX_VALUE;
        int cnt = 0, windowStart = 1;
        
        for(int windowEnd = 1; windowEnd <= N; windowEnd++) {
        	if(arr[windowEnd] == 1)		cnt++;
        	
        	if(windowEnd - windowStart == K-1) {
        		MIN = Math.min(MIN, cnt);
        		
	        	if(arr[windowStart] == 1)	cnt--;
        		windowStart++;
        	}
        }
        System.out.println(MIN);
    }
}