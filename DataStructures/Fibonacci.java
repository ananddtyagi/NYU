import java.util.*;

public class Fibonacci{
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      double x = s.nextDouble();
      System.out.println(fibonacci(x, 1, 1));
    }

    public static double fibonacci(double x, double one, double two){

      if(x > 1){
        x--;
        return fibonacci(x, two, one + two);
      } else {
        return one;
      }

    }
//highest value this can handle is 1476

}
