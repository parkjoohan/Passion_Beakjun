package BaekJoon;

import java.util.*;

public class P_1316_그룹단어체커 {

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int cnt = N; 
				
		for (int tc = 0; tc < N; tc++) {
			String str = sc.next();
			boolean[] arr = new boolean[26];
			
			for (int i = 1; i < str.length(); i++) {
				if(str.charAt(i) != str.charAt(i-1)) {
					if(arr[str.charAt(i)-97] == true) {
						cnt--; break;
					}
					arr[str.charAt(i-1)-97] = true;
				}
			}
		}
		System.out.println(cnt);
	}
}