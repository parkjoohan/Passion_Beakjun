package BaekJoon;

import java.util.*;

public class P_1264_모음의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
        	String word = sc.nextLine();
        	int cnt = 0;
        	if(word.equals("#"))	break;
        	
        	for(int i=0;i<word.length();i++) {
        		if(word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u' || word.charAt(i)=='A' || word.charAt(i)=='E' || word.charAt(i)=='I' || word.charAt(i)=='O' || word.charAt(i)=='U')
        		cnt++;
        	}
        	System.out.println(cnt);
        }
	}
}