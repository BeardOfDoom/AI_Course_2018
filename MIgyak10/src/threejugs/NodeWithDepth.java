package threejugs;

public class NodeWithDepth {

	State state;
	NodeWithDepth parent;
	Operator operator;
	int depth;
	
	public NodeWithDepth(State state, NodeWithDepth parent, Operator operator, int depth) {
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.depth = depth;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public NodeWithDepth getParent() {
		return parent;
	}
	
	public void setParent(NodeWithDepth parent) {
		this.parent = parent;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	@Override
	public String toString() {
		return "Node [state=" + state + "]";
	}
}
