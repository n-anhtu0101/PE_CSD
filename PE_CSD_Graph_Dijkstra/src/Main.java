public class Main {

    public static void main(String[] args) {
//     int [][] b = {
//     {  0,   7,   9, 99, 99, 14},
//      {  7,   0, 10, 15, 99, 99},
//      {  9, 10,   0, 11, 99,   2},
//      {99, 15, 11,   0,   6, 99},
//      {99, 99, 99,   6,   0,   9},
//      {14, 99,   2, 99,   9,   0}
//      };
        int[][] b = {
            //A   B   C   D   E   F   G
            { 0, 25, 99, 10, 99, 99, 99}, //A
            {25,  0,  4, 12, 99, 99, 99}, //B
            {99,  4,  0, 99,  5, 99, 99}, //C
            {10, 12, 99,  0, 25, 99, 99}, //D
            {99, 99,  5, 25,  0, 10, 99}, //E
            {99, 99, 99, 99, 10,  0, 99}, //F
            {99, 99, 99, 99, 99, 99,  0}  //G
        };
     Graph g = new Graph();
     g.setData(b);
     System.out.println("1. Display adjacency matrix:");
     g.dispAdj();
     System.out.println();

     System.out.println("2. test breadth-first traversal");
     g.breadth(0);
     System.out.println();

     System.out.println("3. test Dijkstra's algorithm");
     g.dijkstra(0,5);
     System.out.println();
    }
    
}
