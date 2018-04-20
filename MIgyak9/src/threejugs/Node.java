package threejugs;

import java.util.List;

public class Node {

	State state;
	Node parent;
	Operator operator;
	List<Operator> triedOperators;
	
	public Node(State state, Node parent, Operator operator, List<Operator> triedOperators) {
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.triedOperators = triedOperators;
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
	public List<Operator> getTriedOperators() {
		return triedOperators;
	}
	public void setTriedOperators(List<Operator> triedOperators) {
		this.triedOperators = triedOperators;
	}
	@Override
	public String toString() {
		return "Node [state=" + state + "]";
	}
	
}
