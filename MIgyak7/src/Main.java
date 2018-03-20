import solutionsearchers.MountClimber;
import solutionsearchers.TryNFail;
import threejugs.State;

public class Main {

	public static void main(String[] args) {
		int[] jugs = {5, 0, 0};
		State start = new State(jugs);
		
		TryNFail tryNFail = new TryNFail(start);
		tryNFail.search();
		
		/*MountClimber mountClimber = new MountClimber(start);
		mountClimber.search();*/
	}
}
