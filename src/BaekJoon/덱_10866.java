package BaekJoon;

import java.util.*;
import java.io.*;

public class 덱_10866 {

	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			String s = sc.next();
			
			switch(s) {
			case "push_front":{
				deque.addFirst(sc.nextInt());
				break;
			}
			case "push_back":{
				deque.addLast(sc.nextInt());
				break;
			}
			case "pop_front":{
				
				break;
			}
			case "pop_back":{
				
				break;
			}
			case "size":{
				
				break;
			}
			case "empty":{
				
				break;
			}
			case "front":{
				
				break;
			}
			case "back":{
				
				break;
			}
			}
		}

	}

}
