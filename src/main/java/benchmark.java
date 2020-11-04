import java.util.ArrayList;

public class benchmark {
    public static ArrayList problems = new ArrayList();

    public benchmark() {
        problem pb1 = new problem();
        pb1.name = "pb1";
        pb1.limit_weight = 100;

        pb1.items.add(new Item(0, 0, 1));
        pb1.items.add(new Item(1, 1, 1));
        pb1.items.add(new Item(2, 2, 2));
        pb1.items.add(new Item(3, 5, 5));
        pb1.items.add(new Item(4, 10, 10));
        pb1.items.add(new Item(5, 25, 25));
        pb1.items.add(new Item(6, 50, 50));
        pb1.items.add(new Item(7, 75, 75));
        pb1.items.add(new Item(8, 25, 50));
        pb1.items.add(new Item(9, 50, 25));

        problems.add(pb1);
    }

}
