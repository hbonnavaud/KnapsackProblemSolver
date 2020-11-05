import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.selectors.values.IntDomainMax;
import org.chocosolver.solver.search.strategy.selectors.variables.FirstFail;
import org.chocosolver.solver.variables.IntVar;
import java.util.logging.ConsoleHandler;

public class main {
    public static void main(String[] args) {
        /**
         * Modélisation du problème :
         *  - Etat initial : Un problème tel que définis dans Problem.java
         *  - Etat final : Une liste d'objets dont la somme des poids ne dépasse pas la capacité du sac.
         *  - Objectif : Maximiser la somme des valeures des objets sélectionnés.
         */

        for (Problem problem: Benchmark.problems) {
            this.solveDefault(problem);
        }

    }

    /**
     * Solve problem using default settings.
     */
    public void solveDefault(Problem problem) {
        //Init choco
        Model model = new Model("BackPackProblem");

        //Contraintes
        for (int i = 0; i < Benchmark.problems.size(); i++) {
            Problem pb = Benchmark.problems.get(i);

            int maxSat = 0;
            int maxWeight = 0;
            for (int o = 0; o < pb.getN(); o++) {
                maxSat = maxSat + pb.getItem(o).getValue();
                maxWeight = maxWeight + pb.getItem(o).getWeight();
            }

            //Variables
            IntVar[] pack = model.intVarArray("pack", 10, 0, 1);
            IntVar sumSatisfaction = model.intVar("sumSatisfaction", 0, maxSat);
            IntVar sumWeight = model.intVar("sumWeight", 0, maxWeight);

            model.arithm(sumWeight, "<=", pb.limit_weight).post();

            //Maximisation du résultat
            model.setObjective(Model.MAXIMIZE, sumSatisfaction);
            Solver solver = model.getSolver();
            solver.setSearch(
                    Search.intVarSearch(
                            new FirstFail(model),
                            new IntDomainMax(),
                            sumSatisfaction
                    )
            );
            solver.showShortStatistics();
            while (solver.solve()) {
                System.out.println(sumSatisfaction);
                System.out.println(sumWeight);
            }
        }
    }
}