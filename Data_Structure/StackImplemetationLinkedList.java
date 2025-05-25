package Data_Structure;


class StackLinkedList {
    private Node top;
    private int size;

    public StackLinkedList() {
        this.top = null;
        this.size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class StackImplemetationLinkedList {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        System.out.println("Pushing values: 10, 20, 30");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Current Stack Size: " + stack.size());
        stack.printStack();

        System.out.println("Top Value: " + stack.peek());

        System.out.println("Popping top value: " + stack.pop());
        System.out.println("After pop:");
        stack.printStack();

        System.out.println("Pushing 40");
        stack.push(40);
        stack.printStack();

        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
    }
}
