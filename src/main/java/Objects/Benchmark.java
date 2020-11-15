package Objects;

import java.util.ArrayList;

public class Benchmark {
    private ArrayList<Problem> problems = new ArrayList<Problem>();

    public Benchmark() {

        boolean run_easy_problem = false;
        boolean run_medium_problem = false;
        boolean run_hard_problem = true;
        boolean run_insane_problem = false;

        /**
         * Manually instanciated problems
         */

        /*
        createProblem(100, new int[][]{{0, 1}, {1, 1}, {2, 2}, {5, 5}, {10, 10}, {25, 25}, {50, 50}, {75, 75}, {25, 50}, {50, 25}});
        createProblem(30 , new int[][]{{7, 13}, {4, 12}, {3, 8}, {3, 10}});
        */

        /**
         * AUTO-GENERATED PROBLEMS
         *
         * On linux, execute:
         *    cd src/src.main
         *    ./generate_problems
         */
        /**
         * PROBLEMES SIMPLES < 1 sec pour obtenir la solution avec les paramètres par défaut du solveur
         */

        if (run_easy_problem) {
            createProblem(152 , new int[][]{{48, 41}, {44, 20}, {23, 2}, {15, 13}, {30, 37}, {41, 31}, {50, 3}, {14, 6}, {19, 32}, {18, 39}, {6, 31}, {14, 8}, {15, 7}, {2, 1}, {8, 49}, {36, 30}, {7, 44}, {29, 16}, {2, 50}, {12, 23}, {10, 4}, {44, 35}, {25, 20}, {14, 19}, {14, 17}, {7, 31}});
            createProblem(102 , new int[][]{{4, 13}, {39, 0}, {37, 44}, {35, 34}, {9, 49}, {28, 11}, {29, 42}, {20, 45}, {28, 48}, {19, 22}, {38, 43}, {41, 21}, {2, 39}});
            createProblem(199 , new int[][]{{44, 7}, {11, 20}, {21, 24}, {14, 42}, {22, 36}, {38, 46}, {4, 39}, {11, 46}, {12, 36}, {26, 34}, {29, 0}, {45, 40}, {1, 36}, {15, 42}, {12, 3}, {27, 47}, {6, 17}, {4, 2}, {16, 17}, {11, 5}, {12, 13}, {3, 8}, {38, 26}, {48, 18}, {2, 27}, {20, 13}, {27, 3}, {15, 0}, {13, 2}, {41, 7}, {17, 28}, {16, 49}, {13, 17}, {40, 0}, {43, 4}, {12, 35}, {6, 9}});
            createProblem(140 , new int[][]{{20, 2}, {26, 32}, {0, 5}, {4, 23}, {32, 43}, {14, 22}, {17, 12}, {5, 22}, {22, 6}, {47, 27}, {7, 31}, {1, 14}, {0, 17}, {31, 23}, {16, 24}, {7, 43}, {22, 1}, {35, 26}, {15, 46}, {34, 29}, {26, 0}, {14, 41}, {16, 16}, {8, 45}, {14, 13}});
            createProblem(141 , new int[][]{{19, 15}, {7, 29}, {20, 36}, {14, 15}, {41, 36}, {34, 48}, {21, 40}, {0, 7}, {13, 8}, {8, 42}, {3, 7}, {24, 27}, {18, 40}, {6, 32}, {17, 45}, {30, 41}, {1, 35}, {44, 29}, {30, 28}, {4, 6}});
            createProblem(76 , new int[][]{{11, 44}, {24, 8}, {48, 3}, {0, 11}, {9, 38}, {32, 17}, {30, 8}, {0, 20}, {42, 28}, {7, 36}, {43, 30}, {24, 39}, {25, 24}, {41, 1}});
            createProblem(194 , new int[][]{{18, 4}, {14, 37}, {27, 24}, {5, 38}, {39, 38}, {48, 8}, {17, 30}, {50, 0}, {23, 18}, {40, 27}, {20, 19}, {11, 33}, {27, 28}, {7, 14}, {34, 39}, {50, 28}, {32, 8}, {5, 3}, {8, 6}, {9, 42}, {4, 38}, {22, 42}, {10, 17}, {45, 16}, {30, 10}, {0, 31}, {19, 5}, {23, 41}, {12, 31}, {8, 33}, {37, 33}, {18, 26}, {1, 12}});


            // 0,4 secondes
            createProblem(161 , new int[][]{{39, 17}, {34, 24}, {3, 11}, {1, 22}, {0, 13}, {0, 29}, {7, 20}, {41, 23}, {17, 15}, {44, 20}, {42, 21}, {3, 19}, {8, 26}, {47, 19}, {6, 10}, {4, 28}, {14, 20}, {41, 29}, {0, 19}, {39, 17}, {30, 30}, {3, 23}, {28, 18}, {39, 21}, {32, 14}, {26, 26}, {42, 18}, {6, 18}, {9, 11}, {21, 29}, {9, 17}, {16, 18}});
        }

        /**
         * PROBLEMES INTERMEDIAIRES > 1 sec
         */

        if (run_medium_problem) {
            createProblem(250, new int[][]{{30, 25}, {8, 4}, {15, 24}, {16, 1}, {29, 46}, {45, 41}, {38, 10}, {45, 36}, {11, 23}, {30, 29}, {2, 28}, {43, 25}, {0, 40}, {11, 0}, {16, 17}, {41, 45}, {40, 24}, {26, 7}, {22, 43}, {43, 25}, {13, 33}, {28, 30}, {18, 31}, {31, 30}, {49, 44}, {25, 11}, {35, 38}, {20, 1}, {21, 44}, {39, 22}, {0, 47}, {28, 17}, {7, 46}, {20, 39}, {31, 38}, {23, 33}, {43, 6}});
            createProblem(284, new int[][]{{26, 27}, {4, 41}, {43, 44}, {48, 26}, {29, 47}, {50, 44}, {50, 38}, {16, 26}, {12, 31}, {46, 11}, {39, 8}, {44, 43}, {40, 14}, {28, 42}, {14, 39}, {43, 26}, {49, 24}, {27, 39}, {28, 22}, {37, 50}, {6, 18}, {27, 35}, {35, 7}, {22, 42}, {0, 41}, {25, 30}, {49, 36}, {32, 2}, {0, 18}, {29, 37}, {2, 13}, {45, 17}, {34, 46}, {25, 18}, {48, 3}, {17, 34}, {6, 31}, {27, 8}, {35, 44}, {40, 15}});

            // 2,61 secondes
            createProblem(141 , new int[][]{{30, 11}, {49, 14}, {12, 21}, {38, 13}, {9, 14}, {7, 12}, {18, 17}, {14, 10}, {40, 26}, {28, 19}, {10, 29}, {15, 29}, {24, 26}, {7, 13}, {27, 21}, {24, 12}, {45, 12}, {35, 25}, {28, 19}, {36, 16}, {34, 10}, {10, 18}, {43, 28}, {41, 18}, {49, 16}, {26, 19}, {46, 24}, {20, 30}, {33, 23}, {23, 20}});

            // 5,6 secondes
            createProblem(205 , new int[][]{{12, 30}, {7, 20}, {8, 25}, {26, 11}, {7, 28}, {30, 11}, {23, 18}, {7, 19}, {3, 21}, {49, 30}, {45, 20}, {29, 28}, {28, 28}, {9, 22}, {39, 21}, {7, 11}, {6, 19}, {1, 27}, {34, 12}, {22, 27}, {3, 11}, {34, 26}, {19, 26}, {45, 22}, {21, 13}, {21, 17}, {3, 10}, {18, 23}, {33, 23}, {12, 20}, {47, 22}, {0, 25}, {25, 11}, {26, 14}, {6, 28}, {14, 29}, {1, 27}, {27, 26}, {50, 21}});
        }

        /**
         * PROBLEMES DIFICILES > 10 sec
         */

        if (run_hard_problem) {
            // 28 secondes
            createProblem(189 , new int[][]{{49, 21}, {21, 12}, {11, 21}, {5, 13}, {30, 30}, {33, 24}, {29, 23}, {18, 20}, {47, 17}, {47, 10}, {8, 15}, {11, 16}, {47, 14}, {9, 26}, {41, 25}, {31, 27}, {15, 15}, {49, 18}, {3, 13}, {27, 13}, {13, 11}, {40, 30}, {0, 17}, {9, 19}, {44, 13}, {5, 16}, {7, 20}, {11, 29}, {46, 19}, {48, 19}, {4, 21}, {16, 20}, {40, 27}, {7, 19}, {12, 21}, {49, 21}, {48, 30}, {17, 16}, {50, 18}});

            // 51 secondes
            createProblem(201 , new int[][]{{18, 26}, {45, 27}, {49, 22}, {25, 16}, {17, 21}, {45, 24}, {1, 22}, {27, 21}, {21, 24}, {23, 30}, {45, 20}, {40, 13}, {16, 24}, {22, 25}, {45, 23}, {46, 16}, {38, 12}, {50, 11}, {22, 17}, {2, 20}, {22, 11}, {2, 10}, {35, 28}, {35, 14}, {15, 11}, {41, 24}, {50, 25}, {2, 20}, {50, 20}, {26, 17}, {28, 24}, {28, 28}, {41, 11}, {21, 18}, {48, 29}, {13, 23}, {24, 10}, {42, 28}, {4, 20}, {36, 22}});
        }

        /**
         * PROBLEMES DEMENTS > 1 min
         */

        if (run_insane_problem) {
            createProblem(287, new int[][]{{41, 3}, {4, 39}, {26, 15}, {48, 0}, {9, 15}, {16, 9}, {24, 36}, {21, 35}, {40, 21}, {36, 34}, {0, 4}, {35, 47}, {18, 47}, {27, 13}, {41, 41}, {20, 4}, {11, 37}, {21, 30}, {20, 49}, {15, 45}, {26, 10}, {5, 36}, {46, 47}, {39, 22}, {24, 27}, {15, 36}, {18, 40}, {28, 32}, {10, 46}, {26, 50}, {8, 3}, {38, 1}, {30, 15}, {38, 46}, {3, 44}, {49, 10}, {29, 20}, {38, 39}, {6, 12}, {0, 14}, {37, 5}, {37, 42}, {29, 28}});
            createProblem(411, new int[][]{{49, 31}, {2, 34}, {5, 47}, {8, 30}, {12, 37}, {43, 39}, {0, 36}, {48, 42}, {11, 49}, {22, 35}, {0, 46}, {31, 38}, {38, 48}, {50, 44}, {5, 48}, {25, 47}, {18, 42}, {25, 31}, {38, 41}, {50, 38}, {3, 46}, {13, 40}, {6, 41}, {11, 32}, {20, 36}, {46, 45}, {17, 48}, {4, 48}, {6, 42}, {35, 46}, {33, 44}, {20, 48}, {25, 49}, {40, 37}, {15, 45}, {16, 46}, {37, 34}, {26, 32}, {41, 39}, {30, 43}});


            // 39,7 secondes
            // createProblem(204 , new int[][]{{9, 15}, {16, 22}, {20, 22}, {9, 27}, {45, 18}, {13, 18}, {40, 21}, {41, 17}, {37, 15}, {39, 12}, {45, 25}, {34, 27}, {35, 13}, {15, 13}, {34, 17}, {10, 22}, {41, 30}, {5, 28}, {21, 20}, {27, 25}, {32, 26}, {23, 14}, {24, 10}, {30, 14}, {28, 20}, {16, 15}, {32, 23}, {19, 27}, {45, 18}, {45, 21}, {50, 15}, {25, 21}, {45, 30}, {6, 11}, {50, 20}, {18, 22}, {26, 27}, {39, 27}, {27, 30}, {10, 19}});

            // 81 secondes
            // createProblem(238 , new int[][]{{32, 24}, {32, 20}, {22, 13}, {14, 13}, {14, 12}, {3, 14}, {34, 30}, {33, 10}, {39, 24}, {44, 19}, {19, 23}, {7, 22}, {34, 28}, {49, 30}, {10, 30}, {23, 25}, {49, 19}, {27, 18}, {36, 28}, {46, 21}, {34, 21}, {46, 19}, {8, 18}, {13, 15}, {22, 28}, {12, 21}, {32, 10}, {41, 22}, {35, 15}, {8, 16}, {10, 21}, {45, 30}, {23, 28}, {43, 26}, {48, 15}, {42, 15}, {2, 14}, {35, 23}, {10, 30}, {7, 16}, {37, 11}, {4, 10}, {20, 21}, {40, 26}, {0, 21}, {24, 18}, {39, 20}});

            // 1200 secondes
            // createProblem(241 , new int[][]{{49, 21}, {1, 20}, {12, 25}, {25, 14}, {41, 30}, {0, 14}, {9, 27}, {10, 29}, {46, 15}, {38, 16}, {35, 27}, {15, 10}, {46, 27}, {6, 19}, {39, 29}, {17, 27}, {28, 27}, {0, 11}, {10, 18}, {43, 30}, {38, 15}, {26, 17}, {18, 15}, {50, 13}, {40, 21}, {2, 14}, {23, 29}, {0, 29}, {40, 21}, {23, 29}, {42, 17}, {44, 11}, {20, 20}, {27, 21}, {10, 28}, {5, 28}, {18, 10}, {8, 22}, {41, 30}, {32, 11}, {34, 14}, {35, 21}, {20, 13}, {25, 22}, {44, 12}, {17, 27}, {45, 20}});
        }
    }

    /**
     * Create and add a problem using a default name
     * @param capacity problem's weight
     * @param items problem's items information ([value, weight] list
     */
    private void createProblem(int capacity, int[][] items) {
        int problemId = problems.size();
        this.createProblem("Objects.Problem " + problemId, capacity, items);
    }

    /**
     * Create and add a problem using the given name
     * @param name problem's name
     * @param capacity problem's weight
     * @param items problem's items information ([value, weight] list
     */
    private void createProblem(String name, int capacity, int[][] items) {
        Problem problem = new Problem(name, capacity);
        problem.addItems(items);
        problems.add(problem);
    }

    /**
     * GETTERS
     */
    public ArrayList<Problem> getProblems() {
        return problems;
    }

    /**
     * SETTERS
     */
    public void setProblems(ArrayList<Problem> problems) {
        this.problems = problems;
    }
}
