class CNode {
    int data;
    CNode next;

    CNode(int data) {
        this.data = data;
        next = this;
    }
}

public class SinglyCircularLinkedList {
    CNode tail;

    public void insertAtFirst(int data) {
        CNode newNode = new CNode(data);
        if (tail == null) {
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    public void insertAtPos(int data, int pos) {
        if (pos < 1) return;
        CNode newNode = new CNode(data);
        if (tail == null) {
            tail = newNode;
        } else {
            CNode temp = tail.next;
            for (int i = 1; temp != tail && i < pos - 1; i++)
                temp = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;
            if (temp == tail) tail = newNode;
        }
    }

    public void insertAtLast(int data) {
        insertAtFirst(data);
        tail = tail.next;
    }

    public void deleteAtFirst() {
        if (tail == null) return;
        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
    }

    public void deleteAtPos(int pos) {
        if (tail == null || pos < 1) return;
        CNode temp = tail.next;
        for (int i = 1; temp != tail && i < pos - 1; i++)
            temp = temp.next;
        if (temp.next == tail) tail = temp;
        temp.next = temp.next.next;
    }

    public void deleteAtLast() {
        if (tail == null) return;
        CNode temp = tail.next;
        while (temp.next != tail)
            temp = temp.next;
        if (temp == tail) {
            tail = null;
        } else {
            temp.next = tail.next;
            tail = temp;
        }
    }

    public boolean search(int data) {
        if (tail == null) return false;
        CNode temp = tail.next;
        do {
            if (temp.data == data) return true;
            temp = temp.next;
        } while (temp != tail.next);
        return false;
    }

    public void display() {
        if (tail == null) return;
        CNode temp = tail.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyCircularLinkedList list = new SinglyCircularLinkedList();
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
