package BaekJoon;

import java.util.*;
 
public class 색종이붙이기_17136 {

	static int N=10;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10][10]; 
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}	
		dfs(0,0,0);
		
	}
	
	static void dfs(int r, int c, int size) {
		
	}
	
	// 붙이기
	static void add(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				arr[i][j]=0;
			}
		}
	}
	
	// 떼어내기
	static void remove(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				arr[i][j]=1;
			}
		}
	}
	
	static boolean check(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(r>=0 && c>=0 && r<10 && c<10 || arr[i][j]!=1)
					return false;
			}
		}
		return true;
	}
}