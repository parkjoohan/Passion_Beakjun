package BaekJoon;

import java.util.Scanner;

public class P_11729_하노이의탑이동순서 {
	static int count = 0;
	static StringBuilder a = new StringBuilder("");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = 1;
		int by = 2;
		int end = 3;
		int n = sc.nextInt();
		hanoi(1,2,3,n);
		System.out.println(count);//  2^count -1
		System.out.println(a);
	}

	public static void hanoi(int start ,int by , int end , int n) {
		count++;
		if(n == 1) {
			a.append(start + " " + end+"\n");
		}else if(n>1) {
			int tempN = n - 1;
			hanoi(start, end, by, tempN);
			a.append(start + " " + end + "\n");
			hanoi(by, start, end, tempN);
		}
	}
}