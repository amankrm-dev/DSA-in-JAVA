public class StackArray {
    int[] stackArr;
    int size, capacity;

    public StackArray(int capacity) {
        this.capacity = capacity;
        stackArr = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int data) {
        if (size == capacity) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArr[size] = data;
        size++;
    }

    public int pop() {
        if (size <= 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stackArr[--size];
    }

    public int peek() {
        if (size <= 0) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stackArr[size - 1];
    }

    public boolean search(int data) {
        for (int i = 0; i < size; i++) {
            if (stackArr[i] == data) return true;
        }
        return false;
    }

    public void display() {
        if (size <= 0) {
            System.out.println("Stack is Empty");
            return;
        }
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.display();
        System.out.println("Search 20: " + stack.search(20));
        System.out.println("Search 50: " + stack.search(50));
    }
}
