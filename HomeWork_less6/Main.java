package HomeWork6;

public class Main {
    public static void main(String[] args) {
        int a = 20;
        int b = 6;
        boolean isBalanced;
        int notbalanced;
        notbalanced = 0;
        Tree[] tree = new Tree[a];

        for (int i = 0; i < a; i++) {
            int level = 0;
            tree[i] = new Tree();
            while (level<b){
                int Random = (int)(Math.random() * 200) - 100;
                level = tree[i].insert(new Person(Random));
            }
        }

        for (int i = 0; i < a; i++) {
            System.out.print("Дерево № " + i + "  ");
            isBalanced = tree[i].isBalanced(false);
            if (!isBalanced) {
                notbalanced++;
                System.out.println("Несбалансировано");
            } else {
                System.out.println("Cбалансировано");
            }
        }
        System.out.println("Процент несбалансированных составляет " + notbalanced * 100 / a);
    }
}

