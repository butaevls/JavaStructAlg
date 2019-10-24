package HomeWork6;

public class Node {

    Person person;
    Node leftChild;
    Node rightChild;

    void display() {
        System.out.println("Значение " + person.id);
    }
}
