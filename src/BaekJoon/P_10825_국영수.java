package BaekJoon;

import java.io.*;
import java.util.*;

/*public class P_10825_국영수 {
   public static class Student implements Comparable<Student>{
      String name;
      int kor;
      int eng;
      int math;
      
      Student(String name, int kor, int eng, int math){
         this.name = name;
         this.kor = kor;
         this.eng = eng;
         this.math = math;
      }

      @Override
      public int compareTo(Student o) {
         if(this.kor < o.kor) {
            return 1;
         } else if(this.kor == o.kor) {
            if(this.eng > o.eng) {
               return 1;
            } else if(this.eng == o.eng) {
               if(this.math < o.math) {
                  return 1;
               } else if(this.math == o.math) {
                  if(this.name.compareTo(o.name) > 0) {
                     return 1;
                  }
               }
            }
         }
         return -1;
      }
   }
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      List<Student> li = new ArrayList<Student>();

      for(int i = 0; i < N; i++) {
         String[] str = br.readLine().split(" ");
         String name = str[0];
         int kor = Integer.parseInt(str[1]);
         int eng = Integer.parseInt(str[2]);
         int math = Integer.parseInt(str[3]);
         li.add(new Student(name, kor, eng, math));
      }
      
      Collections.sort(li);
      for(int i = 0; i < li.size(); i++) {
         System.out.println(li.get(i).name);
      }
   }
}*/

public class P_10825_국영수 {
	 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][4];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split(" ");
        }
        
        //Comparator 사용
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
                    if (Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])) {
                        if (Integer.parseInt(s1[3]) == Integer.parseInt(s2[3])) {
                            
                            //국영수 점수가 같다면 사전 오름차순
                            return s1[0].compareTo(s2[0]);
                        }
        
                        //국어점수 같고 영어점수 같을 때, 수학 점수는 내림차순
                        return Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3]));
 
                    }
                    //국어 점수 같을 때, 영어 점수는 오름차순
                    return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));
                }
                //국어점수는 내림차순
                return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1]));
            }
 
        });
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0]);
 
        }
    }
}