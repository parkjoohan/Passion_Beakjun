package softeer;

import java.util.*;

public class A플러스B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println("Case #" + (i+1) + ": " + (A+B));
        }
	}

}
