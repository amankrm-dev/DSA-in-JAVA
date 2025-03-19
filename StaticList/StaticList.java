public class StaticList {
    int arr[];
    int size;

    public StaticList(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public void insertAtFirst(int data) {
        if (size == arr.length) {
            System.out.println("List is full");
            return;
        }
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = data;
        size++;
    }

    public void insertAtPos(int data, int pos) {
        if (size == arr.length || pos < 1 || pos > size + 1) {
            System.out.println("Invalid position or list full");
            return;
        }
        for (int i = size; i >= pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos - 1] = data;
        size++;
    }

    public void insertAtLast(int data) {
        if (size == arr.length) {
            System.out.println("List is full");
            return;
        }
        arr[size++] = data;
    }

    public void deleteAtFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void deleteAtPos(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");
            return;
        }
        for (int i = pos - 1; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void deleteAtLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        size--;
    }

    public boolean search(int data) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == data) return true;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StaticList list = new StaticList(10);
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
