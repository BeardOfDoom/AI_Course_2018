package solutionsearchers;

import java.util.LinkedList;
import java.util.List;

import threejugs.NodeWithDepth;
import threejugs.Operator;
import threejugs.State;

public class BreadthFirst {

	NodeWithDepth actual;
	LinkedList<NodeWithDepth> openNodes = new LinkedList<>();
	LinkedList<NodeWithDepth> closedNodes = new LinkedList<>();
	
	public BreadthFirst(State start) {
		openNodes.add(new NodeWithDepth(start, null, null, 0));
	}
	
	boolean isContains(List<NodeWithDepth> nodes, State state){
		for(NodeWithDepth node : nodes){
			if(node.getState().equals(state)){
				return true;
			}
		}
		return false;
	}
	
	void expand() {
		for(Operator operator : Operator.OPERATORS) {
			if(operator.isApplicable(actual.getState())) {
				State newState = operator.apply(actual.getState());
				
				boolean isContainedInOpenNodeList = isContains(openNodes, newState);
				boolean isContainedInClosedNodeList = isContains(closedNodes, newState);
				
				if(!isContainedInOpenNodeList && !isContainedInClosedNodeList) {
					NodeWithDepth newNode = new NodeWithDepth(newState, actual, operator, actual.getDepth() + 1);
					openNodes.addLast(newNode);
				}
			}
		}
		openNodes.remove(actual);
		closedNodes.add(actual);
	}
	
	public void search() {
		while(true) {
			if(openNodes.isEmpty())
				break;
			
			actual = openNodes.getFirst();
			
			System.out.println(actual.getState());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(actual.getState().isGoal())
				break;
			
			expand();
		}
		if(!openNodes.isEmpty()) {
			System.out.println(actual);
		} else {
			System.out.println("Nincs megoldás");
		}
	}
	
}
