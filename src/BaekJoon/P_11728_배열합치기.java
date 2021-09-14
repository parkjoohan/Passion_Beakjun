package BaekJoon;

import java.util.*;

public class P_11728_배열합치기 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[] a=new int[N];
		int[] b=new int[M];
		for (int i = 0; i < N; i++) {
			a[i]=sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			b[i]=sc.nextInt();
		}
		
		StringBuilder sb=new StringBuilder();
		Arrays.sort(a);
		Arrays.sort(b);
		
		int i=0, j=0, k=0;
		while(i<N && j<M) {
			if(a[i]<b[j]) {
				sb.append(a[i++]+" ");
			}else {
				sb.append(b[j++]+" ");
			}
		}
		
		while(i<N) {
			sb.append(a[i++]+" ");
		}
		while(j<M) {
			sb.append(b[j++]+" ");
		}
		System.out.println(sb.toString());
	}
}