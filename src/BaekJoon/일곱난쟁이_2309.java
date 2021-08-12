package BaekJoon;

import java.util.*;

public class 일곱난쟁이_2309 {

	static boolean[] check;
	static int sum=0, cnt=0;
	static int[] arr;
	static int[] result = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		check = new boolean[arr.length];
		
		for(int i=0; i<9; i++)
			arr[i] = sc.nextInt();
		
		powerSet(0);
	}
	
	static void powerSet(int idx) {
		// 9명 모두 뽑았을 때
		if(idx == arr.length) {
			// 7명의 합이 100일때
			if(cnt==7 && sum==100) {
				int num=0;
				for(int j=0; j<9; j++) {
					if(check[j]) {
						// 결과 배열에 조건에 맞는 난쟁이 정보 넣기
						result[num] = arr[j];
						num++;
					}
				}
				// 순서 정렬
				Arrays.sort(result);
				
				for(int i=0; i<7; i++)
					System.out.println(result[i]);
				System.exit(0);
			}
			return;
		}
		check[idx] = true;
		sum += arr[idx];
		cnt++;
		powerSet(idx+1);
		check[idx] = false;
		sum -= arr[idx];
		cnt--;
		powerSet(idx+1);
	}
}