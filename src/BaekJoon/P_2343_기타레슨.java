package BaekJoon;

import java.util.*;

public class P_2343_기타레슨 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int left=0, right=0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			right += arr[i];
			if(left<arr[i])
				left=arr[i];
			else
				left=left;
		}
		
		while(left <= right) {
			int mid = (left+right) / 2;		// 블루레이 크기
			int sum=0, cnt=0;
			
			for (int i = 0; i < N; i++) {
				// 레슨의 길이가 블루레이 크기 초과시 크기 증가
				if(sum+arr[i]>mid) {
					sum=0; cnt++;
				}
				sum+=arr[i];
			}
			if(sum!=0)	cnt++;	// mid 보다 작아서 1 증가시키지 못한 경우
			if(cnt>M) 
				left = mid+1;
			else
				right = mid-1;
		}
		System.out.println(left);
	}
}