package threejugs;

public class Node {

	State state;
	Node parent;
	Operator operator;
	
	public Node(State state, Node parent, Operator operator) {
		this.state = state;
		this.parent = parent;
		this.operator = operator;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	@Override
	public String toString() {
		return "Node [state=" + state + "]";
	}
	
}
