package MinBinHeap_A3;

import java.util.Random;

public class MinBinHeap_Playground {
    public static MinBinHeap mbh= new MinBinHeap();
    public static EntryPair[] collection= new EntryPair[8];
    public static EntryPair[] collectionCalvin = new EntryPair[17];
	  public static void main(String[] args){   
		  Random generator = new Random(10);
		  
		  int x =0;
		  while(x<collectionCalvin.length){
			  
			  collectionCalvin[x] = new EntryPair(getRandomString(),(int)(generator.nextDouble()*40));
			  x++;
		  }

	    //Add more tests as methods and call them here!!
	    TestBuild();
	  }
	  
	  public static String getRandomString(){
		  int asci = (int)(Math.random()*26)+97;
		  char a = (char) asci;		  
		   asci = (int)(Math.random()*26)+97;
		  char b = (char) asci;		  
		   asci = (int)(Math.random()*26)+97;
		  char c = (char) asci;		  
		  return (String.valueOf(a)+String.valueOf(b));
	  }
	  
	  public static void TestInsert(){
		  ln(mbh.size());
		  for(int i = 1; i<=200;i+=20){
		  mbh.insert(new EntryPair("x",i));
		  }
		    printHeap(mbh.getHeap(), mbh.size());
		  ln(mbh.size());
		  
		  for(int i = 1; i<=10;i++){
		  mbh.delMin();
		    printHeap(mbh.getHeap(), mbh.size());
		  }
		  ln(mbh.size());
		  
		  
	  }
	  
		  /*
		  while(x<((int)(Math.pow(2, 30)))){
	    x*=2;
	    rj(x, 10);
	    s(2);
	    y = x + (int)(Math.random()*x);
	    rj(getLeft(y), 10);
	    ps(2);
	    pln(x==getLeft(y));
		  }*/
		  /*
		  MinBinHeap testHeap = new MinBinHeap();
		  
		  while(x<17){
			  rj(x,2);
			  s(2);
		  rjln(testHeap.getLevel(x),2);
		  
		  x++;
		  }*/
	  
	  


		/**
		 * 
		 */
	  
		public static int getLeftMost(int right){
			return((int)(Math.pow(2, (int)(Math.log(right)/Math.log(2)))));			
		}
		
		public int getRight(int left){
			return left+1;
		}
		
		public static int getParent(int child){			
			return child/2;
		}

		public static int getLeftChild(int parent){			
			return parent*2;
		}
		

		public static int getRightChild(int parent){			
			return parent*2+1;
		}
		
	  public static void s(int s){for(int i = 0; i<s; i++){p(" ");}}
	  public static void p(String p){System.out.print(p);}
	  public static void p(int p){System.out.print(Integer.toString(p));}
	  public static void ln(String p){System.out.println(p);}
	  public static void ln(int p){System.out.println(Integer.toString(p));}
	  public static void rj(String p, int length){
		  for(int i = 0; i<(length - p.length());i++){
			  System.out.print(" ");
		  }
		  System.out.print(p);
	  }
	  public static void rj(int p, int length){rj(Integer.toString(p),length);}
	  public static void rjln(String p, int length){rj(p,length);ln("");}
	  public static void rjln(int p, int length){rj(p,length);ln("");}
	  public static void p(boolean p){p(p?"T":"F");}
	  public static void ln(boolean p){p(p);ln("");}
	  
	  public static void TestDelMin(){
		  mbh.delMin();
		    printHeap(mbh.getHeap(), mbh.size());
	  }
	  
	  public static void TestBuild(){ 
	    // constructs a new minbinheap, constructs an array of EntryPair, 
	    // passes it into build function. Then print collection and heap.
		    printHeapCollection(collectionCalvin);
	    mbh.build(collectionCalvin);	    
	    printHeap(mbh.getHeap(), mbh.size());
	  }
	  
	  public static void printNode(EntryPair node){
		  
		  p("("+node.value+","+node.priority+")\t");
	  }
	  
	  public static void printHeapCollection(EntryPair[] e) { 
	    //this will print the entirety of an array of entry pairs you will pass 
	    //to your build function.
	    System.out.println("Printing Collection to pass in to build function:");
	    for(int i=0;i < e.length;i++){
		      p(i);
	      System.out.print("("+e[i].value+","+e[i].priority+")\t");
	    }
	    System.out.print("\n");
	  }
	  
	  public static void printHeap(EntryPair[] e,int len) { 
	    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
	    System.out.println("Printing Heap");
	    int counter =1;
	    for(int i=1;i < len+1;i++){
	    	if(i==counter){
	    		ln("");
	    		counter*=2;
	    	}
	    			
	      System.out.print("("+e[i].value+","+e[i].priority+")\t");
	      
	    }
	    System.out.print("\n");
	  }
	}