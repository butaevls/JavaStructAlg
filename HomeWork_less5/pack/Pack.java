package lessonFive.HomeWork_less5.pack;

import java.util.ArrayList;

public class Pack {

    private ArrayList<Item> packItems = null;
    private int maxWeight;
    private int weight;
    private int cost;

    public Pack(int maxWeight) {
        this.maxWeight = maxWeight;
        weight = 0;
        cost = 0;
    }

    public ArrayList<Item> getPackItems() {
        return this.packItems;
    }

    public void setPackItems(ArrayList<Item> packItems) {
        this.packItems = packItems;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
