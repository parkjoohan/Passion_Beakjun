package softeer;

import java.util.*;

public class 바이러스 {
    public static int K, P, N;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int P = sc.nextInt();
        int N = sc.nextInt();
        long answer = K;

        for(int i=1; i<=N; i++) 
            answer = (answer*P) % 1000000007;
        
        System.out.print(answer);
    }
}