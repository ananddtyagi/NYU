public class LLHomeworkFunctions {


		public static void main(String [] args) {

		//getIntersection

		Node<Integer> list1 = new Node<Integer>(2, null);
		Node<Integer> head1 = list1;
		list1.setNext(new Node<Integer> (3, null));
		list1 = list1.getNext();

		list1.setNext(new Node<Integer> (6, null));
		list1 = list1.getNext();


		Node<Integer> list2 = new Node<Integer>(3, null);
		Node<Integer> head2 = list2;
		list2.setNext(new Node<Integer> (6, null));
		list2 = list2.getNext();
		list2.setNext(new Node<Integer> (9, null));
		list2 = list2.getNext();


		Node<Integer> intersection = getIntersection(head1, head2);
		System.out.println("getIntersection:");
		printOut(intersection);
		System.out.println("NULL");


		//terminates
		Node<Integer> node1 = new Node<Integer>(1, null);
		Node<Integer> node2 = new Node<Integer>(2, null);
		Node<Integer> node3 = new Node<Integer>(3, null);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node1); //comment this out to see how the program performs with a terminating list.

		System.out.println("terminates:");
		if(terminates(node1)){
			printOut(node1);
			System.out.println("NULL");
		} else {
			printOut(node1);
			System.out.print("(points back to the first node) ");
			printOut(node1);
			printOut(node1);
			System.out.println("etc");
		}
		System.out.println(terminates(node1));


		//FastMaxStack 
		System.out.println("FastMaxStack:");
		FastMaxStack<Integer> fast = new FastMaxStack<Integer>();
		SlowMaxStack<Integer> slow = new SlowMaxStack<Integer>();

		fast.push(1);
		slow.push(1);
		fast.push(4);
		slow.push(4);
		fast.push(2);
		slow.push(2);
		fast.push(9);
		slow.push(9);
		System.out.println("Fast Max Val So Far: " + fast.getMaxSoFar());
		System.out.println("Slow Max Val So Far: " + slow.getMaxSoFar());
		fast.pop();
		slow.pop();
		System.out.println("Fast Max Val So Far: " + fast.getMaxSoFar());
		System.out.println("Slow Max Val So Far: " + slow.getMaxSoFar());
	}

	/**
	 * @param <E>
	 * @param list1
	 * @param list2
	 * @return a list of nodes with elements that appear in both list1 and list2. null if there are none.
	 */

	static public <E> Node<E> getIntersection(Node<E> list1, Node<E> list2) {

		Node<E> newList = new Node<E>(null, null);
		Node<E> headNL = newList;
		Node<E> headL2 = list2;
		while(list1 != null){
			while(list2 != null){
				if(list1.getElement() == list2.getElement()){

					newList.setNext(new Node<E> (list1.getElement(), null));
					if(headNL == null){
						headNL = new Node<E>(list1.getElement(), null);
					}
					newList = newList.getNext();

				}

				list2 = list2.getNext();

			}
				list1 = list1.getNext();
				list2 = headL2;
		}
		return headNL.getNext();
	}

	/**
	 * @param <E>
	 * @param list1
	 * @return true if the list eventually terminates, and false if the list points back at one of it's
	 *  previous nodes.
	 */
	static public <E> boolean terminates(Node<E> list) {
		boolean term = true;
		Node<E> head = list;
		while(list != null && term != false){

			list = list.getNext();
			if(list == head){
				term = false;
			}
		}
		return term;
	}

	static public <E> void printOut(Node<E> list){
		boolean term = true;
		Node<E> head = list;
		while(list != null && term != false){
			System.out.print(list.getElement() + " -> ");

			list = list.getNext();
			if(list == head){
				term = false;
			}
		}


	}
}
