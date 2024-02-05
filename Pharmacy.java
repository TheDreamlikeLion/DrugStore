package DrugStore;

import DrugStore.Components.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pharmacy implements Iterator<Component>, Comparable<Pharmacy> {

    private String name;
    private List<Component> components;
    private int idx;

    public Pharmacy(String name) {
        this.name = name;
        this.components = new ArrayList<>();
        this.idx = 0;
    }

    public String getName() {
        return name;
    }

    public Pharmacy addComponent(Component item) {
        components.add(item);
        return this;
    }

    public double getConcentration () {
        int maxPower = 0;
        double weight = 0;
        double totalWeight = 0;
        for (Component c : components) {
            if (c.getPower() > maxPower) {
                maxPower = c.getPower();
                weight = c.getWeight();
            }
            totalWeight += c.getWeight();
        }
        return (Math.round((weight / totalWeight )*100)/100.0);
    }

    public int getInterPower() {
        int interPower = 0;
        for (Component c : components) {
            interPower += (int) (c.getPower() * c.getWeight());
        }
        return interPower;

    }

    public int getTotalPower() {
        int totalPower = 0;
        for (Component c : components) {
            totalPower += c.getPower();
        }
        return totalPower;
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (Component c : components) {
            totalWeight += (int) (c.getWeight());
        }
        return totalWeight;
    }

    @Override
    public boolean hasNext() {
        return idx < components.size();
    }

    @Override
    public Component next() {
        return components.get(idx++);
    }

    @Override
    public int compareTo(Pharmacy o) {
//        if (this.getInterPower() > o.getInterPower()) return 1;
//        else if (this.getInterPower() < o.getInterPower()) return -1;
//        else return 0;
        return Integer.compare(this.getInterPower(), o.getInterPower());
    }

    @Override
    public String toString() {
        return String.format("\nPharmacy: %s (%s), interPower: %s, total power: %d, total weight: %d", this.getName(), this.getConcentration(), this.getInterPower(), this.getTotalPower(), this.getTotalWeight());
    }
}