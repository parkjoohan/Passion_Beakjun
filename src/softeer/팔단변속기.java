package softeer;

import java.util.*;

public class 팔단변속기 {
	static int[] asc = {1,2,3,4,5,6,7,8};
    static int[] dsc = {8,7,6,5,4,3,2,1};
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];

        for(int i=0; i<8; i++)  arr[i] = sc.nextInt();

        if(check(asc, arr))
            System.out.print("ascending");
        else if(check(dsc, arr))
            System.out.print("descending");
        else        
            System.out.print("mixed");
    }

    public static boolean check(int[] arr1, int[] arr2) {
        for(int i=0; i<8; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}