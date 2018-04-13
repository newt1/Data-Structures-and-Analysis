/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedListA0;

public class LinkedListImpl implements LIST_Interface {
  Node root;//this will be the entry point to your linked list (the head)
  int size = 0;
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    root=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return root;
  }
  
  
  
  public boolean insert(Node n, int index){
	  
	  //check for valid index
	  if(index<0||index>size){
		  return false;
	  }	  
	  
	  
	  if(index == 0){
		  if(root.next!=null){
			  n.next = get(index);
		  }
		  root.next = n;
	  }
	  else{
		  n.next = get(index);
		  get(index-1).next = n;
	  }

	  size++;
	  return true;
  }
  public boolean remove(int index){
	  if(index<0||index>=size){
		  return false;
	  }
	  
	  if(index == 0){
		  if(size>1){
			  root.next = get(index+1);
		  }
		  else if(size==1){
			  size = 0;
		  }
	  }
	  else{
		  get(index-1).next = get(index+1);
	  }
	  
	  
	  size--;
	  return true;
  }
  public Node get(int index){
	  Node p = root;
	  if(index<size && index>=0){
		  for(int i = -1; i < index; i++){
			  p = p.next;
		  }
		  return p;
	  }
	  else{
		  return null;
	  }
  }
  public int size(){
	  return size;	  
  }
  public boolean isEmpty(){
	  return(size==0);
  }
  public void clear(){
	  root.next = null;
	  size = 0;
  }
}
