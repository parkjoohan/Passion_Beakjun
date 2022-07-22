package BaekJoon2;

import java.util.*;
import java.io.*;

public class P_10825_국영수 {

	static String[][] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][4];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split(" ");
        }
		
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
					if(Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
						if(Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
							// 국, 영, 수 모두 같은 때, 이름 사전순으로 정렬
							return o1[0].compareTo(o2[0]);
						}
						// 국, 영 같을 때, 수학 감소하는 순서로
						return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
					}
					// 국어 같을 때, 영어 증가하는 순서로
					return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
				}
				// 국어 감소하는 순서로
				return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
			}
		});
		
		for(int i=0; i<N; i++) 
			System.out.println(arr[i][0]);
	}
}