package solutionsearchers;

import java.util.ArrayList;

import threejugs.Node;
import threejugs.NodeWithDepth;
import threejugs.Operator;
import threejugs.State;

public class BackTrackPathLengthLimit {

	NodeWithDepth actual;
	int pathLengthLimit;

	public BackTrackPathLengthLimit(NodeWithDepth start, int pathLengthLimit) {
		actual = start;
		this.pathLengthLimit = pathLengthLimit;
	}
	
	public void search() {
		while(true) {
			if(actual == null)
				break;
			
			if(actual.getState().isGoal())
				break;
			
			if(actual.getDepth() == pathLengthLimit) {
				actual = actual.getParent();
			}
			
			boolean didUseOperator = false;
			
			for(Operator operator : Operator.OPERATORS) {
				if(operator.isApplicable(actual.getState()) && !actual.getTriedOperators().contains(operator)) {
					actual.getTriedOperators().add(operator);
					State newState = operator.apply(actual.getState());
					actual = new NodeWithDepth(newState, actual, operator, new ArrayList<>(), actual.getDepth() + 1);
					didUseOperator = true;
					System.out.println(newState);
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			
			if(!didUseOperator)
				actual = actual.getParent();
		}
		
		if(actual != null) {
			System.out.println(actual);
		} else {
			System.out.println("Nincs megoldás");
		}
	}
}
