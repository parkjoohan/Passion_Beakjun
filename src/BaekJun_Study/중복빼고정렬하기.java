package BaekJun_Study;

import java.util.*;

public class 중복빼고정렬하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(!list.contains(num))
				list.add(num);
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+" ");
	}
}