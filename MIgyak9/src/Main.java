import java.util.ArrayList;

import solutionsearchers.BackTrackPathLengthLimit;
import threejugs.NodeWithDepth;
import threejugs.State;

public class Main {

	public static void main(String[] args) {
		int[] jugs = {5, 0, 0};
		State start = new State(jugs);
		
		/*BackTrack backTrack = new BackTrack(new Node(start, null, null, new ArrayList<>()));
		backTrack.search();
		
		BackTrackCircleDetection backTrackCircleDetection = new BackTrackCircleDetection(new Node(start, null, null, new ArrayList<>()));
		backTrackCircleDetection.search();*/
		
		int pathLengthLimit = 4;
		BackTrackPathLengthLimit backTrackPathLengthLimit = new BackTrackPathLengthLimit(new NodeWithDepth(start, null, null, new ArrayList<>(), 0), pathLengthLimit);
		backTrackPathLengthLimit.search();
	}
}
