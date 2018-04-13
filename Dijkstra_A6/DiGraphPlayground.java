package A6_Dijkstra;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
    exTest();
    }
  public static void ln(String s){
	  System.out.println(s);
  }
  public static void ln(boolean s){
	  System.out.println(s);
  }
  public static void ln(Object s){
	  System.out.println(s.toString());
  }
    public static void exTest(){
      DiGraph d = new DiGraph();
      
      d.addNode(0, "a");
      d.addNode(1, "b");
      d.addNode(2, "c");
      d.addNode(3, "d");
      d.addNode(4, "e");
      d.addEdge(0, "a", "b", 1, null);
      d.addEdge(1, "b", "c", 1, null);
      d.addEdge(2, "a", "c", 3, null);
      d.addEdge(3, "c", "d", 2, null);
      d.addEdge(4, "c", "e", 5, null);
      d.addEdge(5, "b", "d", 2, null);
      d.addEdge(6, "d", "e", 3, null);
      d.addEdge(7, "b", "e", 7, null);
      d.addEdge(8, "a", "e", 9, null);
      d.addEdge(9, "a", "d", 5, null);
      s(d.shortestPath("a"));
      
    }
    public static void s(ShortestPathInfo[] path){
    	for(ShortestPathInfo p : path){
    		System.out.println(p);
    	}
    }
    public static void printTOPO(String[] toPrint){
      System.out.print("TOPO Sort: ");
      for (String string : toPrint) {
      System.out.print(string+" ");
    }
      System.out.println();
    }

}