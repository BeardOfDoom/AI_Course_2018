package solutionsearchers;
import java.util.ArrayList;
import java.util.List;

import threejugs.Operator;
import threejugs.State;

public class MountClimber {

State actual;
	
	public MountClimber(State start) {
		actual = start;
	}
	
	public void search() {
		while(true) {
			if(actual.isGoal()) {
				break;
			}

			List<State> possibleStates = new ArrayList<>();
			for(Operator operator : Operator.OPERATORS) {
				
				if(operator.isApplicable(actual)) {
					State newState = operator.apply(actual);
					possibleStates.add(newState);
				}
			}
			
			boolean didUse = false;
			
			for(State state : possibleStates) {
				if(state.heuristic() < actual.heuristic()) {
					actual = state;
					didUse = true;
				}
			}
			
			if(!didUse) {
				break;
			}
			System.out.println(actual);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(actual.isGoal()) {
			System.out.println(actual);
		} else {
			System.out.println("fail");
		}
	}
	
}
