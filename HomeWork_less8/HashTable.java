package HomeWork_less8;

public class HashTable {

    private ListLinked[] hashArray;
    private int size;


    public HashTable(int size) {
        this.size = size;
        this.hashArray = new ListLinked[size];
        for(int i=0; i<size; i++)
            hashArray[i] = new ListLinked();
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        DataItem dataItem = hashArray[hashVal].find(key);
        return dataItem;
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ".");
            hashArray[i].display();
        }
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(item);
    }


    private boolean ifFull() {
        //NO-OP
        return true;
    }


    private int getPrime(int currentHashTableSize) {
        for (int i = currentHashTableSize + 1; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private boolean isPrime(int i) {
        for (int j = 2; (j * j <= i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }


    private int hashFunc(int key) {
        return key % size;
    }
}
