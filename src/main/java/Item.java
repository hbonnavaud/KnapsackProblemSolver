public class item {
    int id;
    int value;
    int weight;

    public item(int id, int value, int weight) {
        this.id = id;
        this.value = value;
        this.weight = weight;
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
