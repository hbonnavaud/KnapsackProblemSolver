public class Item {
    private int id;
    private int value;
    private int weight;

    public Item(int id, int value, int weight) {
        this.id = id;
        this.value = value;
        this.weight = weight;
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
}
