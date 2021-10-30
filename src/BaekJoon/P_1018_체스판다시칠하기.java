package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader; 

public class P_1018_체스판다시칠하기 {   
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String[] input = br.readLine().split(" "); 
		int n = Integer.parseInt(input[0]); 
		int m = Integer.parseInt(input[1]); 
		char[][] chessboard = new char[n][m];
		
		for (int row = 0; row < n; row++) { 
			String color = br.readLine(); 
			for (int col = 0; col < color.length(); col++) { 
				chessboard[row][col] = color.charAt(col); 
			} 
		} 
		
		int answer = Integer.MAX_VALUE; 
		for (int row = 0; row < n - 7; row++) { 
			for (int col = 0; col < m - 7; col++) { 
				answer = Math.min(answer, search(row, col, chessboard)); 
			}
		} 
		System.out.println(answer); 
	}
	
	private static int search(int x, int y, char[][] chessboard) { 
		int result = 0; int temp = 'B'; 
		for (int i = x; i < x + 8; i++) {
			if (chessboard[i][y] != temp) result++;
			for (int j = y + 1; j < y + 8; j++) { 
				if (chessboard[i][j] == temp) { 
					result++; 
					if (temp == 'B') 
						temp = 'W'; 
					else temp = 'B'; 
				} 
				else temp = chessboard[i][j]; 
			} 
		}
		
		int result2 = 0;  
		temp = 'W'; 
		for (int i = x; i < x + 8; i++) { 
			if (chessboard[i][y] != temp) 
				result2++; 
			for (int j = y + 1; j < y + 8; j++) { 
				if (chessboard[i][j] == temp) { 
					result2++; 
					if (temp=='B') 
						temp = 'W'; 
					else temp = 'B'; 
				} 
				else temp = chessboard[i][j]; 
			} 
		} 
		return result > result2 ? result2 : result; 
	} 
}