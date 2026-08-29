// Design Circular Deque [LC - 641]

public class Q91 {

    static class MyCircularDeque{

        int front;
        int rear;
        int size;
        int capacity;
        int deque[];

        public MyCircularDeque(int k){
            deque = new int[k];
            front = 0;
            rear = k - 1;
            size = 0;
            capacity = k;
        }

        public boolean insertFront(int value){ // Current Index se piche jana
            if(isFull()){
                return false;
            }

            front = (front - 1 + capacity) % capacity;
            deque[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value){
            if(isFull()){
                return false;
            }

            rear = (rear + 1) % capacity;
            deque[rear] = value;
            size++;
            return true;
        }

        public boolean deleteFront(){ // Current Index se aage jana
            if(isEmpty()){
                return false;
            }

            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public boolean deleteLast(){
            if(isEmpty()){
                return false;
            }

            rear = (rear - 1 + capacity) % capacity; // This helps in not going back to negative index like -1 (Case: if both front and rear are in the 0th index)
            size--;
            return true; 
        }

        public int getFront(){
            if(isEmpty()){
                return -1;
            }
            return deque[front];
        }

        public int getRear(){
            if(isEmpty()){
                return -1;
            }

            return deque[rear];
        }

        public boolean isEmpty(){
            return (size == 0);
        }

        public boolean isFull(){
            return (size == capacity);
        }
    }

    public static void main(String[] args) {
        MyCircularDeque dq = new MyCircularDeque(3);

        System.out.println("insertLast(1): " + dq.insertLast(1));
        System.out.println("insertLast(2): " + dq.insertLast(2));
        System.out.println("insertFront(3): " + dq.insertFront(3));
        System.out.println("insertFront(4): " + dq.insertFront(4));

        System.out.println("getRear(): " + dq.getRear());
        System.out.println("isFull(): " + dq.isFull());

        System.out.println("deleteLast(): " + dq.deleteLast());

        System.out.println("insertFront(4): " + dq.insertFront(4));

        System.out.println("getFront(): " + dq.getFront());
        System.out.println("getRear(): " + dq.getRear());

        System.out.println("isEmpty(): " + dq.isEmpty());
    }
}

/* 
insertFront  → front moves backward
insertLast   → rear moves forward
deleteFront  → front moves forward
deleteLast   → rear moves backward
*/
