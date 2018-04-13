package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

  public boolean insert(String s) {
	  if(root == null){
		  root = new BST_Node(s);
		  size++;
		  return true;
	  }
	  
	  if(root.insertNode(s)==false){
		  return false;		  
	  }
	  else{
		  size++;
		  return true;
	  }
	  
  }

  public boolean remove(String s) {
	  if(root.right == null && root.left == null){
		  if(root.data.equals(s)){
			  root = null;
			  size--;
			  return true;
		  }
		  else{
			  return false;
		  }
		  
	  }
	  if (root.removeNode(s)==true){
		  size--;
		  return true;
	  }
	  else{
		  return false;
	  }
  }  

  public String findMin() {return root.findMin().data;}

  public String findMax() {return root.findMax().data;}

  public boolean empty() {return size==0;}

  public boolean contains(String s) {
	  if(root ==null){
		  return false;
	  }
	  
	  return root.containsNode(s);
	  }

  public int size() {return size;}

  public int height() {
	  if(root ==null){
		  return -1;
	  }
	  return root.getHeight();
	  }
}