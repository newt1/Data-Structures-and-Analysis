package A6_Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class DiGraph implements DiGraph_Interface {
	//connects Node labels with the Node object
	Map<String, Node> nodeMap;
	
	ArrayList<Long> nodeIDs;
	ArrayList<Long> edgeIDs;
	
	
	// in here go all your data and methods for the graph
	// and the topo sort operation
	
	public DiGraph ( ) { // default constructor
	// explicitly include this
	// we need to have the default constructor
	// if you then write others, this one will still be there
		nodeIDs = new ArrayList<>();
		edgeIDs = new ArrayList<>();
		nodeMap = new HashMap<>();
	}
	
	/*
	shortestPath:
	      in: string label for start vertex
	      return: array of ShortestPathInfo objects (ShortestPathInfo)
	              length of this array should be numNodes (as you will put in all shortest 
	              paths including from source to itself)
	              See ShortestPathInfo class for what each field of this object should contain
	  */
	@Override
	public ShortestPathInfo[] shortestPath(String label) {
		ArrayList<ShortestPathInfo> returnPaths = new ArrayList<>();
		
		Node n = nodeMap.get(label);
		long d;
		
	    MinBinHeap PQ = new MinBinHeap();
	    
	    PQ.insert(new EntryPair(0, n));
	    
	    EntryPair current = PQ.getMin();
	    
	    while(PQ.size()!=0){
	    	current = PQ.getMin();
	    	n = current.node;
	    	d = current.priority;
	    	PQ.delMin();
	    	
	    	
	    	if(n.known==false){
	    		n.known=true;	    		
	    		returnPaths.add(new ShortestPathInfo(n.getLabel(),d));
	    		
	    		for(Edge edge : n.getEdgeList()){
	    			Node adj = edge.getDestinationNode();
	    			if(adj.known==false){
	    				long weight = edge.weight;
	    				if(weight+d<adj.distance){
	    					adj.distance = weight+d;
	    					PQ.insert(new EntryPair(adj.distance,adj));
	    					
	    				}
	    			}
	    		}
	    	}
	    	
	    }
	    
	    
		return returnPaths.toArray(new ShortestPathInfo[returnPaths.size()]);
	}
	
	public void print(){
		for(Map.Entry<String, Node> entry : nodeMap.entrySet()){
			Node node = entry.getValue();		  
			System.out.println(node);		  
			for(Edge edge: node.getEdgeList()){
				System.out.println(edge);
			}		  
		}
	}

  
  
	@Override
	/**
	 * addNode
	      in: unique id number of the node (0 or greater)
	          string for name
	            you might want to generate the unique number automatically
	            but this operation allows you to specify any integer
	            both id number and label must be unique
	      return: boolean
	                returns false if node number is not unique, or less than 0
	                returns false if label is not unique (or is null)
	                returns true if node is successfully added 
	 */
	public boolean addNode(long idNum, String label) {
		
		boolean idCondition, labelCondition;
		
		//ID must be not found (unique) and >=0
		idCondition = (nodeIDs.contains(idNum) == false && idNum >=0);
		
		//label must be not found (unique) and not null
		labelCondition = (nodeMap.containsKey(label) == false && label!=null);
		
		if(idCondition && labelCondition)
		{
			//addNode		
			nodeMap.put(label, new Node(idNum, label));
			//add to list of IDs
			nodeIDs.add(idNum);		
			return true;
		}
		return false;
	}
	
	
	/**
	 *  addEdge
	      in: unique id number for the new edge, 
	          label of source node,
	          label of destination node,
	          weight for new edge (use 1 by default)
	          label for the new edge (allow null)
	      return: boolean
	                returns false if edge number is not unique or less than 0
	                returns false if source node is not in graph
	                returns false if destination node is not in graph
	                returns false is there already is an edge between these 2 nodes
	                returns true if edge is successfully added 
	 */
	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	
		boolean idCondition, nodeExistanceCondition, noDuplicatedEdgeCondition;
		//ID must be not found (unique) and >=0
		idCondition = (edgeIDs.contains(idNum) == false && idNum >=0);
		
		nodeExistanceCondition = (nodeMap.containsKey(sLabel) && nodeMap.containsKey(dLabel));
		if(nodeExistanceCondition==false){
			return false;
		}
		//edge cannot already exist
		noDuplicatedEdgeCondition = (nodeMap.get(sLabel).containsEdge(dLabel) == false);
	
		if(idCondition && nodeExistanceCondition && noDuplicatedEdgeCondition)
		{
			edgeIDs.add(idNum);
			
			Node sNode = nodeMap.get(sLabel);
			Node dNode = nodeMap.get(dLabel);
			//adds edge to edge list in existing Node in the nodeMap
			sNode.addEdge(new Edge(idNum, sNode, dNode, weight, eLabel));
			
			return true;
		}
		return false;
	}
	
	
	/**
	 * delNode
	      in: string 
	            label for the node to remove
	      out: boolean
	             return false if the node does not exist
	             return true if the node is found and successfully removed
	 */
	@Override
	public boolean delNode(String label) {
		if(nodeMap.containsKey(label)){
			Node sNode = nodeMap.get(label);
			
			//remove edge ids
			for(Edge edge : sNode.getEdgeList()){
				edge.getDestinationNode().unLinkNode(sNode);
				edgeIDs.remove(edge.getID());
			}		
			
			//remove node id
			nodeIDs.remove(sNode.getID());
			
			//remove backwards connected edges and ids
			for(Node node : sNode.getBackwardNodes()){
				edgeIDs.remove(node.getEdge(label).getID());			
				node.deleteEdge(label);
			}
			
			//remove node
			nodeMap.remove(label);
			
			return true;
		}
		return false;
		
	}
	
	
	/**
	 * delEdge
	      in: string label for source node
	          string label for destination node
	      out: boolean
	             return false if the edge does not exist
	             return true if the edge is found and successfully removed
	 */
	@Override
	public boolean delEdge(String sLabel, String dLabel) {	
		if(nodeMap.containsKey(sLabel)){
			Node sNode = nodeMap.get(sLabel);
			Node dNode = nodeMap.get(dLabel);
			if(sNode.containsEdge(dLabel)){
				edgeIDs.remove(sNode.getEdge(dLabel).getID());
				sNode.deleteEdge(dLabel);
				dNode.unLinkNode(sNode);
				
				return true;			
			}
		}
		return false;
	}
	
	
	/**
	 * numNodes
	      in: nothing
	      return: integer 0 or greater
	                reports how many nodes are in the graph
	 */
	@Override
	public long numNodes() {
		return nodeIDs.size();
	}
	
	
	/**
	 * numEdges
	      in: nothing
	      return: integer 0 or greater
	                reports how many edges are in the graph
	 */
	@Override
	public long numEdges() {
		return edgeIDs.size();
	}
	
	
	/**
	 * topoSort:
	      in: nothing
	      return: array of node labels (strings)
	                if there is no topo sort (a cycle) return null for the array
	                if there is a topo sort, return an array containing the node
	                  labels in order
	 */
	@Override
	public String[] topoSort() {		
		Stack<String> topologicalOrder = new Stack<>();
		Stack<Node> zeroInNodes = new Stack<>();
		
		Node current;
		
		for(Map.Entry<String, Node> entry : nodeMap.entrySet()){
			if(entry.getValue().getInitialIndegree() == 0){
				zeroInNodes.push(entry.getValue());
			}
		}		
		
		while(zeroInNodes.isEmpty() == false){
			current = zeroInNodes.pop();
			topologicalOrder.push(current.getLabel());
			for(Node neighbor: current.getForwardNodes()){
				
				neighbor.indegree--;
				if(neighbor.indegree == 0){
					zeroInNodes.push(neighbor);
				}
			}
			
		}
		
		
		if(topologicalOrder.size()<nodeMap.size()){
			return null;
		}
		return topologicalOrder.toArray(new String[topologicalOrder.size()]);
	}
	  
	  // rest of your code to implement the various operations
	
	public void printIDs(){
		  for(Long id : nodeIDs){
			  System.out.println("nodeID: "+id);
		  }
		  for(Long id : edgeIDs){
			  System.out.println("  edgeID: "+id);
		  }
	}
	public void printEdge(String sLabel, String dLabel){
		  Edge pEdge = nodeMap.get(sLabel).getEdge(dLabel);
		  System.out.println(pEdge);
	}
	public void printNode(String label){
		  Node pNode = nodeMap.get(label);
		  System.out.println(pNode);
		  for(Edge edge : pNode.getEdgeList()){
			  System.out.println(edge);
		  }
		  System.out.println("F N: ");
		  for(Node node : pNode.getForwardNodes()){
			  System.out.println("  "+node.getLabel());
		  }
		  System.out.println("B N: ");
		  for(Node node : pNode.getBackwardNodes()){
			  System.out.println("  "+node.getLabel());
		  }
	}
	

}