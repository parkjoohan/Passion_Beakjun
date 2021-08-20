package BaekJoon;

import java.util.Scanner;

public class P_1929_소수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i=a; i<b; i++) {
			int cnt=0;
			
			for(int j=1; j<=i; j++){
				if(i % j == 0) cnt++;
			}	
			if(cnt == 2)
				System.out.println(i);		
		}
	}
}