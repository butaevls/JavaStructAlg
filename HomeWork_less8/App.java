package HomeWork_less8;

public class App {

    public static void main(String[] args) {
        int key;
        DataItem dataItem;
        int size = 5;
        int items = 8;

        HashTable hashTable = new HashTable(size);
        dataItem = new DataItem(5,100);
        hashTable.insert(dataItem);
        dataItem = new DataItem(5,500);
        hashTable.insert(dataItem);
        dataItem = new DataItem(106,32);
        hashTable.insert(dataItem);
        dataItem = new DataItem(21,456);
        hashTable.insert(dataItem);
        dataItem = new DataItem(67,789);
        hashTable.insert(dataItem);
        dataItem = new DataItem(98,800);
        hashTable.insert(dataItem);
        dataItem = new DataItem(50,230);
        hashTable.insert(dataItem);

        hashTable.display();
        hashTable.delete(50);
        System.out.println();
        hashTable.display();

        dataItem = hashTable.find(21);
        if (dataItem != null){
            System.out.println(dataItem.getKey() + "," + dataItem.getData());
        } else {
            System.out.println("null");
        }

    }
}
