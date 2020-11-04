import java.util.ArrayList;
import java.util.List;

public class problem {
    String name;
    int limit_weight;
    List<Item> items = new ArrayList<Item>();

    public Item getItem(int i){
        return (Item) items.get(i);
    }
}

