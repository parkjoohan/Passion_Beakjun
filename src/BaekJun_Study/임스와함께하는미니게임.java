package BaekJun_Study;

import java.util.*; 

public class 임스와함께하는미니게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String game = sc.next();
		
		for(int i=0; i<N; i++) {
			set.add(sc.next());
		}
		
		if(game.equals("Y"))
			System.out.println(set.size()/1);
		else if(game.equals("F"))
			System.out.println(set.size()/2);
		else if(game.equals("O"))
			System.out.println(set.size()/3);
	}
}