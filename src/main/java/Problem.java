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
    private int W;  // Capacité du problème
    private int N;  // Nombre d'objets
    private List<Item> items = new ArrayList<Item>();

    public Problem(String name, int W) {
        this.name = name;
        this.W = W;
        this.N = 0;
    }

    public Item getItem(int i){
        return items.get(i);
    }

    public void add(Item newObject) {
        this.items.add(newObject);
        this.N += 1;
    }

    /**
     * GETTERS
     */
    public String getName() {
        return name;
    }

    public int getW() {
        return W;
    }

    public int getN() {
        return N;
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

    public void setW(int w) {
        W = w;
    }

    public void setN(int n) {
        N = n;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

