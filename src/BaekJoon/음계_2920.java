package BaekJoon;

import java.util.*;

public class 음계_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		String s = "";
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		for(int j=0; j<arr.length-1; j++) {
			if(arr[j] == arr[j+1] + 1) 
				s = "descending";
			else if(arr[j] == arr[j+1] - 1) 
				s = "ascending";
			else {
				s = "mixed";
				break;
			}
				
		}
		System.out.println(s);
	}
}
