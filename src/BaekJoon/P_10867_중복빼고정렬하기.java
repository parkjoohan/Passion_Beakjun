package BaekJoon;

import java.util.*;

public class P_10867_중복빼고정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for (int i = 0; i < N; i++) {
			hs.add(sc.nextInt());
		}
		ArrayList<Integer> list = new ArrayList<Integer>(hs);
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}