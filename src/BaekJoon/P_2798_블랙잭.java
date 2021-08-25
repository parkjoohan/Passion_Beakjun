package BaekJoon;

/*import java.util.*;

public class P_2798_블랙잭 {

	static int N, M;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 카드 수
		M = sc.nextInt();	// 최대 합 
		num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		int max=0;
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					int sum = num[i] + num[j] + num[k];
					
					if(sum<=M && sum>max)
						max = sum;
				}
			}
		}
		System.out.println(max);
	}
}*/

/*//조합 풀이
import java.util.*;


public class P_2798_블랙잭 {
	static int N;	//카드 수
	static int M;	// 최대값
	static int[] arr;
	static int[] numbers; // 조합
	static int sum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 카드 수
		M = sc.nextInt(); // 최대값
		arr = new int[N];
		numbers = new int[3];
		

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		search(0,0);
		System.out.println(sum);
	}
	
	static void search(int cnt, int start) {
		if(cnt == 3){
			int tmp = 0;
			for(int i=0; i<3; i++) {
				tmp += numbers[i];
			}
			if(tmp<=M)
				sum = Math.max(tmp, sum);
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = arr[i];
			search(cnt+1, i+1);
		}
	}
}*/