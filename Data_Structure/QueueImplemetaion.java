package Data_Structure;

class QueueImplemetaionArray {
    private int[] queue;
    private int size = 0;
    private int queueSize = 0;

    public QueueImplemetaionArray(int size) {
        this.queue = new int[size];
        this.queueSize = size;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return queue[0];
    }

    public Integer dequeue() {
        if (size == 0) {
            return null;
        } else {
            int value = queue[0];
            for (int i = 1; i < size; i++) {
                queue[i - 1] = queue[i];
            }
            size--;
            return value;
        }
    }

    public Integer poll() {
        return dequeue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        if (size == queueSize) {
            throw new IndexOutOfBoundsException("Queue is full");
        } else {
            queue[size++] = value;
        }
    }

}

public class QueueImplemetaion {
    public static void main(String[] args) {
        QueueImplemetaionArray queue = new QueueImplemetaionArray(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue size after enqueue: " + queue.size());

        Integer front = queue.peek();
        System.out.println("Front element (peek): " + (front != null ? front : "Queue is empty"));

        Integer polled = queue.poll();
        System.out.println("Polled element: " + (polled != null ? polled : "Queue is empty"));

        System.out.println("Queue size after poll: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Peek after empty: " + (queue.peek() != null ? queue.peek() : "Queue is empty"));

        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Queue size after enqueueing more elements: " + queue.size());
        queue.enqueue(60);
        System.out.println("Peek now: " + queue.peek());
    }
}
