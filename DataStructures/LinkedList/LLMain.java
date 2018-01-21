public class LLMain{

  public static void main(String[] args) {

      SinglyLinkedList<Integer> s1 = new SinglyLinkedList<Integer>();
      s1.addFirst(21);
      System.out.println(s1);
      s1.addLast(23);
      System.out.println(s1);
      s1.addLast(27);
      System.out.println(s1);
      s1.removeLast();
      System.out.println(s1);
      s1.removeLast();
      System.out.println(s1);
      s1.removeLast();
      System.out.println(s1);
      s1.removeLast();
      System.out.println(s1);

  }
}
