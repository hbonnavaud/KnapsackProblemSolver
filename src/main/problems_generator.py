from random import randint

nb_problems = 5

#  Generate objects in range :
min_objs = 30
max_objects = 50

# Generate item's value in range
min_value = 0
max_value = 50

# Generate item's weights in range
min_weight = 10
max_weight = 30

# Proportion de la capacité du sac par rapport à la somem des poids
weight_ratio = 1/4

def main():
    for i in range(nb_problems):
        generateProblem()


def generateProblem():
    items = []
    nb_items = randint(min_objs, max_objects)
    for n in range(nb_items):
        items.append([randint(min_value, max_value), randint(min_weight, max_weight)])

    poid_totale = 0
    for item in items:
        poid_totale += item[1]

    w = int(weight_ratio * poid_totale)

    result = "createProblem(" + str(w) + " , new int[][]{"

    first = True
    for item in items:
        if not first:
            result += ", "
        else:
            first = False
        result += "{" + str(item[0]) + ", " + str(item[1]) + "}"

    result += "});"
    print(result)

main()