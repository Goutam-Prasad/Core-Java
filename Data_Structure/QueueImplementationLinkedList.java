package Data_Structure;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

}

class QueueImplementationUsingLinkedList {

    private Node front;
    private Node rear;
    private int size;

    public QueueImplementationUsingLinkedList() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public int insert(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return value;
    }

    public int size() {
        return size;
    }

    public Integer peek() {
        if (front == null) {
            return null;
        }
        return front.value;
    }

    public Integer dequeue() {
        if (front == null) {
            return null;
        }
        int value = front.value;
        if (front == rear) {
            rear = null;
        }
        front = front.next;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}

public class QueueImplementationLinkedList {
    public static void main(String[] args) {
        QueueImplementationUsingLinkedList queue = new QueueImplementationUsingLinkedList();

        System.out.println("Is queue empty? " + queue.isEmpty()); // true
        System.out.println("Queue size: " + queue.size()); // 0

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);

        System.out.println("Is queue empty? " + queue.isEmpty()); // false
        System.out.println("Queue size: " + queue.size()); // 3
        System.out.println("Peek: " + queue.peek()); // 10

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        System.out.println("Dequeued: " + queue.dequeue()); // 20
        System.out.println("Peek after dequeue: " + queue.peek()); // 30
        System.out.println("Queue size after dequeue: " + queue.size()); // 1

        System.out.println("Dequeued: " + queue.dequeue()); // 30
        System.out.println("Is queue empty after dequeuing all? " + queue.isEmpty()); // true
        System.out.println("Peek after emptying queue: " + queue.peek()); // null
        System.out.println("Dequeue from empty queue: " + queue.dequeue()); // null

        queue.insert(40);
        System.out.println("Peek after inserting into empty queue: " + queue.peek()); // 40
        System.out.println("Queue size: " + queue.size()); // 1
        System.out.println("Is queue empty? " + queue.isEmpty()); // false
    }
}