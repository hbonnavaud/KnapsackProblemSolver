import java.util.ArrayList;
import java.util.List;


public class Problem {

    /**
     * On définit un problème du sac à dos comme suit :
     *  - N : Nombre d'objets dans le problème
     *  - W : Capacité du sac à dos, la majuscule indique qu'il ne peut pas s'agir d'une capacité d'ojet (sorte de
     *      convention).
     *  - Pour chaque objet :
     *      - w : ou weight = poid de l'objet
     *      - v: ou value = valeur de l'objet
     */

    private String name;
    private int bagCapacity;  // Capacité du problème
    private int itemsSize;  // Nombre d'objets
    private List<Item> items = new ArrayList<Item>();

    public Problem(String name, int W) {
        this.name = name;
        this.bagCapacity = W;
        this.itemsSize = 0;
    }

    public Item getItem(int i){
        return items.get(i);
    }

    public void add(Item newObject) {
        this.items.add(newObject);
        this.itemsSize += 1;
    }

    /**
     * GETTERS
     */
    public String getName() {
        return name;
    }

    public int getBagCapacity() {
        return bagCapacity;
    }

    public int getItemsSize() {
        return itemsSize;
    }

    public List<Item> getItems() {
        return items;
    }

    /**
     * SETTERS
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setBagCapacity(int bagCapacity) {
        this.bagCapacity = bagCapacity;
    }

    public void setItemsSize(int itemsSize) {
        this.itemsSize = itemsSize;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

