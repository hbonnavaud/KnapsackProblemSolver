import java.util.ArrayList;

public class Benchmark {
    private ArrayList<Problem> problems = new ArrayList<Problem>();

    public Benchmark() {
        createProblem(100, new int[][]{{0, 1}, {1, 1}, {2, 2}, {5, 5}, {10, 10}, {25, 25}, {50, 50}, {75, 75}, {25, 50}, {50, 25}});
        createProblem(30 , new int[][]{{7, 13}, {4, 12}, {3, 8}, {3, 10}});



    }

    /**
     * Create and add a problem using a default name
     * @param weight problem's weight
     * @param items problem's items information ([value, weight] list
     */
    private void createProblem(int weight, int[][] items) {
        int problemId = problems.size();
        this.createProblem("Problem " + problemId, weight, items);
    }

    /**
     * Create and add a problem using the given name
     * @param name problem's name
     * @param weight problem's weight
     * @param items problem's items information ([value, weight] list
     */
    private void createProblem(String name, int weight, int[][] items) {
        Problem problem = new Problem(name, weight);
        problem.addItems(items);
        problems.add(problem);
    }

    /**
     * GETTERS
     */
    public ArrayList<Problem> getProblems() {
        return problems;
    }

    /**
     * SETTERS
     */
    public void setProblems(ArrayList<Problem> problems) {
        this.problems = problems;
    }
}
