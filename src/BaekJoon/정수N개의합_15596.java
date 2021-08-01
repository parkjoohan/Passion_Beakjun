package BaekJoon;

public class 정수N개의합_15596 {
	long sum(int[] a) {
		long sum = 0;
	
		for(int i = 0; i<a.length; i++)
			sum += a[i];
		
		return sum;
	}
}