package BST_A2;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 * 
*/

	  
  public static void main(String[]args){
	  BST tree = new BST();
	  

	  p(tree.size);
	  p(tree.insert("meta"));
	  p(tree.size);
	  p(tree.insert("nano"));
	  p(tree.insert("llana"));
	  p(tree.insert("pascal"));
	  p(tree.size);
	  p(tree.insert("nano"));
	  p(tree.size);
	  p(tree.insert("car"));
	  p(tree.insert("bing"));
	  p(tree.insert("google"));
	  p(tree.insert("cat"));
	  p(tree.insert("apple"));
	  p(tree.insert("portal"));
	  p(tree.insert("ny"));
	  p(tree.insert("zed"));
	  p(tree.insert("zzz"));
	  p(tree.size);
	  p("----------------");

	  printLevelOrder(tree);
	  
	  //p(henry.remove("meta"));
	  printLevelOrder(tree);
	  tree.remove("pascal");
	  printLevelOrder(tree);
	  tree.remove("car");
	  printLevelOrder(tree);
	  tree.remove("bing");
	  printLevelOrder(tree);
	  tree.remove("google");
	  printLevelOrder(tree);
	  tree.remove("apple");
	  printLevelOrder(tree);
	  tree.remove("portal");
	  printLevelOrder(tree);
	  tree.remove("cat");
	  printLevelOrder(tree);
	  p(tree.size);

	  p(tree.insert("meta"));
	  p(tree.insert("nano"));
	  p(tree.insert("llana"));
	  p(tree.insert("pascal"));
	  p(tree.insert("nano"));
	  p(tree.insert("car"));
	  p(tree.insert("bing"));
	  p(tree.insert("google"));
	  p(tree.insert("cat"));
	  p(tree.insert("apple"));
	  p(tree.insert("portal"));
	  p(tree.insert("ny"));
	  p(tree.insert("zed"));
	  p(tree.insert("zzz"));
	  p("----------------");
	  printTree(tree);
	  p(tree.size);

	  
	  printTree(tree);
	  tree.remove("ny");
	  printTree(tree);
	  tree.remove("zed");
	  printTree(tree);
	  tree.remove("zzz");
	  printTree(tree);
	  tree.remove("meta");
	  printTree(tree);
	  tree.remove("llana");
	  printTree(tree);
	  tree.remove("nano");
	  printTree(tree);
	  p(tree.size);
	  

	  p(tree.insert("portal"));
	  p(tree.insert("cat"));
	  p(tree.insert("apple"));
	  p(tree.insert("google"));

	  
	  printLevelOrder(tree);
	  tree.remove("pascal");
	  p(tree.size);
	  
	  p("---------------");
	  
	  printTree(tree);
	  p("---------------");
	  tree.remove("car");
	  p("---------------");
	  printTree(tree);
	  p("---------------");
	  
	  p(tree.size);
	  printLevelOrder(tree);
	  tree.remove("bing");
	  p(tree.size);
	  printLevelOrder(tree);

	  p(tree.size);
	  printTree(tree);
	  p(tree.remove("google"));
	  p(tree.remove("google"));
	  printLevelOrder(tree);
	  p(tree.size);
	  
	  tree.remove("apple");
	  printTree(tree);
	  p(tree.size);
	  tree.remove("portal");
	  printTree(tree);
	  p(tree.size);
	  tree.remove("cat");
	  printTree(tree);
	  p(tree.size);
	  
	  //for(int i =)
	  //p(MyRandom.nextString(3,7));
	  
	  //printTree(root);
	  //p(root.removeNode("meta"));
	  //p(root.insertNode("meta"));
	  //printTree(root);
	        


	  

	  
	  //System.out.println(root.removeNode("pizza"));
	  //System.out.println(root.right.right.right);
	  

	        
	  
	  //b.compareTo(a)>0 --> b is greater than a
	  
	  
   // you should test your BST implementation in here
   // it is up to you to test it thoroughly and make sure
   // the methods behave as requested above in the interface
  
   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print tree method
   // feel free to use the printLevelOrder method to verify your trees manually
   // or write one you like better
   // you may wish to print not only the node value, and indicators of what
   // nodes are the left and right subtree roots,
   // but also which node is the parent of the current node
 
  }
  static void removeAndPrintLevelOrder(String s){
	  
  }
  //quick print method
  static void p(Object x){
	  System.out.println(x);
  }
  static void printTree(BST tree){
	 printTree(tree.root);
  }
  static void printTree(BST_Node root){
	  
	  if(root!=null){
		  System.out.println(root);
		  if(root.left!=null)
			  printTree(root.left);
		  if(root.right!=null)
			  printTree(root.right);
	  }
	  else
		  System.out.println("null tree");



  }
  
  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order...
  //https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.getRoot().getHeight();
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    p("");
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
}