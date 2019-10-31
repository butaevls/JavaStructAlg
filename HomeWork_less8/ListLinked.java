package HomeWork_less8;

public class ListLinked {
    private DataItem first;

    public ListLinked() {
        this.first = null;
    }

    public void insert(DataItem dataItem){
        int data = dataItem.getData();
        DataItem prev = null;
        DataItem cur = first;
        while( cur != null && data > cur.getData()) {
            prev = cur;
            cur = cur.next;
        }
        if(prev == null) {
            first = dataItem;
        }
        else {
            prev.next = dataItem;
        }
        dataItem.next = cur;
    }

    public void delete(int key) {
        DataItem prev = null;
        DataItem cur = first;
        while( cur != null && key != cur.getKey() ) {
            prev = cur;
            cur = cur.next;
        }
        if(prev == null)
            first = first.next;
        else{
            prev.next = cur.next;
        }
    }

    public DataItem find(int key)
    {
        DataItem current = first;
        while(current != null && current.getKey() <= key) {
            if(current.getKey() == key)
                return current;
            current = current.next;
        }
        return null;
    }

    public void display()
    {
        DataItem current = first;
        while(current != null)
        {
            current.display();
            current = current.next;
        }
        System.out.println("");
    }
}
