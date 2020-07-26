
public class Graph {
    
    int[][] a;
    int n;
    char[] v;
    
    Graph() {
        v = "ABCDEFGHIJKLMN".toCharArray();
    }
    //(1)

    void setData(int[][] b) {
        n = b.length;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }
    //(2)

    void dispAdj() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", a[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    void visit(int i) {
        System.out.print(v[i] + "(" + i + ")");
    }

    //(3)
    void breadth(boolean[] en, int i) {
        int r;
        MyQueue q = new MyQueue();
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            for (int j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }
    
    void breadth(int k) {
        boolean[] en = new boolean[n];
        for (int i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k);
    }
    //(4)

    void depth(boolean[] vis, int i) {
        visit(i);
        vis[i] = true;
        for (int j = 0; j < n; j++) {
            if (!vis[j] && a[i][j] > 0) {
                depth(vis, j);
            }
        }
    }
    
    void depth(int k) {
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            vis[i] = false;
        }
        depth(vis, k);
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                depth(vis, i);
            }
        }
    }
    
}
