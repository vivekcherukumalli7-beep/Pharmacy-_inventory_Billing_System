import java.util.*;

class Medicine {
    int id;
    String name;
    double price;
    int expiryDays; // days remaining

    Medicine(int id, String name, double price, int expiryDays) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiryDays = expiryDays;
    }

    public String toString() {
        return id + " " + name + " Rs:" + price + " ExpiryDays:" + expiryDays;
    }
}

// ===== Singly Linked List =====
class Node {
    Medicine data;
    Node next;
    Node(Medicine data) { this.data = data; }
}

class Inventory {
    Node head;

    void add(Medicine m) {
        Node newNode = new Node(m);
        newNode.next = head;
        head = newNode;
    }

    void display() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Linear Search
    Medicine linearSearch(int id) {
        Node temp = head;
        while(temp != null) {
            if(temp.data.id == id)
                return temp.data;
            temp = temp.next;
        }
        return null;
    }
}

// ===== Stack for Expression Evaluation =====
class Expression {
    static int evaluate(int a, int b, char op) {
        switch(op) {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return 0;
    }
}

// ===== Main Class =====
public class PharmaSystem {
    public static void main(String[] args) {

        Inventory inv = new Inventory();

        inv.add(new Medicine(401,"Paracetamol",10.5,30));
        inv.add(new Medicine(402,"Crocin",15.0,10));
        inv.add(new Medicine(403,"VitaminC",8.0,60));

        System.out.println("Medicine Inventory:");
        inv.display();

        System.out.println("\nSearching Medicine ID 402:");
        Medicine m = inv.linearSearch(402);
        if(m != null)
            System.out.println("Found: " + m);

        // ===== Priority Queue (Near Expiry First) =====
        PriorityQueue<Medicine> pq =
            new PriorityQueue<>((a,b) -> a.expiryDays - b.expiryDays);

        pq.add(new Medicine(501,"DrugA",20,5));
        pq.add(new Medicine(502,"DrugB",25,15));
        pq.add(new Medicine(503,"DrugC",30,2));

        System.out.println("\nNear Expiry Medicines:");
        while(!pq.isEmpty())
            System.out.println(pq.poll());
    }
}
