import org.chocosolver.solver.Model;

public class main {
    public static void main(String[] args) {
        benchmark bc = new benchmark();
        for (int i = 0; i < bc.problems.size(); i++) {
            System.out.println("probleme numéro "+i);
        }
    }
}
