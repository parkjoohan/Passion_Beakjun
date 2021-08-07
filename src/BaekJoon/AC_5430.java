package BaekJoon;

import java.io.*;
import java.util.*;

public class AC_5430 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		Deque<Integer> d = new ArrayDeque<Integer>();
	
		for(int i=1; i<=T; i++) {
			// 함수
			String func = sc.next();
			// 배열의 수 개수
			int num = sc.nextInt();
			StringTokenizer st = new StringTokenizer(sc.next(), "[],");
			// 배열 수 입력
			for(int j=0; j<num; j++) {
				d.add(Integer.parseInt(st.nextToken()));
			}
		}
	}
}