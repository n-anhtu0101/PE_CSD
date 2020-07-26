
public class Main {

    public static void main(String[] args) {
        int[][] b = {
          // A  B  C  D  E  F  G  H  I  J  k
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},//A
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//B
            {0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0},//C
            {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},//D
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},//E
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0},//F
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},//G
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},//H
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},//I
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},//J
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0} //K
        };
        Graph g = new Graph();
        g.setData(b);
        System.out.println("1. Display adjacency matrix:");
        g.dispAdj();
        System.out.println();

        System.out.println("2. Test breadth-first traversal:");
        g.breadth(0);
        System.out.println();

        System.out.println("3. Test depth-first traversal:");
        g.depth(0);
        System.out.println();
    }

}
