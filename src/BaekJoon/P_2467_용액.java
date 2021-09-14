package BaekJoon;

import java.util.*;

public class P_2467_용액 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int num1=0, num2=0;
		int start=0, end=N-1;
		int min = Integer.MAX_VALUE;
		
		while(start<end) {
			int total = arr[start] + arr[end];
			if(Math.abs(total)<min) {
				min = Math.abs(total);
				num1 = arr[start];
				num2 = arr[end];
			}
			// 값이 정렬된 상태에서 total값이 음수인 경우는 start의 절대값이 더 큰 것으로
			// 절대값이 작은 수로 가기 위해 start에 ++ 시켜줌
			// 값이 정렬된 상태에서 total값이 양수인 경우는 end의 절대값이 더 큰 것으로
			// 절대값이 작은 수로 가기 위해 end에 -- 시켜줌
			if(total < 0) { 
                start++;
            } else end--;
		}
		System.out.println(num1+" "+num2);
	}
}