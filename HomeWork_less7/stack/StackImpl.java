package HomeWork_less7.stack;

public class StackImpl implements Stack {

    private int[] stack;
    private int size;
    private int top;

    public StackImpl(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public boolean isFull() {
        return (top == size - 1);
    }

    @Override
    public void push(int element) {
        stack[++top] = element;
    }

    @Override
    public int pop() {
        return stack[top--];
    }

    @Override
    public int peek() {
        return stack[top];
    }
}
