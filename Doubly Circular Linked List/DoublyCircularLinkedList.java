class DCNode {
    int data;
    DCNode prev, next;

    DCNode(int data) {
        this.data = data;
        prev = next = this;
    }
}

public class DoublyCircularLinkedList {
    DCNode tail;

    public void insertAtFirst(int data) {
        DCNode newNode = new DCNode(data);
        if (tail == null) {
            tail = newNode;
        } else {
            newNode.next = tail.next;
            newNode.prev = tail;
            tail.next.prev = newNode;
            tail.next = newNode;
        }
    }

    public void insertAtPos(int data, int pos) {
        if (pos < 1) return;
        DCNode newNode = new DCNode(data);
        if (tail == null) {
            tail = newNode;
        } else {
            DCNode temp = tail.next;
            for (int i = 1; temp != tail && i < pos - 1; i++)
                temp = temp.next;
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
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
            tail.next.prev = tail;
        }
    }

    public void deleteAtLast() {
        if (tail == null) return;
        DCNode temp = tail.next;
        while (temp.next != tail) {
            temp = temp.next;
        }
        if (temp == tail.next) {
            tail = null;
        } else {
            temp.prev.next = tail.next;
            tail = temp.prev;
        }
    }

    public void deleteAtPos(int pos) {
        if (tail == null || pos < 1) return;
        DCNode temp = tail.next;
        for (int i = 1; temp != tail && i < pos; i++) {
            temp = temp.next;
        }
        if (temp == tail.next) {
            deleteAtFirst();
        } else if (temp == tail) {
            deleteAtLast();
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public boolean search(int data) {
        if (tail == null) return false;
        DCNode temp = tail.next;
        do {
            if (temp.data == data) return true;
            temp = temp.next;
        } while (temp != tail.next);
        return false;
    }

    public void display() {
        if (tail == null) return;
        DCNode temp = tail.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
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
