package BaekJoon;

import java.util.*;

public class P_1806_부분합 {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        int S = scan.nextInt();
        
        int[] arr = new int[N + 1];
        for(int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
        
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
		
		while(start <= N && end <= N) {
            if(sum >= S && min > end - start)
            	min = end - start;
            if(sum < S) 
            	sum += arr[end++];
            else 
            	sum -= arr[start++];
        }
        
        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}    