public class FastMaxStack<E extends Comparable<E>> implements MaxStack<E> {

	private Node<E> top;
  private Node<E> maxVal;

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void push(E element) {
		top = new Node<E>(element, top);
    if(maxVal == null){
      maxVal = new Node<E>(element, null);
    } else {
      maxVal = new Node<E>(getMax(element, maxVal.getElement()), maxVal);
    }
	}

	@Override
	public E pop() {
		E element = top.getElement();
		top = top.getNext();
    maxVal = maxVal.getNext();
		return element;
	}

	@Override
	public E getMaxSoFar() {

    return maxVal.getElement();
	}

	//nolan added helper function
	private E getMax(E element1, E element2) {
		if(element1 == null)
			return element2;

		if(element2 == null)
			return element1;

		if(element1.compareTo(element2)>0)
			return element1;

		return element2;
	}
}
