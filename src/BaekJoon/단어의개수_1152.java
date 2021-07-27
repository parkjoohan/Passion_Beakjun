package BaekJoon;
import java.util.*;

public class 단어의개수_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(s, " ");
		
		System.out.println(st.countTokens());	
	}
}
