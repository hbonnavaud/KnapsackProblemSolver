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
            solveDefault(problem);
        }
        for (Problem problem: benckmark.getProblems()) {
            solveOptim(problem);
        }
    }

    /**
     * Solve problem using default settings.
     */
    public static void solveDefault(Problem problem) {

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

        //  Une fois sortis de la boucle, les valeures seront perdues. On les sauvegarde donc dans ces deux variables :
        int[] objets_pris = new int[problem.getItemsSize()];
        int valeur_total_calculee = 0;
        double temps_de_calcule = 0;
        while(solver.solve()){
            for (int i = 0; i < problem.getItemsSize(); i ++) {
                objets_pris[i] = vars[i].getValue();
            }
            valeur_total_calculee = totalValue.getValue();
            temps_de_calcule = solver.getTimeToBestSolution();
        }

        //  Affichage de la solution
        int poid_total = 0;
        int valeur_total = 0;
        for (int i = 0; i < objets_pris.length; i ++) {
            if (objets_pris[i] == 1) {
                poid_total += problem.getItem(i).getWeight();
                valeur_total += problem.getItem(i).getValue();
                // System.out.println(" - Nous avons pris l'objet " + problem.getItem(i).toString());
            } else {
                // System.out.println(" - Nous n'avons pas pris l'objet " + problem.getItem(i).toString());
            }
        }

        System.out.println(problem.getName() + " -> sol=" + Arrays.toString(objets_pris) + ", calculée en " + temps_de_calcule);

        //  Vérification de la solution
        if (poid_total > problem.getBagCapacity()) {
            System.out.println("Le poid total dépasse la capacité du sac, il y a une erreur");
        }
        if (valeur_total != valeur_total_calculee) {
            System.out.println("La valeur totale des objets est différente de la valeur totale trouvée par le solveur.");
        }
    }

    /**
     * Solve problem using default settings.
     */
    public static void solveOptim(Problem problem) {

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

        //  Une fois sortis de la boucle, les valeures seront perdues. On les sauvegarde donc dans ces deux variables :
        int[] objets_pris = new int[problem.getItemsSize()];
        int valeur_total_calculee = 0;
        double temps_de_calcule = 0;
        while(solver.solve()){
            for (int i = 0; i < problem.getItemsSize(); i ++) {
                objets_pris[i] = vars[i].getValue();
            }
            valeur_total_calculee = totalValue.getValue();
            temps_de_calcule = solver.getTimeToBestSolution();
        }

        //  Affichage de la solution
        int poid_total = 0;
        int valeur_total = 0;
        for (int i = 0; i < objets_pris.length; i ++) {
            if (objets_pris[i] == 1) {
                poid_total += problem.getItem(i).getWeight();
                valeur_total += problem.getItem(i).getValue();
                // System.out.println(" - Nous avons pris l'objet " + problem.getItem(i).toString());
            } else {
                // System.out.println(" - Nous n'avons pas pris l'objet " + problem.getItem(i).toString());
            }
        }

        System.out.println(problem.getName() + " -> sol=" + Arrays.toString(objets_pris) + ", calculée en " + temps_de_calcule);

        //  Vérification de la solution
        if (poid_total > problem.getBagCapacity()) {
            System.out.println("Le poid total dépasse la capacité du sac, il y a une erreur");
        }
        if (valeur_total != valeur_total_calculee) {
            System.out.println("La valeur totale des objets est différente de la valeur totale trouvée par le solveur.");
        }
    }
}