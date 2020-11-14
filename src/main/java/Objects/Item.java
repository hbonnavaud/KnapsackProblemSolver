package Objects;

public class Item {
    private int id;
    private int value;
    private int weight;

    private int ratio;

    public Item(int id, int value, int weight) {
        this.id = id;
        this.value = value;
        this.weight = weight;
        if (weight == 0) {
            this.ratio = -1;  // We consider -1 as infinite ...
        }
        else {
            this.ratio = value/weight;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "n°" + id +
                ", valeur =" + value +
                ", poid =" + weight +
                '}';
    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public int getRatio() {
        return ratio;
    }
}
