import java.util.ArrayList;

import solutionsearchers.BackTrack;
import solutionsearchers.BackTrackCircleDetection;
import threejugs.Node;
import threejugs.State;

public class Main {

	public static void main(String[] args) {
		int[] jugs = {5, 0, 0};
		State start = new State(jugs);
		
		/*BackTrack backTrack = new BackTrack(new Node(start, null, null, new ArrayList<>()));
		backTrack.search();*/
		
		BackTrackCircleDetection backTrackCircleDetection = new BackTrackCircleDetection(new Node(start, null, null, new ArrayList<>()));
		backTrackCircleDetection.search();
	}
}
