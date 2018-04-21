import solutionsearchers.BreadthFirst;
import threejugs.State;

public class Main {

	public static void main(String[] args) {
		int[] jugs = {5, 0, 0};
		State start = new State(jugs);
		
		BreadthFirst breadthFirst = new BreadthFirst(start);
		breadthFirst.search();
	}
}
