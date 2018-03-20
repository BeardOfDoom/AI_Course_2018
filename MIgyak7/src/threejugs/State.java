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
}
