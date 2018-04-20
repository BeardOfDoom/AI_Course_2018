package threejugs;
import java.util.Arrays;

public class State {

	int[] jugs = new int[3];
	public static int[] jugsMax = {5, 3, 2};
	
	public State(int[] jugs) {
		this.jugs = jugs;
	}

	public int[] getJugs() {
		return jugs;
	}

	public void setJugs(int[] jugs) {
		this.jugs = jugs;
	}

	public boolean isGoal() {
		return jugs[0] == 4;
	}

	@Override
	public String toString() {
		return "State [jugs=" + Arrays.toString(jugs) + "]";
	}
	
	public int heuristic() {
		//return Math.abs(4 - jugs[0]);
		return 4 - jugs[0] >= 0 ? 4 - jugs[0] : 500;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(jugs);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (!Arrays.equals(jugs, other.jugs))
			return false;
		return true;
	}
	
	
}
