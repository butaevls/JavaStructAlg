package lessonFive.HomeWork_less5.pack;

import lessonFour.list.List;

import java.util.ArrayList;

public class PackApp {

    static Pack pack = new Pack(15);
    static int SIZE;
    static ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        items.add(new Item("Газ. плита", 2, 9));
        items.add(new Item("Табуретка", 3, 3));
        items.add(new Item("Печка", 5, 9));
        items.add(new Item("Спальник", 2, 6));
        items.add(new Item("Палатка", 8, 12));
        items.add(new Item("Матрас", 5, 3));
        items.add(new Item("Планшет", 2, 2));
        items.add(new Item("Фонарь", 1, 5));
        items.add(new Item("Нож", 1, 10));

        SIZE = items.size();

        recursAnagrammItems(items.size());

        System.out.println("Список предметов:");
        for (Item item : items) {
            System.out.println(String.format(" %s вес = %s стоимость = %s",item.getName(),item.getWeight(),item.getCost()));
        }
        System.out.println();

        items = pack.getPackItems();
        if (items != null) {
            System.out.println("В рюкзак грузоподъемностью = " + pack.getMaxWeight() + " взяли предметы:");
            for (Item item : items) {
                System.out.println(String.format(" %s вес = %s стоимость = %s", item.getName(), item.getWeight(), item.getCost()));
            }
            System.out.println("-------------------------------------");
            System.out.println(String.format("Общим весом = %s и стоимостью = %s", pack.getWeight(), pack.getCost()));
        } else {
            System.out.println("Нет подходящего предмета для рюкзака грузоподъемностью = " + pack.getMaxWeight());
        }

    }

    private static void recursAnagrammItems(int size) {
        if (size == 1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            recursAnagrammItems(size - 1);
            if (size == 2) {
                toPackItems();
            }
            change(size);
        }
    }

    private static void change(int size) {
        int position = SIZE - size;
        Item temp = items.get(position);
        items.remove(position);
        items.add(SIZE-1,temp);
    }

    public static void toPackItems() {
        ArrayList<Item> itemsToPack = new ArrayList<>(items);
        while (itemsToPack.size()>0) {
            ArrayList<Item> tmpItems = new ArrayList<>(itemsToPack);
            if (pack.getPackItems() == null) {
                if (sumWeight(tmpItems) <= pack.getMaxWeight()) {
                    pack.setPackItems(tmpItems);
                    pack.setWeight(sumWeight(tmpItems));
                    pack.setCost(sumCost(tmpItems));
                }
            } else {
                if (sumWeight(tmpItems) <= pack.getMaxWeight() && sumCost(tmpItems) > pack.getCost()) {
                    pack.setPackItems(tmpItems);
                    pack.setWeight(sumWeight(tmpItems));
                    pack.setCost(sumCost(tmpItems));
                }
            }
            itemsToPack.remove(0);
        }
    }

    public static int sumWeight(ArrayList<Item> items) {
        int weight = 0;
        for (Item item : items) {
            weight = weight + item.getWeight();
        }
        return weight;
    }

    public static int sumCost(ArrayList<Item> items) {
        int cost = 0;
        for (Item item : items) {
            cost = cost + item.getCost();
        }
        return cost;
    }
}