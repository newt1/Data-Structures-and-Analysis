

package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  BST_Node parent;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }
  public BST_Node getParent(){ return parent; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  public boolean containsNode(String s){ 	 
	  if(s.equals(data)){
		  return true;
	  }
	  else
	  {
		  
		  return((s.compareTo(data)>0)?
				  (right==null ? false : right.containsNode(s)):
			  (left==null ? false : left.containsNode(s)));	
	  }
  }
  
  /**
   * 
   * @param s
   * @return
   */
  public boolean insertNode(String s){ 
	  if(s.equals(data)){
		  return false;
		  }
	  else{
		  if(s.compareTo(data)>0){
			  if(right==null){
				  right = new BST_Node(s);
				  right.parent = this;
				  return true;
			  }
			  return(right.insertNode(s));
		  }
		  else{
			  if(left==null){
				  left = new BST_Node(s);
				  left.parent = this;
				  return true;
			  }
			  	return(left.insertNode(s));
		  	  }
	  	}
	  }
	  
  
  public boolean removeNode(String s){ 	  
	  if(s.equals(data)==false){
		  boolean moveRight = (s.compareTo(data)>0);
		  
		  if((moveRight && right==null) || (!moveRight && left == null)){
			  return false;
		  }
		  else{
			  return(moveRight?right.removeNode(s):left.removeNode(s));
		  }
	  }	   
	  
	  else{
		  //case 2, 1 and only 1 null
		  if((right == null || left == null) && !(right == null && left == null))
		  {
			  BST_Node host = (right==null?left:right);//host is the node to be overtaken by the deleted parasite node
			  this.data = host.data;
			  this.right = host.right;
			  this.left = host.left; 
			  return true;
		  }
		  else if(right!=null && left!=null){
			  data = right.findMin().data;
			  left.parent = this;
			  right.parent = this;
			  right.removeNode(data);	 
			  return true;
		  }	
		  //case 1 if(left==null && right==null)
		  else {
				  if(parent.data.compareTo(data)>0){
					  parent.left = null;			  
				  }
				  else{
					  parent.right = null;			  
				  }
				  return true;			  
		  		}
	  		}
  		}
  
  /* the minimum value is found be traveling left until left  is null then return this
   * implemented recursively
   */
  public BST_Node findMin(){ 
		  if(left==null){
			  return this;
		  }
		  return (left.findMin());
	  }
  
  /* the maximum value is found be traveling right until right  is null then return this
   * implemented recursively
   */
  public BST_Node findMax(){ 
		  if(right==null){
			  return this;
		  }
		  return (right.findMax());
	  }
  
  public int getHeight(){
	  //if left or right is null then return -1
	  int leftHeight = (left==null ? -1 : left.getHeight());
	  int rightHeight = (right==null ? -1 : right.getHeight());
	  //recursively add 1 
	  return(1 + (leftHeight > rightHeight ? leftHeight : rightHeight));
  }
	  
  
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null")+", Parent: "+((this.parent!=null)?parent.data:"null");
  }
}