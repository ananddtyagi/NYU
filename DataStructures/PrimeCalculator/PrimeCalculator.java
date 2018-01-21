import java.util.*;

public class PrimeCalculator{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter upper bound");

    int input = sc.nextInt();

    if(input < 2){
      throw new java.lang.Error("Input must be a number greater than 2");
    } else {
    Sieve s = new Sieve();
    s.primesTo(input);
  }

  }
}
