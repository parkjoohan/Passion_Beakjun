package BaekJoon;

import java.util.*;

public class P_1592_영식이와친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//인원
		int M = sc.nextInt();	//공 받는 횟수
		int L = sc.nextInt();	//옮겨가는 위치
		int[] arr = new int[N+1];
		int cnt=0;
		
		arr[1]=1;
		int i=1;
		while(true) {
			if(arr[i]==M)
				break;
			
			if(arr[i]%2==1)
				i+=L;
			else 
				i-=L;
			
			if(i>N)			// 시계방향, 범위를 넘어갈때
				i%=N;
			else if(i<1)	// 반시계방향, 범위를 넘어갈때
				i+=N;
			
			arr[i]++;
			cnt++;
		}
		System.out.println(cnt);
	}
}