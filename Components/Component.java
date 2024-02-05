package DrugStore.Components;

public abstract class Component implements Comparable<Component> {
    private String title;
    private double weight;
    private int power;

    public Component(String title, double weight, int power) {
        this.title = title;
        this.weight = weight;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, power: %s\n", this.title, this.power);
    }

    @Override
    public int compareTo(Component component) {
//        if (this.power > component.power) return 1;
//        else if (this.power < component.power) return -1;
//        else return 0;
        return Integer.compare(this.power, component.power);
    }
}
