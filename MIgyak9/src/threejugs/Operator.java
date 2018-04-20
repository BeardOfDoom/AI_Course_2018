package threejugs;
import java.util.ArrayList;
import java.util.List;

public class Operator {

	public static List<Operator> OPERATORS;
	
	static {
		OPERATORS = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i != j)
					OPERATORS.add(new Operator(i, j));
			}
		}
	}
	
	int index1;
	int index2;
	
	public Operator(int index1, int index2) {
		this.index1 = index1;
		this.index2 = index2;
	}
	
	public boolean isApplicable(State state) {
		return state.getJugs()[index1] != 0 && state.getJugs()[index2] < State.jugsMax[index2];
	}
	
	public State apply(State state) {
		int[] oldJugValues = state.getJugs();
		int[] newJugValues = new int[oldJugValues.length];
		
		for(int i = 0; i < oldJugValues.length; i++) {
			newJugValues[i] = oldJugValues[i];
		}
		
		int beerToTransfuse = Math.min(State.jugsMax[index2] - oldJugValues[index2], oldJugValues[index1]);
		newJugValues[index1] = newJugValues[index1] - beerToTransfuse;
		newJugValues[index2] = newJugValues[index2] + beerToTransfuse;
		
		return new State(newJugValues);
	}

	@Override
	public String toString() {
		return "Operator [index1=" + index1 + ", index2=" + index2 + "]";
	}
}
