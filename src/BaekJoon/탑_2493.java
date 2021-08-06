package BaekJoon;

/*import java.util.*;
import java.io.*;

public class 탑_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<int[]> s = new Stack<>();
		
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(st.nextToken());
			// 스택이 비어있지 않고 앞선 수가 뒤에 들어오는 수보다 작을 때
			// 앞선 수를 빼낸다
			if(!s.isEmpty() && s.peek()[0] < N)
				s.pop();
			// 스택이 비어있다면 0 출력
			if(s.isEmpty())
				System.out.print("0 ");
			// 스택이 비어있지 않다면 
			else
				System.out.print(s.peek()[1]+" ");
			// 첫번째 입력되는 수는 0이 츨력되기 위해 push는 마지막에 진행
			s.push(new int[] {N, i});
		}
	}
}*/

import java.io.*;
import java.util.*;

public class 탑_2493 {
    //기억이 없다는 것은.. 내 신호를 받아줄 녀석이 없다는거다. break
    //마지막 기지국이 나보다 크면 그놈이 나의 정답이다. break
    //마지막 기지국이 나보다 작으면 지워버린다.
    //왼쪽을 매번 헤매면서 보지 않기 위해서 새로운 기지국을 만날때마다 기억한다.
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> heightStack = new Stack<Integer>();
        Stack<Integer> numStack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while(true) {
                //기억이 없으면 0이 정답.
                if(heightStack.isEmpty()) {
                    sb.append(0).append(" ");
                    break;
                }
                //나보다 큰 놈이 있으면 그놈의 번호가 정답.
                else if(heightStack.peek() >= num) {
                    sb.append(numStack.peek()).append(" ");
                    break;
                }
                //나보다 작으면 갖다버려
                else {
                    heightStack.pop();
                    numStack.pop();
                }
            }
            //방금 만난 기지국을 기억시킨다.
            numStack.push(i);
            heightStack.push(num);
        }
        System.out.println(sb);
    }
}

