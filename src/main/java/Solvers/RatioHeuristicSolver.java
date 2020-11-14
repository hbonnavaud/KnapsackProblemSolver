package Solvers;

import Objects.Problem;
import org.chocosolver.solver.search.strategy.selectors.values.IntValueSelector;
import org.chocosolver.solver.search.strategy.selectors.variables.VariableSelector;
import org.chocosolver.solver.variables.IntVar;

import static org.chocosolver.solver.search.strategy.Search.intVarSearch;

public class RatioHeuristicSolver extends BackPackSolver{
    public RatioHeuristicSolver(Problem problem) {
        super(problem);
    }

    @Override
    void setSearch() {
        this.solver.setSearch(intVarSearch(

                // variable selector
                (VariableSelector<IntVar>) variables -> {
                    for(IntVar v:variables){
                        if(!v.isInstantiated()){
                            return v;
                        }
                    }
                    return null;
                },

                // value selector
                (IntValueSelector) var -> {
                    return 0;
                },

                // variables to branch on
                vars
        ));
    }
}
