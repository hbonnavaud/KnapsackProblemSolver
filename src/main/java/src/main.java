package src;

import Objects.Benchmark;
import Objects.Problem;
import Solvers.BackPackSolver;
import Solvers.RatioHeuristicSolver;

public class main {
    public static void main(String[] args) {
        /**
         * Modélisation du problème :
         *  - Etat initial : Un problème tel que définis dans Objects.Problem.java
         *  - Etat final : Une liste d'objets dont la somme des poids ne dépasse pas la capacité du sac.
         *  - Objectif : Maximiser la somme des valeures des objets sélectionnés.
         */

        Benchmark benckmark = new Benchmark();
        /*
        for (Problem problem: benckmark.getProblems()) {
            BackPackSolver backPackSolver = new BackPackSolver(problem);
            backPackSolver.solve();
            System.out.println(backPackSolver.getStringResult(false, true));
        }*/
        for (Problem problem: benckmark.getProblems()) {
            RatioHeuristicSolver ratioHeuristicSolver = new RatioHeuristicSolver(problem);
            ratioHeuristicSolver.solve();
            System.out.println(ratioHeuristicSolver.getStringResult(false, true));
        }
    }
}