//  Design Circular Queue [LC - 622]

public class Q82 {

    static class MyCircularQueue {

        private final int[] arr;
        private final int size;
        private int front;
        private int rear;

        public MyCircularQueue(int k) {
            arr = new int[k];
            size = k;
            front = -1;
            rear = -1;
        }

        // Insert an element into the circular queue
        public boolean enQueue(int value) {

            if (isFull()) {
                return false;
            }

            // Adding the first element
            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = value;

            return true;
        }

        // Delete an element from the circular queue
        public boolean deQueue() {

            if (isEmpty()) {
                return false;
            }

            // Only one element present
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return true;
        }

        // Get the front element
        public int Front() {

            if (isEmpty()) {
                return -1;
            }

            return arr[front];
        }

        // Get the rear element
        public int Rear() {

            if (isEmpty()) {
                return -1;
            }

            return arr[rear];
        }

        // Check whether the queue is empty
        public boolean isEmpty() {
            return front == -1;
        }

        // Check whether the queue is full
        public boolean isFull() {
            return (rear + 1) % size == front;
        }
    }

    public static void main(String[] args) {

        MyCircularQueue q = new MyCircularQueue(3);

        System.out.println(q.enQueue(10)); // true
        System.out.println(q.enQueue(20)); // true
        System.out.println(q.enQueue(30)); // true

        System.out.println(q.enQueue(40)); // false (Queue Full)

        System.out.println("Front : " + q.Front()); // 10
        System.out.println("Rear  : " + q.Rear());  // 30

        System.out.println(q.deQueue()); // true

        System.out.println("Front : " + q.Front()); // 20

        System.out.println(q.enQueue(40)); // true

        System.out.println("Rear  : " + q.Rear()); // 40

        while (!q.isEmpty()) {
            System.out.println("Front = " + q.Front());
            q.deQueue();
        }

        System.out.println(q.deQueue()); // false
    }
}