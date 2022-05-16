package princeton.dynamic_connectivity;

/*
* Find if an object "is connected to" another object,
* here "is connected to" is an equivalence relation: (Reflexive, Symmetric and Transitive).
*
* union(1, 3) -> connects 1 to 3
* connected(1, 3) -> returns true because there ia a connection between 1 and 3.
*
* connected components -> Maximal set of objects that are mutually connected
* {0} {1, 4, 5} {2, 3, 6, 7} -> connected components
* This is used to optimize the algorithm
* */
public class UnionFind {

    UnionFind(int n) {

    }

    /*
    * add connection between p and q
    * */
    void union(int p, int q) {

    }

    /*
    * are p and q in the same component
    * */
    boolean isConnected(int p, int q) {
        return false;
    }

    /*
    * component identifier for the p
    * */
    int find(int p) {
        return 1;
    }

    // no of components
    int count() {
        return 0;
    }
}
