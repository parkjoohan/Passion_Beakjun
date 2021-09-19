package BaekJoon;

import java.util.*;

public class P_1181_단어정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		// 문자열 배열에 데이터 저장
		String[] arr = new String[N];
		
	    for(int i =0;i<arr.length;i++) { 
	    	arr[i] = sc.next();
	    }
	    
	    // 문자열 배열 행을 기준으로 정렬
	    Arrays.sort(arr, new Comparator<String>() { 
	    	public int compare(String o1, String o2) { 
	    		// 두 문자열의 길이가 같은 경우는
				if(o1.length() == o2.length()) { 
					// 사전 순으로 정렬
					return o1.compareTo(o2); 
				}			
				// 그 외에는 문자열들의 길이로 비교
				else { 
					return Integer.compare(o1.length(),o2.length());
				}
			}
	    });
	    
	    // 중복을 고려해 출력하기 위해 첫 번째 문자열은 출력
	    System.out.println(arr[0]);
	    // 1번 인덱스부터 이전 인덱스와 비교해 출력하기 때문에 위의 처리는 문제X
	    for(int i=1;i<arr.length;i++) { 
	    	// 같은 문자열이라면 건너뛰고
	    	if(arr[i-1].equals(arr[i])) 
	    		continue; 
	    	// 문자열 출력
	    	System.out.println(arr[i]); 
	    }
	}
}