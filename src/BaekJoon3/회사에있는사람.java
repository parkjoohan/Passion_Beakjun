package BaekJoon3;

import java.util.*;

public class 회사에있는사람 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<String, String>();
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			String name = sc.next();
			String state = sc.next();
			
			if(map.containsKey(name)) {
				map.remove(name);
			} else {
				map.put(name, state);
			}
		}

		ArrayList<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, Collections.reverseOrder());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}