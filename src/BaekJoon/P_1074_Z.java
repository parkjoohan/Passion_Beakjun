package BaekJoon;

/*
import java.io.*;
import java.util.*;

public class Z_1074 {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 15
      int r = Integer.parseInt(st.nextToken()); // 0 ≤ r, c < 2^N
      int c = Integer.parseInt(st.nextToken());
      int rs = 0; // 해당 좌표가 포함된 사각영역의 시작좌표
      int cs = 0;
      int answer = 0;
      while(N > 0) {
         int side = 1 << (N-1); // 정사각형의 한 변 
//         Math.pow(2, N-1);
         int diff = side * side; // 정사각형
         if (r < rs+side && c < cs + side) { // 좌상
            
         } else if (r < rs+side && cs + side <= c) { // 우상
            answer += diff;
            cs += side;
         } else if (rs+side <= r && c < cs + side) { // 좌하
            answer += diff * 2;
            rs += side;
         } else if (rs+side <= r && cs + side <= c) { // 우하
            answer += diff * 3;
            rs += side; cs += side;
         } 
         N--;
      }
      System.out.println(answer);
   } // end of main
} // end of class
*/




import java.io.*;
import java.util.*;

public class P_1074_Z {
	static int p = 0;
	static int r;
	static int c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visit(0, 0, N);
	}

	static void visit(int row, int col, int cnt) {
		if (cnt == 0) {
			if (row == r && col == c) {
				System.out.println(p);
				return;
			}
			p++;
			return;
		}
		//가만있기
		if (r < row + (int) Math.pow(2, cnt - 1) && c < col + (int) Math.pow(2, cnt - 1)) {
			visit(row, col, cnt - 1);
			return;
		}
		//오른쪽네모로 넘어가기
		if (r < row + (int) Math.pow(2, cnt - 1) && c >= col + (int) Math.pow(2, cnt - 1)) {
			p+= (int)(Math.pow(2, cnt - 1)*Math.pow(2, cnt - 1))*1;
			visit(row, col + (int) Math.pow(2, cnt - 1), cnt - 1);
			return;
		}
		//아래네모로 넘어가기
		if (r >= row + (int) Math.pow(2, cnt - 1) && c < col + (int) Math.pow(2, cnt - 1)) {
			p+= (int)(Math.pow(2, cnt - 1)*Math.pow(2, cnt - 1))*2;
			visit(row + (int) Math.pow(2, cnt - 1), col, cnt - 1);
			return;
		}
		//오른아래네모로 넘어가기
		if (r >= row + (int) Math.pow(2, cnt - 1) && c >= col + (int) Math.pow(2, cnt - 1)) {
			p+= (int)(Math.pow(2, cnt - 1)*Math.pow(2, cnt - 1))*3;
			visit(row + (int) Math.pow(2, cnt - 1), col + (int) Math.pow(2, cnt - 1), cnt - 1);
			return;
		}
	}
}