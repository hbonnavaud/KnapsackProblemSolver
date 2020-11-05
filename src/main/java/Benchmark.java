import java.util.ArrayList;

public class Benchmark {
    public static ArrayList<Problem> problems = new ArrayList<Problem>();

    public Benchmark() {
        Problem problem1 = new Problem("Problem 1", 100);

        problem1.add(new Item(0, 0, 1));
        problem1.add(new Item(1, 1, 1));
        problem1.add(new Item(2, 2, 2));
        problem1.add(new Item(3, 5, 5));
        problem1.add(new Item(4, 10, 10));
        problem1.add(new Item(5, 25, 25));
        problem1.add(new Item(6, 50, 50));
        problem1.add(new Item(7, 75, 75));
        problem1.add(new Item(8, 25, 50));
        problem1.add(new Item(9, 50, 25));

        problems.add(problem1);
    }

}
