import java.util.*;

class BinaryHeap<E extends Comparable>
{
    /**
     * Construct the binary heap.
     */
    public BinaryHeap( )
    {
        this( DEFAULT_CAPACITY );
    }

    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    public BinaryHeap( int capacity )
    {
        currentSize  = 0;
        array = (E[]) new Comparable[ capacity + 1 ];
    }

    /**
     * Construct the binary heap given an array of items.
      */
      public BinaryHeap( E [ ] items )
      {
        currentSize = items.length;
        array = (E[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

        int i = 1;
        for( E item : items )
            array[ i++ ] = item;
        buildHeap( );
	}

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( E x )
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );

            // Percolate up
        int hole = ++currentSize;
        for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;


    }


    private void enlargeArray( int newSize )
    {
	E [] old = array;
		array = (E []) new Comparable[ newSize ];
		      for( int i = 0; i < old.length; i++ )
			       array[ i ] = old[ i ];
    }

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public E findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return array[ 1 ];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public E deleteMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );

        E minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
    }

    /**
    *  Print all items currently in the heap.
    */
    public void printHeap( )
    {
    		for( int i = 1; i <= currentSize; i++ )
    			System.out.print( array[ i ] );

    		System.out.println( );
    }

    private static final int DEFAULT_CAPACITY = 100;

    private int currentSize;      // Number of elements in heap
    private E [ ] array; // The heap array

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown( int hole )
    {
        int child;
        E tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    array[ child + 1 ].compareTo( array[ child ] ) < 0 )
                child++;
            if( array[ child ].compareTo( tmp ) < 0 )
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = tmp;
    }

    public int getSize(){
      return currentSize;
    }
}

class UnderflowException extends RuntimeException
{
}

class HuffmanNode implements Comparable
{
    public String letter;
    public Double frequency;
    public HuffmanNode left, right;

    public HuffmanNode(String letter, Double frequency)
    {
      this.letter = letter;
      this.frequency = frequency;
      left = null;
      right = null;
    }

    public HuffmanNode(HuffmanNode left, HuffmanNode right)
    {
      this.left = left;
      this.right = right;
      letter = left.letter + right.letter;
      frequency = left.frequency + right.frequency;
    }

    public int compareTo(Object o)
    {
      HuffmanNode huff = (HuffmanNode)o;
      return this.frequency.compareTo(huff.frequency);
    }

    public String toString()
    {
      if(letter.charAt(0) == '\n')
        return "<"+"\\n"+", "+frequency+">";
      return "<"+letter+", "+frequency+">";
    }
}

class HuffmanTree
{
    public HuffmanNode root;

    public HuffmanTree(HuffmanNode huff)
    {
      this.root = huff;
    }

    public void printLegend()
    {
       printLegend(root, "");

       System.out.println();

    }

    private void printLegend(HuffmanNode t, String s)
    {
      if(t.letter.length() > 1){
        printLegend(t.left, s + "0");
        printLegend(t.right, s + "1");
      } else {
        if(t.letter.charAt(0) == '\n'){
          System.out.print("'\\n' "+ "=" +s + " ");
        } else {
          System.out.print("'" + t.letter+ "' =" + s + " ");
        }
      }

    }

    public static BinaryHeap legendToHeap(String legend)
    {
      String [] values = legend.split("\\s+");

      HuffmanNode [] nodes = new HuffmanNode[(values.length / 2)];

      int j = 0;

      for (int i = 0; i < nodes.length; i++){
        nodes[i] = new HuffmanNode(values[j], Double.parseDouble(values[j+1]));
        j+=2;
      }

      return new BinaryHeap(nodes);

    }

    public static HuffmanTree createFromHeap(BinaryHeap b)
    {
      while(b.getSize() > 1){
        b.insert(new HuffmanNode((HuffmanNode)b.deleteMin(), (HuffmanNode)b.deleteMin()));
      }


      return new HuffmanTree((HuffmanNode)b.deleteMin());
    }

    public static void main(String[] args)
    {
      BinaryHeap bheap = legendToHeap("A 20 E 24 G 3 H 4 I 17 L 6 N 5 O 10 S 8 V 1 W 2");
      bheap.printHeap();
      HuffmanTree htree = createFromHeap(bheap);
      htree.printLegend();

    }
}
