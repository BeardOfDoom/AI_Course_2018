package solutionsearchers;
import threejugs.Operator;
import threejugs.State;

public class TryNFail {

	State actual;
	
	public TryNFail(State start) {
		actual = start;
	}
	
	public void search() {
		while(true) {
			if(actual.isGoal()) {
				break;
			}
			
			boolean didUse = false;
			
			for(Operator operator : Operator.OPERATORS) {
				
				if(operator.isApplicable(actual)) {
					State newState = operator.apply(actual);
					actual = newState;
					didUse = true;
					System.out.println(actual);
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				
			}
			
			if(!didUse) {
				break;
			}
		}
		
		if(actual.isGoal()) {
			System.out.println(actual);
		} else {
			System.out.println("fail");
		}
	}
	
}
