package softeer;

import java.util.*;

public class 주행거리비교하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        if(A>B)
            System.out.print("A");
        else if(A<B)
            System.out.print("B");
        else
            System.out.print("same");
	}

}
