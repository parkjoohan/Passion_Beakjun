package BaekJoon;

import java.io.*; 
import java.util.*; 

/*public class P_7795_먹을것인가먹힐것인가 {
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		int T = Integer.parseInt(br.readLine()); 
		while (T-->0){ StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray(); 
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray(); 
		
		int count = 0; 
		
		for (int i : A) 
			for (int j :  B) { 
				if (i<=j) 
					break; 
				else 
					count ++; 
			} 
			sb.append(count+"\n"); 
		} 
		System.out.print(sb); 
	}   
}*/
 
public class P_7795_먹을것인가먹힐것인가 {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			int cnt = 0;
			
			str = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(str[i]);
			}
			str = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(str[i]);
			}
					
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			
			// start를 차롇대로 증가시키며 반복
			for(int i : arr1) {
				for (int j : arr2) {
					if(i>j) {
						cnt++; 
					}
					else {
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}