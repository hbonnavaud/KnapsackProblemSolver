package Solvers;

import Objects.Item;
import Objects.Problem;
import org.chocosolver.solver.search.strategy.selectors.values.IntValueSelector;
import org.chocosolver.solver.search.strategy.selectors.variables.VariableSelector;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.chocosolver.solver.search.strategy.Search.intVarSearch;

public class RatioHeuristicSolver extends BackPackSolver{
    public RatioHeuristicSolver(Problem problem) {
        super(problem);
    }

    @Override
    public void setSearch() {
        this.solver.setSearch(intVarSearch(

                // variable selector
                (VariableSelector<IntVar>) variables -> {
                    // Before to select an item to take in our bag, we need to know it there is enough place for it.
                    // Let calculate the bag current size
                    int totalWeight = 0;
                    for (int index = 0; index < variables.length; index ++) {
                        if (variables[index].isInstantiated()) {
                            totalWeight += variables[index].getValue() * problem.getItem(index).getWeight();
                        }
                    }

                    // We should return the variable that correspond to the item with the best weight
                    // in every unset variables
                    Double bestRatioFound = null;
                    Integer bestItemIndex = null;
                    for (int index = 0; index < variables.length; index ++) {
                        double itemRatio = problem.getItem(index).getRatio();
                        if (!variables[index].isInstantiated()
                                && (bestRatioFound == null || bestRatioFound < itemRatio)
                                && totalWeight + problem.getItem(index).getWeight() < problem.getBagCapacity()) {
                            bestRatioFound = itemRatio;
                            bestItemIndex = index;
                        }
                    }

                    // Now we found our variable index, we can return it.
                    if (bestItemIndex == null) {
                        return null;
                    } else return variables[bestItemIndex];
                },

                // value selector
                (IntValueSelector) var -> 1,

                // variables to branch on
                vars
        ));
    }
}
