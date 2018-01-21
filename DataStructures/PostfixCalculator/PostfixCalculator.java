import java.util.*;


public class PostfixCalculator{
  public static void main(String[] args) {
    System.out.println("Type your infix expression:");
    Scanner sc = new Scanner(System.in);
    String infix = sc.next();

    Converter c = new Converter(infix);

    String post = c.toPostFix();
    System.out.println("Converted to postfix: " + post);

    String [] postArray = post.split("");

    SinglyLinkedList s = new SinglyLinkedList();

    double temp = 0;

    for(int i = 0; i < postArray.length; i++){

      if(isDouble(postArray[i])){
        s.addLast(Double.parseDouble(postArray[i]));

      }
      else {
        if(postArray[i].equals("+")){
          temp = Double.parseDouble(s.last().toString());
          s.removeLast();
          temp += Double.parseDouble(s.last().toString());
          s.removeLast();
          s.addLast(temp);
        }
        if(postArray[i].equals("-")){
          temp = Double.parseDouble(s.last().toString());
          s.removeLast();
          temp = Double.parseDouble(s.last().toString()) - temp;
          s.removeLast();
          s.addLast(temp);
        }
        if(postArray[i].equals("*")){
          temp = Double.parseDouble(s.last().toString());
          s.removeLast();
          temp = temp * Double.parseDouble(s.last().toString());
          s.removeLast();
          s.addLast(temp);
        }
        if(postArray[i].equals("/")){
          temp = Double.parseDouble(s.last().toString());
          s.removeLast();
          temp = Double.parseDouble(s.last().toString()) / temp;
          s.removeLast();
          s.addLast(temp);
        }
        if(postArray[i].equals("^")){
          temp = Double.parseDouble(s.last().toString());
          s.removeLast();
          temp = Math.pow(Double.parseDouble(s.last().toString()), temp);
          s.removeLast();
          s.addLast(temp);
        }
      }
    }

    System.out.println("The answer is: " + s.last());
  }

  public static boolean isDouble(String s) {
      try {
          Double.parseDouble(s);
      } catch(NumberFormatException e) {
          return false;
      } catch(NullPointerException e) {
          return false;
      }
      // only got here if we didn't return false
      return true;
  }
}
