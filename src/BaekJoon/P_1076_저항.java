package BaekJoon;

import java.util.*;

public class P_1076_저항 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("black", "0,1");
		map.put("brown", "1,10");
		map.put("red", "2,100");
		map.put("orange", "3,1000");
		map.put("yellow", "4,10000");
		map.put("green", "5,100000");
		map.put("blue", "6,1000000");
		map.put("violet", "7,10000000");
		map.put("grey", "8,100000000");
		map.put("white", "9,1000000000");
		
		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		
		String[] A = map.get(a).split(",");
		String[] B = map.get(b).split(",");
		String[] C = map.get(c).split(",");
		
		Long result = Long.parseLong(A[0]+B[0]) * Long.parseLong(C[1]);
		System.out.println(result);
	}
}