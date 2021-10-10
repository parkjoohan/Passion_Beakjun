package BaekJoon;

import java.math.*; 
import java.util.*; 

public class P_1271_엄청난부자2 { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger(); 
        BigInteger m = sc.nextBigInteger(); 

        System.out.println(n.divide(m)); 
        System.out.println(n.remainder(m)); 
    } 
}