import java.util.*;
public class Converter{

  public String infix;
  public List<String> parsed;

  public Converter(){ infix = ""; parsed = null; }

  public Converter(String infix){
    this.infix = infix.replaceAll("\\s+","");
    ParserHelper pH = new ParserHelper();
    parsed = pH.parse(infix.toCharArray());


  }

  public String toPostFix() {
    SinglyLinkedList s = new SinglyLinkedList();
    StringBuilder sb = new StringBuilder("");

    for(int i = 0; i < parsed.size(); i++){
      if(isInteger(parsed.get(i))){
        sb.append(parsed.get(i));

      } else {
        if(s.isEmpty()){
          s.addLast(parsed.get(i));
        } else if (parsed.get(i).equals("(")){

            s.addLast(parsed.get(i));

        } else if (parsed.get(i).equals(")")){

          while(!(s.last().equals("("))){

            sb.append(s.last());
            s.removeLast();

          }
          s.removeLast();
        } else if (parsed.get(i).equals("^")){
          s.addLast(parsed.get(i));
        } else if ((parsed.get(i).equals("*") || parsed.get(i).equals("/"))){
            if(s.last().equals("^")){
              while(s.last().equals("^")){
                sb.append(s.last());
                s.removeLast();
              }
            }
            s.addLast(parsed.get(i));

        } else if ((parsed.get(i).toString().equals("+") || parsed.get(i).equals("-"))) {
          while(!(s.last().equals("+") || s.last().equals("-") || s.last().equals("("))){
              sb.append(s.last());
              s.removeLast();
          }
          s.addLast(parsed.get(i));
        }
      }
    }

    while(!s.isEmpty()){
      sb.append(s.last());
      s.removeLast();
    }

  return sb.toString();
}


  public static boolean isInteger(String s) {
      try {
          Integer.parseInt(s);
      } catch(NumberFormatException e) {
          return false;
      } catch(NullPointerException e) {
          return false;
      }
      // only got here if we didn't return false
      return true;
  }
}
