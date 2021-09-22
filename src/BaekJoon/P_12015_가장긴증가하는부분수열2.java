package BaekJoon;

import java.util.*;

public class P_12015_가장긴증가하는부분수열2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		// 증가하는 부분 수열을 리스트에 넣음
		List<Integer> list = new ArrayList<>();
		// 수열의 최솟값이 1이므로 비교를 위해 0을 미리 넣어줌
		list.add(0);
		
		int value, left, right, mid;
		for (int i = 0; i < N; i++) {
			value = sc.nextInt();
			// 수열의 값이 리스트의 맨 끝 값보다 크면 리스트에 넣음.
			if(value>list.get(list.size()-1))
				list.add(value);
			// 작으면 리스트 안에서 이분탐색을 하여 알맞은 자리에 값을 대체
			else {
				left=0;
				right=list.size()-1;
				while(left<right) {
					mid=(left+right)/2;
					if(value<=list.get(mid))
						right=mid;
					else
						left=mid+1;
				}
				list.set(right, value);
			}
		}
		System.out.println(list.size()-1);		
	}
}