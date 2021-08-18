package BaekJoon;

import java.util.*;

public class DFS와BFS_1260 {
 
    static int n, m, v;
    static boolean [] visits;
    static int [][] map;
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);        
        n = sc.nextInt(); //4
        m = sc.nextInt(); //5
        v = sc.nextInt(); //1
        visits = new boolean [n+1];
        map = new int [n+1][n+1];
        
        for(int i=1; i<=m; i++) {
            int temp1 = sc.nextInt(); //1
            int temp2 = sc.nextInt(); //2
            map[temp1][temp2] = 1;
            map[temp2][temp1] = 1;
        }        
        dfs(v); //1   
        System.out.println();        
        visits = new boolean [n+1];       
        bfs(v); //1
    }
    
    private static void dfs(int start) {
        visits[start] = true; //visits[1] = true
        System.out.print(start + " ");
        for(int i=1; i<=n; i++) {
            if (map[i][start] == 1 && visits[i]==false) {
                dfs(i);
            }
        }
    }
    
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start); // 1 
        while(!q.isEmpty()) {
            int out = q.poll();
            visits[out] = true;
            System.out.print(out + " ");
            for(int i=1; i<=n; i++) {
                if (map[i][out] == 1 && visits[i] == false && i!=out) { // 2 3 4 
                    q.offer(i);
                    visits[i] = true;
//                    System.out.println(Arrays.toString(q.toArray()));
                }
            }       
        }
    }
}
