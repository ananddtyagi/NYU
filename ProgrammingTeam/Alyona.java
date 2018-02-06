import java.util.*;

public class Main{
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int count = 0;

    for(int x = 1; x <= n; x++){
      int mod = x % 5;
      count += ((m - (5-mod)) / 5) + 1;
    }

    System.out.println(count);

  }
}
