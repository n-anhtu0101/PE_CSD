
public class MyList {

    Node head, tail;

    // (1)
    MyList() {
        head = tail = null;
    }

    // (2)
    boolean isEmpty() {
        return (head == null);
    }

    // (3)
    void clear() {
        head = tail = null;
    }

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

}
