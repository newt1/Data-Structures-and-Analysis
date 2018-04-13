package A6_Dijkstra;

public class MinBinHeap implements Heap_Interface {
	  private EntryPair[] array; //load this array
	  private int size;
	  private static final int arraySize = 10000; //Everything in the array will initially 
	                                              //be null. This is ok! Just build out 
	                                              //from array[1]

	  public MinBinHeap() {
	    this.array = new EntryPair[arraySize];
	    array[0] = new EntryPair(-100000,null); //0th will be unused for simplicity 
	                                             //of child/parent computations...
	                                             //the book/animation page both do this.
	  }
	    
	  //Please do not remove or modify this method! Used to test your entire Heap.
	  @Override
	  public EntryPair[] getHeap() { 
	    return this.array;
	  }

	@Override
	public void insert(EntryPair entry) {
		if(size==0){
			array[1] = entry;
			size = 1;
			return;
		}		
		//no check for duplicates
		size++;				
		array[size] = entry;
		
		int child = size;
		int parent = getParent(child);
		
		while(array[parent].priority > array[child].priority){
			swap(parent, child);
			child = parent;
			parent = getParent(child);
		}		
	}

	
	@Override
	public void delMin() {
		if(size ==0){
			return;
		}
		swap(1,size);
		array[size] = null;
		size--;
		
		int parent = 1;
		
		//heapify reverse
		while((parent*2) <= size){
			int child = getLeftChild(parent);//left child
			
			
			if(child+1>size){//one child only
				if(array[parent].priority > array[child].priority){
					swap(parent, child);
				}
				parent = child;
				
			}
			else{
				int leastPriorityChild;
				 if(array[child].priority > array[child+1].priority){	
					 leastPriorityChild = child+1;
				 }
				 else
				 {
					 leastPriorityChild = child;
				 }
				 if(array[parent].priority > array[leastPriorityChild].priority){
						swap(parent, leastPriorityChild);
					}
				parent = leastPriorityChild;
			}
		}
	}
	
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public EntryPair getMin() {
		if(size==0){
			return null;
		}
		return array[1];
	}
	

	  private void s(int s){for(int i = 0; i<s; i++){p(" ");}}
	  private  void p(String p){System.out.print(p);}
	  private  void p(int p){System.out.print(Integer.toString(p));}
	  private  void ln(String p){System.out.println(p);}
	  private  void ln(int p){System.out.println(Integer.toString(p));}
	  private void rj(String p, int length){
		  for(int i = 0; i<(length - p.length());i++){
			  System.out.print(" ");
		  }
		  System.out.print(p);
	  }
	  private void rj(int p, int length){rj(Integer.toString(p),length);}
	  private void rjln(String p, int length){rj(p,length);ln("");}
	  private void rjln(int p, int length){rj(p,length);ln("");}
	  private void p(boolean p){p(p?"T":"F");}
	  private void ln(boolean p){p(p);ln("");}
	  private void printNode(EntryPair node){
		  
		  rjln("("+node.node.getLabel()+","+node.priority+")\t", 8);
	  }

	@Override
	public void build(EntryPair[] entries) {
		
		//start with bottom subtree move up
		//put entries into array;
		array[0] = null;
		size = entries.length;
		for(int i = 0; i<entries.length; i++){
			array[i+1] = entries[i];	
			
		}

		if(entries.length==1){
			return;
		}
		
		int child = size;
		//child is rightmost element of tree
		//iterate left
		
		
		if(child%2==0){
			int parent = getParent(child);
			if(array[parent].priority > array[child].priority){
				swap(parent, child);
			}	
		}

		//heapify reverse
		while(child > 1){
			int parent = getParent(child);
			
				int leastPriorityChild;
				 if(array[child].priority > array[child-1].priority){	
					 leastPriorityChild = child-1;
				 }
				 else
				 {
					 leastPriorityChild = child;
				 }
				 if(array[parent].priority > array[leastPriorityChild].priority){
						swap(parent, leastPriorityChild);
						
						
						int newParent = 1;
						
						//heapify reverse
						while((newParent*2) <= size){
							int newChild = getLeftChild(newParent);//left child
							
							
							if(newChild+1>size){//one child only
								if(array[newParent].priority > array[newChild].priority){
									swap(newParent, newChild);
									newParent = newChild;
								}
								
							}
							else{
								int newLeastPriorityChild;
								 if(array[newChild].priority > array[newChild+1].priority){	
									 newLeastPriorityChild = newChild+1;
								 }
								 else
								 {
									 newLeastPriorityChild = newChild;
								 }
								 if(array[newParent].priority > array[newLeastPriorityChild].priority){
										swap(newParent, newLeastPriorityChild);
									}
								newParent = newLeastPriorityChild;
							}
						}
						
						
					}
				 ln("");
			child -= 2;
		}
	}
	
		/*
		//heapify
		while(child > 1){
			int parent = getParent(child);
			if(child % 2 == 0 && (child + 1) > size){
				if(array[parent].priority > array[child].priority){
					swap(parent, child);
				}
				child--;
			}
			else{
				int leastPriorityChild;
				 if(array[child].priority > array[child-1].priority){	
					 leastPriorityChild = child-1;
				 }
				 else
				 {
					 leastPriorityChild = child;
				 }
				 if(array[parent].priority > array[leastPriorityChild].priority){
						swap(parent, leastPriorityChild);
					}
				child -= 2;
			}
		}		*/
		

	private int getLevel(int right){
		return((int)(Math.log(right)/Math.log(2)));	
		
	}
	
	private boolean hasLeft(int right){
		return(getLevel(getLeft(right))==getLevel(right));
	}

	private int getLeftMost(int right){
		return((int)(Math.pow(2, (int)(Math.log(right)/Math.log(2)))));			
	}
	
	private int getRight(int left){
		if(array[left+1]==null){
			System.out.println("error trying to access null value");
		}
		return left+1;
	}
	
	private int getLeft(int right){
		if(right==1){
			System.out.println("error trying to access postion 0");
		}
		return right-1;
	}
	
	
	

	private void swap(int p1, int p2){ 
		EntryPair temp;
		temp = new EntryPair(array[p1].priority,array[p1].node);
		array[p1] = new EntryPair(array[p2].priority,array[p2].node);
		array[p2] = temp;		
	}
	
	
	private int getParent(int child){			
		return child/2;
	}

	private int getLeftChild(int parent){			
		return parent*2;
	}
	

	private int getRightChild(int parent){			
		return parent*2+1;
	}

	
	}