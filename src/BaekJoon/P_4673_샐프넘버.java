package BaekJoon;

public class P_4673_샐프넘버 {

	public static void main(String[] args) {
		int[] num = new int[10001];
		int cnt=1;
		int self=0;
		int i=0;
		
		while(cnt<10000) {
			self=cnt;
			i=cnt;
			
			while(i!=0) {
				self += i%10;
				i/=10;
			}
			if(self<10000) {
				num[self]++;
			}
			cnt++;
		}
		for (int j = 1; j <= 9999; j++) {
			if(num[j]==0)
				System.out.println(j);
		}
	}
}