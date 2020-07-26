
public class Main {

    public static void main(String[] args) {
        int[][] b = {
            {0, 2, 0, 0},//A
            {2, 0, 1, 1},//B
            {0, 1, 0, 1},//C
            {0, 1, 1, 0},//D
        };
        Graph g = new Graph();
        g.setData(b);
        System.out.println("1. Display adjacency matrix:");
        g.dispAdj();
        System.out.println();

        System.out.println("2. test breadth-first traversal");
        g.breadth(0);
        System.out.println();

        System.out.println("3. test Euler'cycle");
        g.eulerCycle(1);
        System.out.println();
    }

}
