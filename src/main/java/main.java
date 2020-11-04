import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.selectors.values.IntDomainMax;
import org.chocosolver.solver.search.strategy.selectors.variables.FirstFail;
import org.chocosolver.solver.variables.IntVar;

public class main {
    public static void main(String[] args) {

        //Init choco

        benchmark bc = new benchmark();
        Model model = new Model("BackPackProblem");


        //Contraintes
        for (int i = 0; i < benchmark.problems.size(); i++) {
            problem pb = (problem) benchmark.problems.get(i);

            int maxSat = 0;
            int maxWeight = 0;
            for (int o = 0; o < pb.items.size(); o++) {
                maxSat = maxSat + pb.getItem(o).getValue();
                maxWeight = maxWeight + pb.getItem(o).getWeight();
            }

            //Variables
            IntVar[] pack = model.intVarArray("pack", 10, 0, 1);
            IntVar sumSatisfaction = model.intVar("sumSatisfaction", 0, maxSat);
            IntVar sumWeight = model.intVar("sumWeight", 0, maxWeight);
//
//            int j = 0;
//            for (Item item : pb.items) {
//                System.out.println(pack[j]);
//                if (pack[j] == model.intVar(1)) {
//                    System.out.println("objet " + j + "set in bag");
//                    sumWeight = (IntVar) sumWeight.add(item.getWeight());
//                    sumSatisfaction = (IntVar) sumSatisfaction.add(item.getValue());
//                }
//                j++;
//            }

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
