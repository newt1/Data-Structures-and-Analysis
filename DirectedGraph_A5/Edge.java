package DiGraph_A5;

public class Edge {
	private long ID;
	private String sLabel;
	private String dLabel;
	private long weight;
	private String eLabel;
	private Node sNode;
	private Node dNode;
	
	public Edge(long idNum, Node sNode, Node dNode, long weight, String eLabel){
		this.ID = idNum;
		this.sNode = sNode;
		this.dNode = dNode;
		this.sLabel = sNode.getLabel();
		this.dLabel = dNode.getLabel();
		if(weight == 0){
			this.weight = 1;
		}
		else{
			this.weight = weight;
		}
		this.eLabel = eLabel;
	}
	public long getID(){
		return ID;
	}
	public Node getSourceNode(){
		return sNode;
	}
	public Node getDestinationNode(){
		return dNode;
	}
	public String getSourceLabel(){
		return sLabel;
	}
	public String getDestinationLabel(){
		return dLabel;
	}
	public String toString(){
		if(eLabel!=null){
			return("  ("+ID+")--"+eLabel+","+weight+"--> " +dLabel);	
		}
		return("  ("+ID+")--"+weight+"--> " +dLabel);		
	}
}
