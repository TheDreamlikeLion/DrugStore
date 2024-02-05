# DrugStore
Java OOP

## Задание:
1. Добавить интерфейс Copmparable<Pharmacy> к классу Pharmacy. Переопределить метод compareTo()
подсказка: можно добавить, а можно не добавлять в класс поля;
2. Создать несколько экземпляров Pharmacy, добавить их в ArrayList, написать метод, выводящий Pharmacy в отсортированном виде.
3*. (усложненное, не обязательное) Постараться написать еще 1 метод сортировки лекарств, но уже по другому параметру.

## Решение:
## 1.
Изменен класс Pharmacy, переопределен метод compareTo:
...
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

## 2-3.
Добавлены несколько экземпляров класса Pharmacy, добавлены в ArrayList:
        Pharmacy nelechin = new Pharmacy("Nelechin");
        Pharmacy nebolin = new Pharmacy("Nebolin");
        Pharmacy vseproydin = new Pharmacy("VseProydin");
        Pharmacy iscelin = new Pharmacy("Iscelin");
        Pharmacy solyanin = new Pharmacy("Solyanin");

        nelechin.addComponent(new Water("Water", 120, 0));
        nelechin.addComponent(new Salt("Salt", 40, 10));

        nebolin.addComponent(new Penicilin("Penicilin50", 80, 50));
        nebolin.addComponent(new Water("Water", 60, 0));
        nebolin.addComponent(new Salt("Salt", 10, 10));

        vseproydin.addComponent(new Penicilin("Penicilin200", 45, 200));
        vseproydin.addComponent(new Water("Water", 110, 0));
        vseproydin.addComponent(new Salt("Salt", 30, 10));

        iscelin.addComponent(new Penicilin("Penicilin1000", 150, 1000));
        iscelin.addComponent(new Water("Water", 80, 0));
        iscelin.addComponent(new Salt("Salt", 30, 10));

        solyanin.addComponent(new Penicilin("Penicilin200", 20, 200));
        solyanin.addComponent(new Water("Water", 80, 0));
        solyanin.addComponent(new Salt("Salt", 200, 10));

        List<Pharmacy> pharmacies = new ArrayList<>();
        pharmacies.add(nelechin);
        pharmacies.add(nebolin);
        pharmacies.add(vseproydin);
        pharmacies.add(iscelin);
        pharmacies.add(solyanin);

Для сортировки используем интерфейс MySorter с несколькими способами сортировки:
public interface MySorter {
    void sortByInterPower(List<Pharmacy> pharmacies);
    default void sortByConcentration(List<Pharmacy> pharmacies) {
        pharmacies.sort(Comparator.comparingDouble(Pharmacy::getConcentration));
        System.out.println(pharmacies);
    }
    default void sortByTotalPower(List<Pharmacy> pharmacies) {
        pharmacies.sort(Comparator.comparingInt(Pharmacy::getTotalPower));
        System.out.println(pharmacies);
    }
    default void sortByTotalWeight(List<Pharmacy> pharmacies) {
        pharmacies.sort(new PharmacyComparator());
        System.out.println(pharmacies);
    }
}

Используем сортер в лямбда-функции:
  final MySorter sorter = pharmacy -> {
      Collections.sort(pharmacy);
      System.out.println(pharmacy);
  };

  System.out.println("\n Отсортировано по приведенной силе компонентов:\n****************************************************\n");
  sorter.sortByInterPower(pharmacies);
  System.out.println("\n Отсортировано по суммарной силе компонентов:\n****************************************************\n");
  sorter.sortByTotalPower(pharmacies);
  System.out.println("\n Отсортировано по суммарному весу компонентов:\n****************************************************\n");
  sorter.sortByTotalWeight(pharmacies);
  System.out.println("\n Отсортировано по концентрации основного компонента:\n****************************************************\n");
  sorter.sortByConcentration(pharmacies);
  
