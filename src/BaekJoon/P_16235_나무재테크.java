package BaekJoon;

import java.util.*;

public class P_16235_나무재테크 {
    static int N, M, K;
    static int[][] food, map;
    static PriorityQueue<Tree> q;
    static Queue<Tree> live, dead;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();       
        M = sc.nextInt();        
        K = sc.nextInt();        
        
        food = new int[N + 1][N + 1];            
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                food[i][j] = sc.nextInt();
            }
        }
        
        q = new PriorityQueue<Tree>();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();          // 심은 나무의 x좌표
            int y = sc.nextInt();           // 심은 나무의 y좌표
            int age = sc.nextInt();           // 심은 나무의 나이
            q.add(new Tree(x, y, age));
        }
        
        // 처음 양분 초기화
        map = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = 5;
            }
        }
        live = new LinkedList<Tree>();        // 생존 나무  
        dead = new LinkedList<Tree>();        // 죽은 나무 
        
        while (K-- > 0) {
            spring(); summer(); fall(); winter();   
        }
        int answer = q.size();
        System.out.println(answer);
    }
    
    // 봄(양분 먹고 생존 or 죽음)
    private static void spring() {
        while (!q.isEmpty()) {
            Tree tree = q.poll();
            int x = tree.x;
            int y = tree.y;
            int age = tree.age;
            // 나무가 나이만큼 양분 먹고, 나이 한살 증가한다. 
            if (age <= map[x][y]) {
                map[x][y] -= age; 
                age += 1;
                live.add(new Tree(x, y, age));
            }
            // 양분 부족으로 나이만큼 양분 먹지 못하면 죽음
            else {
                // 죽은 나무 따로 추가
                dead.add(new Tree(x, y, age));
            }
        }
    }
    
    // 여름 (죽은 나무 양분 전환)
    private static void summer() {
        while (!dead.isEmpty()) {
            Tree tree = dead.poll();
            int x = tree.x;
            int y = tree.y;
            int age = tree.age;
            // 죽은 나무 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가
            int addfood = age / 2;
            map[x][y] += addfood;  
        } 
    }
    
    // 가을 (나무 번식)
    private static void fall() {
        while (!live.isEmpty()) {
            Tree tree = live.poll();
            int x = tree.x;
            int y = tree.y;
            int age = tree.age;
            // 번식하는 나무 나이는 5의 배수. 인접한 8개의 칸에 한살 나무 생성
            if (age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int X = x + dx[i];
                    int Y = y + dy[i];
                    // 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
                    if (1 <= X && X <= N && 1 <= Y && Y <= N) {
                        q.add(new Tree(X, Y, 1));
                    } 
                }
            }   
            q.add(new Tree(x, y, age));
        }
    }
    
    // 겨울 (로봇 양분 추가)
    private static void winter() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                map[i][j] += food[i][j];
            }
        }
    }
    
    static class Tree implements Comparable<Tree> {
        int x, y, age;
        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    } 
}