package BaekJoon3;

import java.util.*;
import java.util.*;

public class 듣보잡 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashSet<String> set = new HashSet<>();
		
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) 
			set.add(sc.next());
		
		for(int i=0; i<M; i++) {
			String str = sc.next();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}