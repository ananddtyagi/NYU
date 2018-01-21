import java.util.*;

public class ETC{


    public static void main(String args[]) {

      while (true){


      System.out.println("Type your infix expression:");
        Scanner sc = new Scanner(System.in);
        String infix = sc.next();

        Converter c = new Converter(infix);

        String post = c.toPostFix();

        //PostFix expressions is stored in string post

        Node et = convert(post);
        System.out.print("Prefix: ");
        prefix(et);
        System.out.println();
        System.out.print("Infix: ");
        infix(et);
        System.out.println();
        System.out.print("Postfix: ");
        postfix(et);
        System.out.println();
      }

    }



public static Node convert(String post){
    char [] postChar = post.toCharArray();

    Tree t = new Tree();
    return t.build(postChar);
}

public static void prefix(Node et){

  if(et != null){
    System.out.print(et + " ");
    prefix(et.leftChild);
    prefix(et.rightChild);
  }

}

public static void infix(Node et){

  if(et != null){
    infix(et.leftChild);
    System.out.print(et + " ");
    infix(et.rightChild);
  }

}

public static void postfix(Node et){

  if(et != null){
    postfix(et.leftChild);
    postfix(et.rightChild);
    System.out.print(et + " ");
  }
}


}


class Node {

	public Object element;

	public Node leftChild;
	public Node rightChild;

	public Node (Object o) {
		this (o, null, null);
	}

	public Node (Object o, Node l, Node r) {
		element = o;
		leftChild = l;
		rightChild = r;
	}

	public String toString() {
		return element.toString();
	}
}


class Tree {

  private Node root;

  public Tree(){ root = null; }


  public Node build(char [] post){
    Stack<Node> stack = new Stack();

    for(int i = 0; i < post.length; i++){
      if(Character.isDigit(post[i])){
        stack.push(new Node(post[i]));
      } else {
        stack.push(new Node(post[i], stack.pop(), stack.pop()));
      }
    }

    root = stack.pop();

    return root;

  }
}
