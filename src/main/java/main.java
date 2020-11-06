import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.selectors.values.IntDomainMax;
import org.chocosolver.solver.search.strategy.selectors.values.IntDomainMin;
import org.chocosolver.solver.search.strategy.selectors.variables.FirstFail;
import org.chocosolver.solver.search.strategy.selectors.variables.MaxRegret;
import org.chocosolver.solver.variables.IntVar;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        /**
         * Modélisation du problème :
         *  - Etat initial : Un problème tel que définis dans Problem.java
         *  - Etat final : Une liste d'objets dont la somme des poids ne dépasse pas la capacité du sac.
         *  - Objectif : Maximiser la somme des valeures des objets sélectionnés.
         */

        Benchmark benckmark = new Benchmark();
        for (Problem problem: benckmark.getProblems()) {
            System.out.println("Running problem " + problem.toString());
            solveDefault(problem);
        }

    }

    /**
     * Solve problem using default settings.
     */
    public static void solveDefault(Problem problem) {

        //  On mesure la durée
        final long startTime = System.currentTimeMillis();

        //  Init choco
        Model model = new Model("BackPackProblem");

        //  Initialisation des variables
        //     Pour chaque objet, on ajoute une variable booléenne.
        //     Si cette variable vaut 1, on prend l'objet, si non on ne le prend pas.
        IntVar[] vars = model.intVarArray("X", problem.getItemsSize(), 0, 1, false);
        IntVar totalValue = model.intVar("Total_Value", 0, problem.getTotalValueUpperBound());

        //  Initialisation des contraintes
        int[] poids = new int[problem.getItemsSize()];
        int[] valeurs = new int[problem.getItemsSize()];
        for (int i = 0; i < problem.getItemsSize(); i++) {
            poids[i] = problem.getItem(i).getWeight();
            valeurs[i] = problem.getItem(i).getValue();
        }

        //  On ajoute la contrainte sur les poids
        model.scalar(vars, poids, "<=", problem.getBagCapacity()).post();

        //  On ajoute la contrainte sur la valeur total, indiquant que la valeur total doit correspondre à la somme des
        //  valeurs des objets.
        model.scalar(vars, valeurs, "=", totalValue).post();

        //  Résolution du problème
        model.setObjective(Model.MAXIMIZE, totalValue);
        Solver solver = model.getSolver();
        solver.setSearch(
                Search.intVarSearch(
                        new MaxRegret(),
                        new IntDomainMin(),
                        vars)
        );
        solver.showShortStatistics();

        //  Une fois sortis de la boucle, les valeures seront perdues. On les sauvegarde donc dans ces deux variables :
        int[] objets_pris = new int[problem.getItemsSize()];
        int valeur_total_calculee = 0;
        while(solver.solve()){//  Affichage de la solution :
            for (int i = 0; i < problem.getItemsSize(); i ++) {
                objets_pris[i] = vars[i].getValue();
            }
            valeur_total_calculee = totalValue.getValue();
        }

        //  Affichage de la solution
        System.out.println("=========================================================================================");
        System.out.println(" Affichage de la solution finale : ");
        int poid_total = 0;
        int valeur_total = 0;
        for (int i = 0; i < objets_pris.length; i ++) {
            if (objets_pris[i] == 1) {
                poid_total += problem.getItem(i).getWeight();
                valeur_total += problem.getItem(i).getValue();
                System.out.println(" - Nous avons pris l'objet " + problem.getItem(i).toString());
            } else {
                System.out.println(" - Nous n'avons pas pris l'objet " + problem.getItem(i).toString());
            }
        }

        //  Vérification de la solution
        System.out.println("=========================================================================================");
        System.out.println("Vérification des résultats ... ");
        if (poid_total > problem.getBagCapacity()) {
            System.out.println("Le poid total dépasse la capacité du sac, il y a une erreur");
            System.out.println(" Poid totale trouvé : " + poid_total);
            System.out.println(" Poid totale calculé : " + problem.getBagCapacity());
        } else {
            System.out.println("Poid totale OK");
        }
        if (valeur_total != valeur_total_calculee) {
            System.out.println("La valeur totale des objets est différente de la valeur totale trouvée par le solveur.");
            System.out.println(" Valeur totale calculée : " + valeur_total);
            System.out.println(" Valeur totale trouvée : " + totalValue.getValue());
        } else {
            System.out.println("Valeur totale OK");
        }

        //  Arrêt du chronomètre et affichage de la durée
        final long endTime = System.currentTimeMillis();


        System.out.println("Problem solved in " + (endTime - startTime));
    }
}