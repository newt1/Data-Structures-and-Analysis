package SPLT_A4;

import java.util.Scanner;

public class SPLT_Playground {
  public static void main(String[] args){
    genTest();
  }
  
  public static void genTest(){
    SPLT tree = new SPLT();
    
    String input = "";
    String s = "%";
    Scanner scanner = new Scanner(System.in);
    boolean b;
    int size;
    BST_Node root;
    
    while(!(input.equals("exit")||input.equals("\\"))){
	    System.out.print("enter operation and string: ");
	    input = scanner.next();
	    switch (input) {	  
	    case "c": 
	    case "r":  
	    case "i": 
	    case "ins":
        case "insert":  
        case "rem":  
        case "remove":     
        case "con":  
        case "contains":   	
	    	s = scanner.next();
                 break;
	    }
	    
	    switch (input) {	    
	    case "p":      
	    case "print":  
        	printTree(tree);
                 break;    
	    case "i":  
	    case "ins":
        case "insert":  
        	if(s.equals("g")){
        		tree.insert(s);
        	}
        	else {
        		tree.insert(s);
        	}
        	printTree(tree);
                 break;
        case "r":  
        case "rem":  
        case "remove":
        	tree.remove(s);
        	printTree(tree);        	
                 break;
        case "c":  
        case "con":  
        case "contains": 
        	b = tree.contains(s);  
        	String f = b ? "found" : "not found";
        	System.out.println("String " + s + " " + f);
        	printTree(tree);        	
                 break;
        case "x": 
        case "max": 
        case "findMax": 
        	System.out.println("Max " + tree.findMax());
        	printTree(tree);
                 break;
        case "m": 
        case "min": 
        case "findMin": 
        	System.out.println("Min " + tree.findMin());   
        	printTree(tree);     
                 break;
        case "s": 
        case "size": 
        	size = tree.size();
        	System.out.println("Size " + tree.size());
                 break;
        case "e": 
        case "empty": 
        case "emp": 
        	b = tree.empty();
        	String e = b ? "empty" : "not empty";
        	System.out.println(e);
                 break;
        case "h": 
        case "height":  
        case "hei": 
        	size = tree.height();
        	System.out.println("Height " + size);
                 break;
        case "t":  
        case "root":  
        case "getRoot": 
        	root = tree.getRoot();
        	if(root!=null)
        	System.out.println("Root " + root.getData());
                 break;
        case "b":  
        case "blank":  
        	int l = tree.size();
        	for(int i = 0; i < l; i++){
        		tree.remove(tree.findMin());
        	}
        	System.out.println("Cleared tree");  
        	printTree(tree);     
                 break;
        case "\\":
        case "exit":
        	break;
        default: 
        	System.out.println("Retry\n------");
                 break;
    }
    }
    
    /*
    tree.insert("world");
    tree.insert("my");
    tree.insert("name");
    tree.insert("is");
    tree.insert("blank");
    //tree.remove("hello");
    System.out.println("size is "+tree.size());
    
    printLevelOrder(tree);
    */
  }

  static void printTree(BST tree){
	//will print your current tree in Level-Order...
	    //https://en.wikipedia.org/wiki/Tree_traversal
	      int h=tree.getRoot().getHeight();
	      for(int i=0;i<=h;i++){
	        System.out.print("Level "+i+":");
	        printGivenLevel(tree.getRoot(), i);
	        System.out.println();
	      }
  }
  
  static void printTree(SPLT tree){
	//will print your current tree in Level-Order...
	    //https://en.wikipedia.org/wiki/Tree_traversal
	      int h=tree.height();
	      for(int i=0;i<=h;i++){
	        System.out.print("Level "+i+":");
	        printGivenLevel(tree.getRoot(), i);
	        System.out.println();
	      }
  }

    static void printLevelOrder(SPLT tree){ 
    //will print your current tree in Level-Order...
    //https://en.wikipedia.org/wiki/Tree_traversal
      int h=tree.getRoot().getHeight();
      for(int i=0;i<=h;i++){
        System.out.print("Level "+i+":");
        printGivenLevel(tree.getRoot(), i);
        System.out.println();
      }
      
    }
    static void printGivenLevel(BST_Node root,int level){
      if(root==null){
    	  System.out.print("-- ");
    	  return;
      }
      if(level==0)System.out.print(root.data+" ");
      else if(level>0){
        printGivenLevel(root.left,level-1);
        printGivenLevel(root.right,level-1);
      }
    }
  
}