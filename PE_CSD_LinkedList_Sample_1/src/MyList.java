/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;

class MyList {

    Node head, tail;

    // (4) thêm phần tử vào cuối danh sách
    void addLast(Person x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    // (5)
    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    // (6)
    void traverse() {
        Node f = head;
        while (f != null) {
            visit(f);
            f = f.next;
        }
        System.out.println();
    }

    // (7) optional
    void addMany(String[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (8)
    Node searchByName(String xName) {
        Node f = head;
        while (f != null) {
            if (f.info.name.equalsIgnoreCase(xName)) {
                return f;
            }
            f = f.next;
        }
        return null;
    }

    // (9) //Thêm một node vào danh sách
    void addFirst(Person x) {
//        Node p = new Node(x);
//        p.next = head;
//        head = p;
        head = new Node(x, head);//tao head moi co info la x va co next head cu
        if (tail == null) {
            tail = head;
        }
    }

    // (10)//insert 1 node p after q
    void insertAfter(Node q, Person x) {
        if (q == null) {
            return;
        }
        Node p = new Node(x);
        Node qNext = q.next;
        p.next = qNext;
        q.next = p;
        if (q == tail) {
            tail = p;
        }
    }

    // (11)//insert 1 node p before q
    void insertBefore(Node q, Person x) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;//khong tim thay node q
        }
        insertAfter(f, x);
    }

    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    // (12)
    void remove(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;//ko tim thay q
        }
        Node qNext = q.next;
        f.next = qNext;
        if (f.next == null) {
            tail = f;
        }
    }

    // (13)
    void remove(String xName) {
        Node p = searchByName(xName);
        remove(p);
    }

    Node searchByAge(int xAge) {
        Node f = head;
        while (f != null) {
            if (f.info.age == xAge) {
                return f;
            }
            f = f.next;
        }
        return null;
    }

    // (14)
    void remove(int xAge) {
        Node f = searchByAge(xAge);
        remove(f);
    }

    // (15)
    void removeAll(int xAge) {
        Node f = head;
        while (f != null) {
            if (f.info.age == xAge) {
                remove(f);
            }
            f = f.next;
        }
    }

    // (16) tra ve node vi tri k
    Node pos(int k) {
        Node f = head;
        int i = 0;
        while (f != null) {
            if (i == k) {
                return f;
            }
            i++;
            f = f.next;
        }
        return (null);
    }

    // (17)
    void removePos(int k) {
        Node f = pos(k);
        remove(f);
    }

    // (18)
    void sortByName() {
        Node pi, pj;
        pi = head;
        Person temp;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.name.compareTo(pj.info.name) > 0) {
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (19)
    void sortByAge() {
        Node pi, pj;
        pi = head;
        Person temp;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.age > pj.info.age) {
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (20)
    int size() {
        int count = 0;
        Node f = head;
        while (f != null) {
            count++;
            f = f.next;
        }
        return count;
    }

    // (21)
    Person[] toArray() {
        int size = size();
        Person[] p = new Person[size];
        Node f = head;
        for (int i = 0; i < size; i++) {
            p[i] = f.info;
            f = f.next;
        }
        return p;
    }

    // (22)
    void reverse() {
        MyList temp = new MyList();
        Node f = head;
        while (f != null) {
            temp.addFirst(f.info);
            f = f.next;
        }
        head = temp.head;
        tail = temp.tail;
    }

    // (23) 
    Node findMaxAge() {
        Node f = head;
        Node maxAge = head;
        while (f != null) {
            if (f.info.age > maxAge.info.age) {
                maxAge = f;
            }
            f = f.next;
        }
        return maxAge;
    }

    // (24) 
    Node findMinAge() {
        Node f = head;
        Node minAge = head;
        while (f != null) {
            if (f.info.age < minAge.info.age) {
                minAge = f;
            }
            f = f.next;
        }
        return minAge;
    }

    // (24) 
    void setData(Node p, Person x) {
        if (p != null) {
            p.info = x;
        }
    }

    // (26) 
    void sortByAge(int k, int h) {
        int size = size();
        if (k > h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        if (h > size()) {
            h = size;
        }

        Node star = pos(k);
        Node end = pos(h);
        Node pj;
        Person temp;
        while (star != end) {
            pj = star.next;
            while (pj != end.next) {
                if (star.info.age > pj.info.age) {
                    temp = star.info;
                    star.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            star = star.next;
        }
    }

    // (27) // reverse from k to h 
    void reverse(int k, int h) {
        Person[] p = toArray();
        Person temp;
        while (k < h) {
            Node ni = pos(k);
            Node nj = pos(h);

            temp = ni.info;
            ni.info = nj.info;
            nj.info = temp;

            k++;
            h--;
        }
    }

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadDataToLast(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("person.txt", k);
        int[] b = Lib.readLineToIntArray("person.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i]);
        }
    }

    void loadDataToFirst(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("person.txt", k);
        int[] b = Lib.readLineToIntArray("person.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addFirst(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xName, int xAge) {//You should write here appropriate statements to complete this function.
        if (xName.charAt(0) == 'B') {
            return;
        } else {
            addLast(new Person(xName, xAge));
        }

    }

    void addFirst(String xName, int xAge) {//You should write here appropriate statements to complete this function.
        if (xName.charAt(0) == 'B') {
            return;
        } else {
            addFirst(new Person(xName, xAge));
        }
    }

//=================================================================
    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadDataToLast(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f2() throws Exception {/* You do not need to edit this function. Your task is to complete the addFirst  function
        above only.
         */
        clear();
        loadDataToFirst(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f3() throws Exception {
        clear();
        loadDataToLast(4);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);

        MyList h = new MyList();
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node f = head;
        while (f != null) {
            if (f.info.age > 4) {
                h.addLast(f.info);
            }
            f = f.next;
        }

        //-------------------------------------------------------------------------------------
        h.ftraverse(f123);
        f123.close();

    }

//=================================================================
    void f4() throws Exception {
        clear();
        loadDataToLast(4);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node f = head;
        while (f != null) {
            if (f.info.age < 6) {
                remove(f);
                break;
            }
            f = f.next;
        }

        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f5() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sortByName();
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f6() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        reverse();
        //--------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f7() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        MyList h = new MyList();
        h.loadDataToLast(7);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node f = h.head;
        while (f != null) {
            addLast(f.info);
            f = f.next;
        }
//        addLast(new Person("D4", 19));
//        addLast(new Person("D6", 13));
//        addLast(new Person("D3", 17));

        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f8() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f8.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        int k = 3;
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        removePos(3);
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f9() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f9.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        String xName = "C6";
        String yName = "CX";
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node f = head;
        while (f != null) {
            if (f.info.name.equalsIgnoreCase(xName)) {
                f.info.name = yName;
                break;
            }
            f = f.next;
        }
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }
}
