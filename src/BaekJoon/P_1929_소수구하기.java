package BaekJoon;

import java.io.*;
import java.util.*;

public class P_1929_소수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
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