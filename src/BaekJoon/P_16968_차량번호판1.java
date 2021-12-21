package BaekJoon;

import java.util.*;

public class P_16968_차량번호판1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();
		int num = 1;
		
		for (int i = 0; i < str.length; i++) {
			if(i==0) {
				if(str[i]=='c')
					num*=26;
				else
					num*=10;
			}
			else {
				if(str[i]==str[i-1]) {
					if(str[i]=='c')
						num*=25;
					else
						num*=9;
				}
				else {
					if(str[i]=='c')
						num*=26;
					else
						num*=10;
				}
			}
		}
		System.out.println(num);
	}
}