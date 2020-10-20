import java.util.ArrayList;
import java.util.List;

public class benchmark {
    public static ArrayList problems = new ArrayList();

    public benchmark() {
        problem pb1 = new problem();
        pb1.name = "pb1";
        pb1.limit_weight = 100;

        pb1.items.add(new item(0, 0, 1));
        pb1.items.add(new item(1, 1, 1));
        pb1.items.add(new item(2, 2, 2));
        pb1.items.add(new item(3, 5, 5));
        pb1.items.add(new item(4, 10, 10));
        pb1.items.add(new item(5, 25, 25));
        pb1.items.add(new item(6, 50, 50));
        pb1.items.add(new item(7, 75, 75));
        pb1.items.add(new item(8, 25, 50));
        pb1.items.add(new item(9, 50, 25));

        problems.add(pb1);
    }

}
