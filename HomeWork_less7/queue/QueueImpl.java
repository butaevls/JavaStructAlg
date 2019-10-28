package HomeWork_less7.queue;

public class QueueImpl implements Queue {

//    2    3   4   5   6      7     8

//    front                         rear

    private int front;
    private int rear;

    private int[] queue;
    private int items;
    private int maxSize;

    public QueueImpl(int size) {
        this.queue = new int[size];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
        this.maxSize = size;
    }

    @Override
    public boolean isEmpty() {
        return (items == 0);
    }

    @Override
    public boolean isFull() {
        return (items == maxSize);
    }

    @Override
    public int size() {
        return items;
    }

    @Override
    public void insert(int i) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = i;
        items++;
    }

    @Override
    public int remove() {
        int template = queue[front++];
        if (front == maxSize) {
            front = 0;
        }
        items--;
        return template;
    }

    @Override
    public int peek() {
        return queue[front];
    }
}
