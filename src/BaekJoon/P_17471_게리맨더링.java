package BaekJoon;

import java.util.*;

public class P_17471_게리맨더링 {
    
    static int N, min=Integer.MAX_VALUE;
    static int[] people;    	// 구역 별 인구
    static boolean[] part;    	// true : 선거구 A, false : 선거구 B
    static int[][] link;    	// 간선 유무
    static ArrayList<Integer> a, b;
    static boolean[] visited;
 
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        people = new int[N+1];
        link = new int[N+1][N+1];
        part = new boolean[N+1];
        
        // 구역별 인구
        for(int i=1; i<=N; i++) {
            people[i] = sc.nextInt();
        }
        
        // 구열 별 간선 정보
        for(int i=1; i<=N; i++) {
            int num = sc.nextInt();
            for(int j=0; j<num; j++) {
                int temp = sc.nextInt();
                link[i][temp] = 1;
                link[temp][i] = 1;
            }
        }
        // 선거구 나누고 min값 찾고 0은 dummy니까 1구역부터 시작
        sub(1);
        
        // min값 변동 없을 경우 선거구를 나눌 수 없으므로 -1 출력
        if(min==Integer.MAX_VALUE)    
        	System.out.println(-1);
        else    
        	System.out.println(min);
        
    }
    
    static void sub(int idx) {
        
        if(idx == N+1) {
            a = new ArrayList<>();
            b = new ArrayList<>();
            visited = new boolean[N+1];
            
            // 선거구 나눠 넣기
            for(int i=1; i<=N; i++) {
                if(part[i])    a.add(i);
                else b.add(i);
            }
            
            // 한쪽으로 몰리면 선거구 나뉜 것 X
            if(a.size()==0 || b.size()==0)    
            	return;   
            
            // A, B 각 구역 내 이동 가능한지 확인 
            moveA(a.get(0));
            moveB(b.get(0));
            
            // min값 비교
            min = Math.min(min, gap());
            return;
        }
        
        part[idx] = true;
        sub(idx+1);
        part[idx] = false;
        sub(idx+1);
    }
    
    // 두 선거구의 인구 차이 계산
    static int gap() {
        // visited에 false가 있으면 각 구역 내 이동할 수 없다는 뜻이므로 선거구 유효 X
        for(int i=1; i<N+1; i++) {
            if(!visited[i])    return Integer.MAX_VALUE;
        }
        
        // 구역별 인구 수
        int sum_A=0, sum_B=0;
        for(int i=0; i<a.size(); i++) {
            sum_A += people[a.get(i)];
        }
        for(int i=0; i<b.size(); i++) {
            sum_B += people[b.get(i)];
        }
        
        // 인구 차이 
        return Math.abs(sum_A - sum_B);
    }
    
    // A구역 내 이동 가능 확인
    static void moveA(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int i=0; i<a.size(); i++) {
                if(link[tmp][a.get(i)] == 1 && !visited[a.get(i)]) {
                    queue.offer(a.get(i));
                    visited[a.get(i)] = true;
                }
            }
        }
    }
    
    // B구역 내 이동 가능 확인
    static void moveB(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int i=0; i<b.size(); i++) {
                if(link[tmp][b.get(i)] == 1 && !visited[b.get(i)]) {
                    queue.offer(b.get(i));
                    visited[b.get(i)] = true;
                }
            }
        }
    }

}