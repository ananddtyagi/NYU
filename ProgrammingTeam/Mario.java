import java.util.*;

public class Main{
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int numCases = sc.nextInt();

            int [][] cases = new int [numCases][2];


            for(int i = 0; i < numCases; i++){
              int highs = 0;
              int lows = 0;
              int numH = sc.nextInt();
              int [] h = new int[numH];
              for(int j = 0; j < numH; j++){
                h[j] = sc.nextInt();
              }

              for(int k = 0; k < numH - 1; k++){
                if(h[k] < h[k+1]){
                  highs++;
                } else if(h[k] > h[k+1]) {
                  lows++;
                }
              }

              cases[i][0] = highs;
              cases[i][1] = lows;

            }

            for(int i = 1; i <= numCases; i++){
              System.out.println("Case " + i + ": " + cases[i-1][0] + " " + cases[i-1][1] ) ;
            }
      }
}
