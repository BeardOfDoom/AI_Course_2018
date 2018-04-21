package solutionsearchers;

import java.util.ArrayList;
import java.util.List;

import threejugs.Node;
import threejugs.Operator;
import threejugs.State;

public class BestFirst {

	Node actual;
	List<Node> openNodes = new ArrayList<>();
	List<Node> closedNodes = new ArrayList<>();
	
	public BestFirst(State start) {
		openNodes.add(new Node(start, null, null));
	}
	
	boolean isContains(List<Node> nodes, State state){
		for(Node node : nodes){
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
					Node newNode = new Node(newState, actual, operator);
					openNodes.add(newNode);
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
			
			actual = openNodes.get(0);
			
			for(Node node : openNodes) {
				if(node.getState().heuristic() < actual.getState().heuristic()) {
					actual = node;
				}
			}
			
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
