package BaekJoon;

import java.util.*;

public class 스위치켜고끄기_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sw = new int[N + 1];//1번부터 사용하기 위해 하나 더 큰 배열 준비.
		for(int i = 1; i <= N; i++)
			sw[i] = sc.nextInt();

		int student = sc.nextInt();

		for(int i = 0; i < student; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			//남자(자신의 배수들을 스위치 변경)
			if(gender == 1) {
				for(int j = num; j <= N; j+= num) {
					sw[j] = sw[j]==1?0:1;
				}
			}
			//여자(자신의 좌우로 한쪽 끝이 만날때까지 스위치를 변경)
			else if(gender == 2) {
				int cur = 1;
				//일단 현재 위치 변경
				sw[num] = sw[num] == 1 ? 0 : 1;
				while(true) {
					if( num-cur < 1 || num + cur > N || sw[num-cur] != sw[num+cur])
						break;
					sw[num-cur] = sw[num-cur] == 1 ? 0 : 1;
					sw[num+cur] = sw[num+cur] == 1 ? 0 : 1;
					cur++;
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			System.out.print(sw[i] + " ");
			if(i % 20 == 0)
				System.out.println();
		}
	}
}