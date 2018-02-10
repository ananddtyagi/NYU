import java.util.*;

public class HelpfulMaths{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.next().replace("+", "");

    int [] numbers = new int [input.length()];

    for(int i = 0; i < input.length(); i++){
      numbers[i] = Character.getNumericValue(input.charAt(i));
    }

    Arrays.sort(numbers);

    String output = "";

    if(numbers.length == 1){
      output += numbers[0];
    } else {
      output += numbers[0];
      for(int i = 1; i < numbers.length; i++){
        output += "+" + numbers[i];
      }
    }

    System.out.println(output);

  }
}
