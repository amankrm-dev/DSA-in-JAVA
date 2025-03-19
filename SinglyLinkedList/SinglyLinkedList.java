class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class SinglyLinkedList {
    Node head;

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtPos(int data, int pos) {
        if (pos < 1) return;
        Node newNode = new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public void deleteAtFirst() {
        if (head == null) return;
        head = head.next;
    }

    public void deleteAtPos(int pos) {
        if (head == null || pos < 1) return;
        if (pos == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null) return;
        temp.next = temp.next.next;
    }

    public void deleteAtLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
    }

    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFirst(10);
        list.insertAtLast(20);
        list.insertAtPos(15, 2);
        list.display();
        list.deleteAtFirst();
        list.deleteAtLast();
        list.display();
        System.out.println("Search 15: " + list.search(15));
    }
}
