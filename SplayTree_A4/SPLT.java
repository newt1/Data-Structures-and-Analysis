package SPLT_A4;

public class SPLT implements SPLT_Interface{
  private BST_Node root;
  private int size;
  
  public SPLT() {
    this.size = 0;
  } 
  
  public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
    return root;
  }
    
  /* Links Parent to left child and links child to parent
   * Check that parent's parent is not child
   */
  private void linkL(BST_Node P, BST_Node C){
	  P.left = C;
	  if(C==null) {
		  return;
	  }	  
	  	C.parent = P;	  		  
  }
  
  /* Links Parent to right child and links child to parent
   * Check that parent's parent is not child
   */
  private void linkR(BST_Node P, BST_Node C){
	  P.right = C;
	  if(C==null) {
		  return;
	  }	  
	  	C.parent = P;			  
  }
  
  
  private void splay(String s){
	  BST_Node C = root; //current
	  BST_Node P, G, N;
	  P = G = N = null;
	  
	  if(root==null)return;
	  //iterative find of String s
	  while(C.data.compareTo(s)!=0){
	  if(C.data.compareTo(s)>0){//s lexiconically less than data
		  if(C.left==null){
			  s = C.data;
		  }
		  else{
			  C = C.left;
		  }
		}
		if(C.data.compareTo(s)<0){
			if(C.right==null){
				  s = C.data;
			}
			else{
				C = C.right;
			}
		}		
	  }	  
	  
	  P = C.parent;
	  if(P!=null) G = P.parent;
	  if(G!=null) N = G.parent;	  	  
	  while(P!=null){		  
		  if(G == null){//zig
			  if(P.left == C){
				  linkL(P,C.right);
				  linkR(C,P);
			  }
			  else{
				  linkR(P,C.left);
				  linkL(C,P);
			  }
			  
		  }		  
		  else if((G.left == P && P.left == C)||(G.right == P && P.right == C)){ //zig zig

			  if(P.left == C){		
				  linkL(P,C.right);
				  linkR(C,P);
				  
				  linkL(G,P.right);
				  linkR(P,G);
			  }
			  else{
				  linkR(P,C.left);
				  linkL(C,P);
				  
				  linkR(G,P.left);
				  linkL(P,G);
			  }
		  }		  
		  else{ //zig zag

			  if(P.left == C){	
				  linkL(P,C.right);
				  linkR(C,P);

				  linkR(G, C.left);
				  linkL(C,G);
			  }
			  else{		  	  
				  linkR(P,C.left);
				  linkL(C,P);
				  
				  linkL(G,C.right);
				  linkR(C,G);
			  }
		  }
		  C.parent = null;
		  if(N!=null){
			  if(C.data.compareTo(N.data)>0){
				  linkR(N,C);
			  }
			  else{
				  linkL(N,C);
			  }
		  }		  
		  //reset
		  G = N = null;
		  P = C.parent;
		  if(P!=null) G = P.parent;
		  if(G!=null) N = G.parent;
	  }
	  root = C;
  }
    
  
@Override
public void insert(String s) {
	if(root==null){
		root=new BST_Node(s);
		size++;		
		return;
	}
	if(root.insertNode(s)){
		size++;	
	}	
	splay(s);
	
}

@Override
public void remove(String s) {
	if(root==null) {
		return;
	}
	if(size==1 && root.data.equals(s)){
		root=null;
		size--;
		return;
	}
	contains(s);
	if(root.data.compareTo(s)==0){

			BST_Node right = root.right;
			
			if(root.left!=null){
				root.left.parent = null; //root is root.left
				root = root.left;
				findMax();		

				if(right!=null){	
				root.right = right;
				right.parent = root;
				}
				
			}
			else{
				root = root.right;
				root.parent = null;
			}

		
		size--;
	}
	
}

@Override
public String findMin() {
	if(root==null)return null;
	String min = root.findMin().data;
	splay(min);
	return min;
}

@Override
public String findMax() {
	if(root==null)return null;
	String max = root.findMax().data;
	splay(max);
	return max;
}

@Override
public boolean empty() {
	return size == 0;
}

@Override
public boolean contains(String s) {
	if(empty())return false;
	boolean found = root.containsNode(s);
	splay(s);
	return found;
}

@Override
public int size() {
	return size;
}

@Override
public int height() {
	if(root==null)return -1;
	return root.getHeight();
}  

}