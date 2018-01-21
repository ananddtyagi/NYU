import java.util.*;
import java.io.*;

public class HuffmanConverter
{

// The # of chars in the ASCII table dictates
// the size of the count[] & code[] arrays.
    public static final int NUMBER_OF_CHARACTERS = 256;
    // the contents of our message...
    private static String contents;
    // the tree created from the msg
    private HuffmanTree huffmanTree;
    // tracks how often each character occurs
    private int count[];
    // the huffman code for each character
    private String code[];
    // stores the # of unique chars in contents
    private int uniqueChars = 0; //(optional)
    /** Constructor taking input String to be converted */
    public HuffmanNode [] nodes;

    public HuffmanConverter(String input)
    {
      this.contents = input;
      this.count = new int[NUMBER_OF_CHARACTERS];
      this.code = new String[NUMBER_OF_CHARACTERS];
    }
/**
* Records the frequencies that each character of our
* message occurs...
* I.e., we use 'contents' to fill up the count[] list...
*/
    public void recordFrequencies(){
      int counter = 0;
      for(int i = 0;  i < contents.length(); i++) {
          if(count[(int)contents.charAt(i)] == 0){
            uniqueChars++;
          }
          count[(int)contents.charAt(i)]++;
      }
    }
/**
* Converts our frequency list into a Huffman Tree. We do this by
* taking our count[] list of frequencies, and creating a binary
* heap in a manner similar to how a heap was made in HuffmanTree's
* fileToHeap method. Then, we print the heap, and make a call to
* HuffmanTree.heapToTree() method to get our much desired
* HuffmanTree object, which we store as huffmanTree.
*/
    public void frequenciesToTree(){

      nodes = new HuffmanNode[uniqueChars];

      for(int i = 0, j = 0; i < count.length; i++){
        if(count[i] != 0){
          nodes[j] = new HuffmanNode(Character.toString((char)i), (double)count[i]);
          j++;
        }
      }

      for(int i = 0; i < nodes.length; i++){
        System.out.print(nodes[i] + " ");
      }

      huffmanTree = HuffmanTree.createFromHeap(new BinaryHeap(nodes));

    }
/**
* Iterates over the huffmanTree to get the code for each letter.
* The code for letter i gets stored as code[i]... This method
* behaves similarly to HuffmanTree's printLegend() method...
* Warning: Don't forget to initialize each code[i] to ""
* BEFORE calling the recursive version of treeToCode...
*/
    public void treeToCode(){

      for(int i = 0; i < NUMBER_OF_CHARACTERS; i++){
        code[i] = "";
      }

      treeToCode(huffmanTree.root, "");

      System.out.println();
  }
/*
* A private method to iterate over a HuffmanNode t using s, which
* contains what we know of the HuffmanCode up to node t. This is
* called by treeToCode(), and resembles the recursive printLegend
* method in the HuffmanTree class. Note that when t is a leaf node,
* t's letter tells us which index i to access in code[], and tells
* us what to set code[i] to...
*/
    private void treeToCode(HuffmanNode t, String s){

      if(t.letter.length() > 1){
        treeToCode(t.left, s + "0");
        treeToCode(t.right, s + "1");
      } else {
        code[(int)t.letter.charAt(0)] = s;
      }


    }
/**
* Using the message stored in contents, and the huffman conversions
* stored in code[], we create the Huffman encoding for our message
* (a String of 0's and 1's), and return it...
*/
    public String encodeMessage(){
      StringBuilder sb = new StringBuilder();

      for(int i = 0; i < contents.length(); i++){
        sb.append(code[(int)contents.charAt(i)]);
      }


      return sb.toString();
    }
/**
* Reads in the contents of the file named filename and returns
* it as a String. The main method calls this method on args[0]...
*/
    public static String readContents(String filename) throws FileNotFoundException, IOException{
      InputStream is = new FileInputStream(filename);
      BufferedReader buf = new BufferedReader(new InputStreamReader(is));
      String line = buf.readLine();

      StringBuilder sb = new StringBuilder();
      while(line != null){
          sb.append(line).append("\n");
          line = buf.readLine();
        }

      return sb.toString();

    }
/**
* Using the encoded String argument, and the huffman codings,
* re-create the original message from our
* huffman encoding and return it...
*/
    public String decodeMessage(String encodedStr){
      String ans = "";

      HuffmanNode node = huffmanTree.root;

      for (int i = 0; i < encodedStr.length(); i++)
        {
        if (encodedStr.charAt(i) == '0'){
          node = node.left;
        } else {
          node = node.right;
        }

        // reached leaf node
        if (node.left == null && node.right == null)
        {
            ans += node.letter;
            node = huffmanTree.root;
        }
    }

    return ans;
  }


/**
* Uses args[0] as the filename, and reads in its contents. Then
* instantiates a HuffmanConverter object, using its methods to
* obtain our results and print the necessary output. Finally,
* decode the message and compare it to the input file.<p>
* NOTE: Example method provided below...
*
*/

    public static void main(String args[]) throws IOException
    {

      HuffmanConverter hc = new HuffmanConverter(readContents(args[0]));
      hc.recordFrequencies();
      hc.frequenciesToTree();
      hc.treeToCode();

      String encoded = hc.encodeMessage();

      hc.huffmanTree.printLegend();

      System.out.println("Huffman Encoding: ");
      System.out.println(encoded);

      System.out.println("Message size in ASCII encoding: " + hc.contents.length() * 8);
      System.out.println("Message size in Huffman coding: " + encoded.length());

      System.out.println(hc.decodeMessage(encoded));
    }

  }
