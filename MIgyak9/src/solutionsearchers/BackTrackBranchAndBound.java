package solutionsearchers;

import java.util.ArrayList;

import threejugs.NodeWithDepth;
import threejugs.Operator;
import threejugs.State;

public class BackTrackBranchAndBound {

	NodeWithDepth actual;
	int pathLengthLimit;
	boolean didFindSolution;
	NodeWithDepth solution;

	public BackTrackBranchAndBound(State start, int pathLengthLimit) {
		actual = new NodeWithDepth(start, null, null, new ArrayList<>(), 0);
		this.pathLengthLimit = pathLengthLimit;
		didFindSolution = false;
	}
	
	public void search() {
		while(true) {
			if(actual == null)
				break;
			
			if(actual.getState().isGoal()) {
				didFindSolution = true;
				solution = actual;
				pathLengthLimit = actual.getDepth();
			}
			
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
		
		if(didFindSolution) {
			System.out.println(solution);
		} else {
			System.out.println("Nincs megoldás");
		}
	}
}
