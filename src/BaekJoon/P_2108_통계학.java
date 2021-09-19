package BaekJoon;

import java.util.*;

public class P_2108_통계학 {

	private static int[] count = new int[8001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
        	int num = sc.nextInt();
            count[num + 4000]++;
            numbers[i] = num;
        }

        System.out.println(avg(numbers));
        System.out.println(middle(numbers));
        System.out.println(mode());
        System.out.println(range(numbers));
    }

    private static int avg(int[] numbers) {
        int sum = 0;
        for(int value : numbers) {
            sum += value;
        }
        double round = (double) Math.round((double) sum / (double) numbers.length);
        return (int) round;
    }

    private static int middle(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length / 2];
    }

    private static int mode() {
        List<Integer> temp = new ArrayList<>();
        int max = count[0];
        temp.add(0 - 4000);
        for (int i = 1; i < count.length; i++) {
            if(count[i] == max) {
                temp.add(i - 4000);
            } else if(count[i] > max) {
                max = count[i];
                temp.clear();
                temp.add(i - 4000);
            }
        }

        if(temp.size() > 1) {
            Collections.sort(temp);
            return temp.get(1);
        }else {
            return temp.get(0);
        }
    }

    private static int range(int[] numbers) {
        return numbers[numbers.length - 1] - numbers[0];
    }

}