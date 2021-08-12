package BaekJoon;


// 부분집합_ver1
/*import java.util.*;

public class 일곱난쟁이_2309 {

	static boolean[] check;
	static int sum=0, cnt=0;
	static int[] arr;
	static int[] result = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		check = new boolean[arr.length];
		
		for(int i=0; i<9; i++)
			arr[i] = sc.nextInt();
		
		powerSet(0);
	}
	
	static void powerSet(int idx) {
		// 9명 모두 뽑았을 때
		if(idx == arr.length) {
			// 7명의 합이 100일때
			if(cnt==7 && sum==100) {
				int num=0;
				for(int j=0; j<9; j++) {
					if(check[j]) {
						// 결과 배열에 조건에 맞는 난쟁이 정보 넣기
						result[num] = arr[j];
						num++;
					}
				}
				// 순서 정렬
				Arrays.sort(result);
				
				for(int i=0; i<7; i++)
					System.out.println(result[i]);
				System.exit(0);
			}
			return;
		}
		check[idx] = true;
		sum += arr[idx];
		cnt++;
		powerSet(idx+1);
		check[idx] = false;
		sum -= arr[idx];
		cnt--;
		powerSet(idx+1);
	}
}*/



//부분집합_ver2
/*import java.util.*;
 
public class 일곱난쟁이_2309 {
 
    static int people[] = new int[9];
    static int right_people[] = new int[7];
    static boolean check = false;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        // 난쟁이들의 키 입력
        for (int i = 0; i < 9; i++) 
        	people[i] = sc.nextInt();
        
        process(0, 0, 0);
    }

    //idx : 난쟁이의 위치, cnt : 뽑은 난쟁이의 수, sum : 뽑힌 난쟁이들 키의 합
    public static void process(int idx, int cnt, int sum) {
        // 키의 합이 100인 일곱 난쟁이가 다 뽑힌 상태면 더이상 경우의 수를 확인할 필요가 없으므로 return
        if(check) 
        	return;
        // 일곱 난쟁이가 뽑히면
        if(cnt == 7) {
            // 키의 합이 100이 되는지 확인
            if(sum == 100) {
                // 키의 합이 100이라면 난쟁이들의 키를 오름차순으로 정렬 후 출력
                Arrays.sort(right_people);
                for (int i = 0; i < 7; i++) 
                    System.out.println(right_people[i]);
                check = true;
            }
            return;
        }
        if(idx >= 9) 
        	return;
        // 일곱 난쟁이가 뽑히기도 전에 키의 합이 100을 초과하면 return
        if(sum > 100) 
        	return;
    
        right_people[cnt] = people[idx];
        process(idx + 1, cnt + 1, sum + people[idx]);
        process(idx + 1, cnt, sum);
    }   
}*/



//비트마스크 
import java.util.*;
 
public class 일곱난쟁이_2309 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        
        for(int i=0; i<9; i++)
            arr[i] = sc.nextInt();
        // 오름차순 출력을 위해 미리 정렬해두기
        Arrays.sort(arr);
        
        for(int i=0; i<(1 << 9); i++) {
            int sum = 0;
            // bit(1) 개수가 7개일 경우
            if(Integer.bitCount(i)==7) {
                for(int j=0; j<9; j++) {
                    //j만큼 1을 이동하여 i와 and 연산 결과가 1이라면(0보다 크다면)
                    if((1 << j&i) > 0) 
                    	sum+=arr[j];
                }
                if(sum==100) {
                    for(int j=0; j<9; j++) 
                        if((1<<j&i)>0) 
                        	System.out.println(arr[j]);
                    break;
                }
            }
        }
    }
}