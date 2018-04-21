import solutionsearchers.BackTrackBranchAndBound;
import threejugs.State;

public class Main {

	public static void main(String[] args) {
		int[] jugs = {5, 0, 0};
		State start = new State(jugs);
		
		/*BackTrack backTrack = new BackTrack(new Node(start);
		backTrack.search();
		
		BackTrackCircleDetection backTrackCircleDetection = new BackTrackCircleDetection(start);
		backTrackCircleDetection.search();
		
		int pathLengthLimit = 4;
		BackTrackPathLengthLimit backTrackPathLengthLimit = new BackTrackPathLengthLimit(start, pathLengthLimit);
		backTrackPathLengthLimit.search();*/
		
		int pathLengthLimit = 4;
		BackTrackBranchAndBound backTrackBranchAndBound = new BackTrackBranchAndBound(start, pathLengthLimit);
		backTrackBranchAndBound.search();
	}
}
