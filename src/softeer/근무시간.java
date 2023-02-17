package softeer;

import java.util.*;

public class 근무시간 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int sum = 0;

        for(int i=0; i<5; i++) {
            String strA = sc.next();
            String strB = sc.next();

            String[] arrA = strA.split(":");
            String[] arrB = strB.split(":");

            int sumA = Integer.parseInt(arrA[0])*60 + Integer.parseInt(arrA[1]);
            int sumB = Integer.parseInt(arrB[0])*60 + Integer.parseInt(arrB[1]);
            sum += (sumB - sumA);
        }
        
        System.out.println(sum);
	}

}
