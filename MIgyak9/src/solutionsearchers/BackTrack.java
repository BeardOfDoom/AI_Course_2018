package solutionsearchers;

import java.util.ArrayList;

import threejugs.Node;
import threejugs.Operator;
import threejugs.State;

public class BackTrack {

	Node actual;

	public BackTrack(State start) {
		actual = new Node(start, null, null, new ArrayList<>());
	}
	
	
	public void search() {
		while(true) {
			if(actual == null)
				break;
			if(actual.getState().isGoal())
				break;
			
			boolean didUseOperator = false;
			
			for(Operator operator : Operator.OPERATORS) {
				if(operator.isApplicable(actual.getState()) && !actual.getTriedOperators().contains(operator)) {
					actual.getTriedOperators().add(operator);
					State newState = operator.apply(actual.getState());
					actual = new Node(newState, actual, operator, new ArrayList<>());
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
