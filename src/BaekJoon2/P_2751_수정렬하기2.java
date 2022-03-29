import java.io.*;
import java.util.*;

public class P_2751_수정렬하기2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		List<Integer>list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < T; i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}