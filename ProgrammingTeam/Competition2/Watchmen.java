import java.util.*;

public class Watchmen{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();

    int[][] distances = new int[num][2];

    int same = 0;

    for(int i = 0; i < num; i++){
      distances[i][0] = sc.nextInt();
      distances[i][1] = sc.nextInt();
    }

    double dan = 0;
    double doc = 0;


    for(int i = 0; i < num - 1; i++){
      for(int j = i+1; j < num; j++){
        dan = Math.sqrt(Math.pow(distances[i][0] - distances[j][0],2) + Math.pow(distances[i][1] - distances[j][1],2));
        doc = Math.abs(distances[i][0] - distances[j][0]) + Math.abs(distances[i][1] - distances[j][1]);
        System.out.println(distances[i][0] +  " " + distances[i][1] + " " + distances[j][0] + " " + distances[j][1]);
        System.out.println(dan  + " " +doc + "@#@#$@#$");
        if(dan == doc){
          same++;
        }
      }
    }

    System.out.println(same);
  }

}
