package Data_Structure;

class StackImplemetationClass {
    private int[] stack;
    private int size = 0;
    private int stackSize = 0;

    public StackImplemetationClass(int size) {
        stack = new int[size];
        stackSize = size;
    }

    public int pop() throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Empty Stack");
        } else {
            return stack[--size];
        }
    }

    public void insert(int value) throws IndexOutOfBoundsException {
        if (stackSize == size) {
            throw new IndexOutOfBoundsException("Stack full");
        } else {
            stack[size++] = value;
        }
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return stack[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            stack[i] = 0;
        }
    }

    public void printStack() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}

public class StackImplemetation {
    public static void main(String[] args) {
        StackImplemetationClass stack = new StackImplemetationClass(5);

        stack.insert(3);
        System.out.println("Inserted 3");
        System.out.println("Current Stack Size: " + stack.size());
        stack.printStack();

        System.out.println("Top Value: " + stack.peek());

        stack.insert(2);
        System.out.println("Inserted 2");

        System.out.println("Pop Top Value: " + stack.pop());

        stack.insert(1);
        System.out.println("Inserted 1");

        stack.printStack();
    }
}
