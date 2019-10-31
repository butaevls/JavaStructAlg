package HomeWork_less8;

public class DataItem {
    private int data;
    private int key;

    public DataItem next;

    public DataItem(int key, int data) {
        this.key = key;
        this.data = data;
        next = null;
    }

    public int getKey() {
        return key;
    }

    public int getData() {
        return data;
    }

    public void display() {
        System.out.print(" -> " + data);
    }
}
