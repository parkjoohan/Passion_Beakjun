package BaekJoon2;

import java.util.*;

// 같은 행에 두지 않는 방식
// N개의 퀸을 위협적이지 않게 놓는 모든 경우의 수
public class P_9663_NQueen {

	static int N, cnt;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		
		nQueen(1);		// 1행부터 두기
		System.out.println(cnt);
	}
	
	// 퀸 놓기
	public static void nQueen(int depth) {	// 몇번째에 놓는지 알아내기 위해 depth(행)을 매개변수로 둔다
		

		
		if(depth > N) {	// 모든 상황이 부합하여 마지막 행까지 둔 경우
			cnt++;		// 모든 상황이 부합되므로 횟수로 카운트
			return;
		}
		
		// 1열부터 N열까지 놓아보기
		// 놓았으면 다른 퀸 놓으러 가기
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;		// i열에 놓아보기
			// 유망여부 확인
			if(available(depth)) {
				nQueen(depth+1);	// 다음 행에 놓아보기
			}
		}
	}
		
	public static boolean available(int depth) {
		for (int i = 1; i < depth; i++) {	// i : 이전 퀸
			if(arr[depth] == arr[i]) {		// 현재 검사하고 싶은 퀸이 이전 퀸과 같은 열에 있는 경우 판단
				return false;				// 유망하지 않으면 return
			}
			
			// 대각선인 경우 판단 (i : 이전 퀸)
			else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {		
				return false;				// 유망하지 않으면 return
			}
		}
		return true;	// 위의 경우 해당하지 않으면 유망
	}
}