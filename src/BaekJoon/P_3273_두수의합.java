package BaekJoon;

import java.io.*;
import java.util.*;

public class P_3273_두수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		int x = Integer.valueOf(br.readLine());
		int sum=0, cnt=0;
		int start=0, end=N-1;
		
		while(start<end) {
			sum = arr[start]+arr[end];
			if(sum==x)
				cnt++;
			if(sum<=x)
				start++;
			else
				end--;
		}
		System.out.println(cnt);
	}
}