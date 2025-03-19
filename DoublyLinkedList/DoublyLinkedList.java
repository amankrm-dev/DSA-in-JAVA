class DNode {
    int data;
    DNode prev, next;

    DNode(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class DoublyLinkedList {
    DNode head;

    public void insertAtFirst(int data) {
        DNode newNode = new DNode(data);
        if (head != null) head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void insertAtPos(int data, int pos) {
        if (pos < 1) return;
        DNode newNode = new DNode(data);
        if (pos == 1) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            return;
        }
        DNode temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;
        if (temp == null) return;
        newNode.next = temp.next;
        if (temp.next != null) temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
    }

    public void insertAtLast(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void deleteAtFirst() {
        if (head == null) return;
        head = head.next;
        if (head != null) head.prev = null;
    }

    public void deleteAtPos(int pos) {
        if (head == null || pos < 1) return;
        DNode temp = head;
        for (int i = 1; temp != null && i < pos; i++)
            temp = temp.next;
        if (temp == null) return;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (pos == 1) head = temp.next;
    }

    public void deleteAtLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        DNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.prev.next = null;
    }

    public boolean search(int data) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
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
