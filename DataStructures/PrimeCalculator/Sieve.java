import java.util.*;

public class Sieve{

  public Sieve(){}


  public void primesTo(int n){
    LinkedQueue<Integer> numbers = new LinkedQueue<>();
    for(int i = 2; i <= n; i++){ numbers.enqueue(i); }

    LinkedQueue<Integer> primes = new LinkedQueue<>();

    for(int p = numbers.first(); p <= Math.sqrt(n); p++){

      primes.enqueue(numbers.first());

      int s = numbers.size();
      int f = numbers.first();
      for(int i = 0; i < s; i++){
        if(numbers.first() % f == 0){
          numbers.dequeue();

        } else {
          numbers.enqueue(numbers.dequeue());
        }

      }
    }

  while(!numbers.isEmpty()){ primes.enqueue(numbers.dequeue());}

  StringBuilder sb = new StringBuilder("The primes up to " + n + " are: ");

  while (!primes.isEmpty()) {
    sb.append(primes.dequeue());
    if (!(primes.size() == 0))
      sb.append(", ");
  }
  System.out.println(sb);

}
}
