package Solvers;

import Objects.Problem;
import org.chocosolver.solver.ICause;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.learn.ExplanationForSignedClause;
import org.chocosolver.solver.search.strategy.selectors.values.IntDomainMin;
import org.chocosolver.solver.search.strategy.selectors.variables.MaxRegret;
import org.chocosolver.solver.variables.IntVar;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.chocosolver.solver.search.strategy.Search.intVarSearch;

public class BackPackSolver {

    protected Problem problem;
    protected Model model;
    protected IntVar[] vars;
    protected IntVar totalValue;  // A choco solver variable that is the solution bag total value,
                                // and is our goal to maximize.
    protected Solver solver;

    // Solution interface
    private int[] solution;
    private Double resolutionTime;
    private int solutionTotalBagValue;
    private int solutionTotalBagWeight;

    // Resolution pipeline
    protected boolean searchMethodSet = false;
    protected boolean problemSolved = false;

    public BackPackSolver(Problem problem) {
        this.problem = problem;

        //  Init choco
        this.model = new Model("BackPackProblem");

        //  Initialisation des variables
        //     Pour chaque objet, on ajoute une variable booléenne.
        //     Si cette variable vaut 1, on prend l'objet, si non on ne le prend pas.
        this.vars = model.intVarArray("X", problem.getItemsSize(), 0, 1, false);
        this.totalValue = model.intVar("Total_Value", 0, problem.getTotalValueUpperBound());

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

        // On définis l'objectif à atteidre pour la résolution
        model.setObjective(Model.MAXIMIZE, totalValue);

        // On initialise le solver
        this.solver = model.getSolver();
    }

    /**
     * Set the research method.
     * To add new heuristics or change the research algorithm, this is the function you should edit.
     * For more information -> https://choco-solver.org/docs/advanced-usages/strategies/
     */
    public void setSearch() {
        //  Résolution du problème
        solver.setSearch(
                intVarSearch(
                        new MaxRegret(),
                        new IntDomainMin(),
                        vars)
        );
        this.searchMethodSet = true;
    }

    /**
     * Solve the problem using the search. This function will also call this.setSearch() function to be sure that the
     * search method has been set before to use it.
     * The found problem's solution will be stored in solution interface :
     *  - this.solution: List of 1/0 for each objects: 1 -> The object has been taken in the final bag, 0 -> It hasn't.
     *  - this.solutionTotalBagValue: Total bag's value at the end.
     *  - this.solutionTotalBagWeight: Total bag's weight at the end.
     */
    public void solve() {
        // Initialise the search method
        if (!this.searchMethodSet) this.setSearch();

        // Final solution interface initialisation
        this.solution = new int[problem.getItemsSize()];
        this.solutionTotalBagValue = 0;
        this.solutionTotalBagWeight = 0;

        // Find the final solution
        while(solver.solve()){
            for (int i = 0; i < problem.getItemsSize(); i ++) {
                solution[i] = vars[i].getValue();
            }
            solutionTotalBagValue = totalValue.getValue();
            this.resolutionTime = (double) solver.getTimeToBestSolution();
        }
        this.problemSolved = true;
    }

    /**
     * Tell us if the found solution is correct. This implies:
     *  - According to the list of taken objects in the found solution,
     *      * The sum of every value is equal to our goal to maximise -> this.totalValue.getValue()
     *      * The sum of every weights is lower or equal to our maximum bag weight -> this.problem.getBagCapacity()
     *  - TODO(optional): The solution goal to maximise value is equal to the best possible solution ?
     * @return True if the found solution is correct, false otherwise.
     */
    public boolean verifySolution() {
        // Verify if the computer total value is really equal to the sum of every
        int valueSum = 0;
        int weightSum = 0;
        for (int i = 0; i < this.vars.length; i++) {
            valueSum += this.vars[i].getValue() * problem.getItem(i).getValue();
            weightSum += this.vars[i].getValue() * problem.getItem(i).getWeight();
        }
        boolean result = valueSum == this.totalValue.getValue();
        return result && weightSum < this.problem.getBagCapacity();
    }

    /**
     * Return the solution result as a String.
     * If the resolution pipeline isn't done yet, it will return null.
     * @return String: resolution output as a string, but null if resolution pipeline isn't done.
     */
    public String getStringResult(boolean printSolution, boolean printSolvingDuration) {
        /* Old fancy version
        String result = "{\n\t'Problem name': " + this.problem.getName() + ",";
        if (printSolution) {
            result += "\n\t'Solution': " + this.vars.toString() + ",";
        }
        if (printSolvingDuration) {
            result += "\n\t'Resolution duration': " + this.resolutionTime + ",";
        }
        return result + "\n},";
         */
        // Efficient version
        return this.problem.getName() + " solved in " + this.resolutionTime;
    }

    /**
     * GETTERS
     */
    public boolean isSearchMethodSet() {  // NB: Ther's no setter for this argument
        return searchMethodSet;
    }

    public boolean isProblemSolved() {  // NB: Ther's no setter for this argument
        return problemSolved;
    }
}
