package BaekJoon;

import java.util.*;

public class P_2110_공유기설치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		int result=0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int left = 1;
		int right = arr[N-1]-arr[0];
		while(left <= right) {
			int mid = (left+right)/2;
			int firstHouse = arr[0];
			int cnt=1;
			
			for (int i = 0; i < N; i++) {
				// 집마다의 거리
				int dist = arr[i]-firstHouse;
				// 공유기 설치 가능한지
				if(dist>=mid) {
					cnt++;
					// 설치 가능하다면 현재 집부터 다시 거리 체크
					firstHouse=arr[i];
				}
			}
			
			// 공유기가 가지고 있는 것보다 많을 경우 -> 공유기를 줄여야함 / 간격 넗히기
			if(cnt>=C) {
				left = mid+1;
				result = mid;
			}
			// 공유기가 가지고 있는 것보다 적을 경우 -> 공유기 늘리기 / 간격 좁힌다.
			else
				right = mid-1;
		}
		System.out.println(result);
	}
}