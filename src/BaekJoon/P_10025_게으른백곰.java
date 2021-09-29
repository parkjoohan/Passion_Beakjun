package BaekJoon;

import java.util.*;

public class P_10025_게으른백곰 {
	
	static int N, K;
	static Node[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new Node[N];
		
		for (int i = 0; i < N; i++) {
			int g = sc.nextInt();
			int x = sc.nextInt();
			arr[i] = new Node(x, g);
		}
		Arrays.sort(arr, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.xi-o2.xi;
			}
		});
	}
	
	
	static class Node {
		int xi; int gi;
		public Node(int xi, int gi) {
			this.xi=xi;
			this.gi=gi;
		}
	}
}
