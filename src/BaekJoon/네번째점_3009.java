package BaekJoon;

import java.util.*;

public class 네번째점_3009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr_a = {sc.nextInt(), sc.nextInt()};
		int[] arr_b = {sc.nextInt(), sc.nextInt()};
		int[] arr_c = {sc.nextInt(), sc.nextInt()};
		int X = 0;
		int Y = 0;
		
		if(arr_a[0] == arr_b[0])
			X = arr_c[0]; 
		else if(arr_a[0] == arr_c[0])
			X = arr_b[0]; 
		else
			X = arr_a[0]; 

		if(arr_a[1] == arr_b[1])
			Y = arr_c[1]; 
		else if(arr_a[1] == arr_c[1])
			Y = arr_b[1]; 
		else
			Y = arr_a[1]; 
		
		System.out.println(X + " " + Y);
	}
}
