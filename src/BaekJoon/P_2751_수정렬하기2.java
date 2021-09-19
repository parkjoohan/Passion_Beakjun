package BaekJoon;

import java.util.*;

public class P_2751_수정렬하기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) 
			list.add(sc.nextInt());
		
		Collections.sort(list);
		
		for(int c : list)
			sb.append(c).append('\n');
		System.out.println(sb);
    }
}