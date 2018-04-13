package DiGraph_A5;

import java.util.ArrayList;

public class Node {
	private long ID;
	private String label;
	private ArrayList<Edge> edgeList;
	private ArrayList<Node> backwardNodes;
	private ArrayList<Node> forwardNodes;
	public int indegree;
	
		
	public Node(long ID, String label){
		this.ID = ID;
		this.label = label;
		edgeList = new ArrayList<>();
		backwardNodes = new ArrayList<>();
		forwardNodes = new ArrayList<>();
		
	}
	public long getID(){
		return ID;
	}
	public String getLabel(){
		return label;
	}
	
	public void linkNode(Node n){
		backwardNodes.add(n);		
	}
	public void unLinkNode(Node n){
		backwardNodes.remove(n);	
	}
	
	public void addEdge(Edge e){
		edgeList.add(e);	
		forwardNodes.add(e.getDestinationNode());
		e.getDestinationNode().linkNode(this);
	}
	public void deleteEdge(String dLabel){
		for(int i = 0; i < edgeList.size(); i++){
			Edge edge = edgeList.get(i);
			if(edge.getDestinationLabel().equals(dLabel)){
				forwardNodes.remove(edge.getDestinationNode());
				edgeList.remove(i);				
				return;
			}
		}
	}
	
	public Edge getEdge(String dLabel){
		for(int i = 0; i < edgeList.size(); i++){
			if(edgeList.get(i).getDestinationLabel().equals(dLabel)){
				return edgeList.get(i);
			}
		}
		//not found
		return null;
	}
	
	public boolean containsEdge(String dLabel){
		return (getEdge(dLabel) != null);
	}
	
	public ArrayList<Edge> getEdgeList(){	
		return edgeList;
	}
	
	public ArrayList<Node> getBackwardNodes(){	
		return backwardNodes;
	}

	public ArrayList<Node> getForwardNodes(){	
		return forwardNodes;
	}
	public boolean hasNext(){
		return edgeList.size()>0;
	}
	
	public int getInitialIndegree(){
		indegree = backwardNodes.size();
		return indegree;
	}
	
	public String next(){
		return edgeList.get(0).getDestinationLabel();
	}
	
	public String toString(){
		return("("+ID+")"+label);
	}
	
}
