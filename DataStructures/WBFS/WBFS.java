
import java.util.*;

class BinaryTree {

	private static class TreeNode<AnyType> implements Comparable<TreeNode>
	{
		public AnyType element;
		public TreeNode left;
		public TreeNode right;
    public int distance;

		public TreeNode (AnyType o)
		{
			this (o, null, null, 0);
		}

		public TreeNode (AnyType o, TreeNode l, TreeNode r, int d)
		{
			element = o;
			left = l;
			right = r;
      distance = d;
		}

    public TreeNode(AnyType o, int d){
      element = o;
      distance = d;
    }
		public String toString()
		{
			return "" + element;
		}

    public void setChildren(TreeNode l, TreeNode r){
      left = l;
      right = r;
    }

    public int compareTo(TreeNode node){
      if(this.distance > node.distance){
        return 1;
      } else {
        return 0;
      }
    }

	}

	public BinaryTree(String input){
		String temp = "";
		LinkedStack<TreeNode> stack = new LinkedStack<TreeNode>();
    TreeNode left_node, right_node, parent;


		String [] values = input.split(" ");

    for(int i = 0; i < values.length; i++){
      temp = values[i];

			if(temp.equals("(") || temp.equals("\"")){

			}
      else if(temp.equals(")")){
        left_node = stack.pop();
        right_node = stack.pop();
        parent = stack.pop();
        parent.setChildren(left_node, right_node);
        stack.push(parent);
      }
      else {
				i++;
        stack.push(new TreeNode(temp, Integer.valueOf(values[i])));
      }
  	}

		BinaryTree tree = new BinaryTree((TreeNode)stack.pop());
		//System.out.println("SDFS" + tree.left);

    System.out.println(tree.breadthFirstSearch("*"));

	}

	private TreeNode root;

	public BinaryTree( TreeNode root )
	{
		this.root = root;
	}

	public TreeNode breadthFirstSearch( Object target ){

		TreeNode b;
		BinaryHeap bheap = new BinaryHeap();
		bheap.insert(b);

		while(!bheap.isEmpty())
		{
			b = (TreeNode)bheap.findMin();

			while(b.element.equals(target) && b != null){
				if(b.left.compareTo(b.right) == 0){
					bheap.insert(b.left);
					bheap.insert(b.right);
				} else {
					bheap.insert(b.right);
					bheap.insert(b.left);
				}
			}
		}
		return null;
	}




}

class ListNode
{
		// Constructors
	ListNode( Object theElement )
	{
		this( theElement, null );
	}

	ListNode( Object theElement, ListNode n )
	{
		element = theElement;
		next	= n;
	}

		// Friendly data; accessible by other package routines
	Object   element;
	ListNode next;
}

class QueueLi
{
	/**
	 * Construct the queue.
	 */
	public QueueLi( )
	{
		makeEmpty();
	}

	/**
	 * Test if the queue is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty( )
	{
		return front == null;
	}

	/**
	 * Test if the queue is logically full.
	 * @return true if full, false otherwise.
	 */
	public boolean isFull( )
	{
		return false;
	}


	/**
	 * Make the queue logically empty.
	 */
	public void makeEmpty( )
	{
		front = null;
		back  = null;
	}

	/**
	 * Get the least recently inserted item in the queue.
	 * Does not alter the queue.
	 * @return the least recently inserted item in the queue, or null, if empty.
	 */
	public Object getFront( )
	{
		if( isEmpty( ) )
			return null;
		return front.element;
	}

	/**
	 * Return and remove the least recently inserted item from the queue.
	 * @return the least recently inserted item in the queue, or null, if empty.
	 */
	public Object dequeue( )
	{
		if( isEmpty( ) )
			return null;

		Object frontItem = front.element;
		front = front.next;
		if (front == null)
			back = null;
		return frontItem;
	}


	/**
	 * Insert a new item into the queue.
	 * @param x the item to insert.
	 * @exception Overflow if queue is full.
	 */
	public void enqueue( Object x )
	{
		ListNode newNode = new ListNode (x);
		if (isEmpty ())
			front = newNode;
		else
	 		back.next = newNode;
		back = newNode;

	}

	private ListNode	front;
	private ListNode	back;

	public static void main( String [ ] args )
	{
		QueueLi q = new QueueLi( );

		for( int i = 0; i < 10; i++ )
			q.enqueue( new Integer( i ) );

		while( !q.isEmpty( ) )
			System.out.println( q.dequeue( ) );

	}
}

class LinkedStack<E> implements Stack<E> {

  /** The primary storage for elements of the stack */
  private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty list

  /** Constructs an initially empty stack. */
  public LinkedStack() { }                   // new stack relies on the initially empty list

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */
  @Override
  public int size() { return list.size(); }

  /**
   * Tests whether the stack is empty.
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() { return list.isEmpty(); }

  /**
   * Inserts an element at the top of the stack.
   * @param element   the element to be inserted
   */
  @Override
  public void push(E element) { list.addFirst(element); }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * @return top element in the stack (or null if empty)
   */
  @Override
  public E top() { return list.first(); }

  /**
   * Removes and returns the top element from the stack.
   * @return element removed (or null if empty)
   */
  @Override
  public E pop() { return list.removeFirst(); }

  /** Produces a string representation of the contents of the stack.
   *  (ordered from top to bottom)
   *
   * This exists for debugging purposes only.
   *
   * @return textual representation of the stack
   */
  public String toString() {
    return list.toString();
  }
}


public class WBFS{
  public static void main(String[] args) {

		BinaryTree readInput = new BinaryTree(args[0]);


    }
}
