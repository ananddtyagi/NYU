public class LLHomeworkFunctions {

	static public void main(String [] args) {
    Node<Integer> s1 = new Node<Integer>();
    s1.addFirst(21);
    System.out.println(s1);
    s1.addLast(23);
    System.out.println(s1);
    s1.addLast(27);
    System.out.println(s1);
    System.out.println(s1.insertBefore(27, 45));
    System.out.println(s1);

    Node<Integer> s2 = new Node<Integer>();

    s1.addFirst(31);
    System.out.println(s1);
    s1.addLast(23);
    System.out.println(s1);
    s1.addLast(97);
    System.out.println(s1);
    s1.addLast(20);
    System.out.println(s1);


    System.out.println(getIntersection(s1.getHead(), s2.getHead()));
	}

	/**
	 * @param <E>
	 * @param list1
	 * @param list2
	 * @return a list of nodes with elements that appear in both list1 and list2. null if there are none.
	 */
	static public <E> Node<E> getIntersection(Node<E> list1, Node<E> list2) {
    SinglyLinkedList<E> intersection = new SinglyLinkedList<E>();
    while(list1.getElement() != null){
      while(list2.getElement() != null){
        if(list1.getElement().equals(list2.getElement())){
          intersection.addLast(list2.getElement());
        }
      }
    }
    return intersection;
	}

	/**
	 * @param <E>
	 * @param list1
	 * @return true if the list eventually terminates, and false if the list points back at one of it's
	 *  previous nodes.
	 */
	static public <E> boolean terminates(Node<E> list) {
		return true;
	}

}
