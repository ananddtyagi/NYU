import java.util.*;

public class Word{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String word = s.next();

    int lowercase = 0;
    int uppercase = 0;
    for(int i = 0; i < word.length(); i++){
      if((int)word.charAt(i) >= 97){
        lowercase++;
      } else {
        uppercase++;
      }
    }

    if(uppercase > lowercase){
      System.out.println(word.toUpperCase());
    } else {
      System.out.println(word.toLowerCase());
    }
  }
}
