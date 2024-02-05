package DrugStore;

import DrugStore.Components.Penicilin;
import DrugStore.Components.Salt;
import DrugStore.Components.Water;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
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

//        getPharmaciesSortedByInterPower(pharmacies);
//
//        getPharmaciesSortedByTotalPower(pharmacies);
//
//        getPharmaciesSortedByTotalWeight(pharmacies, new PharmacyComparator());

        final MySorter sorter = pharmacy -> {
            Collections.sort(pharmacy);
            System.out.println(pharmacy);
        };

        System.out.println("\n Отсортировано по приведенной силе компонента:\n****************************************************\n");
        sorter.sortByInterPower(pharmacies);
        //System.out.println(pharmacies);
        System.out.println("\n Отсортировано по суммарной силе компонентов:\n****************************************************\n");
        sorter.sortByTotalPower(pharmacies);
        System.out.println("\n Отсортировано по суммарному весу компонентов:\n****************************************************\n");
        sorter.sortByTotalWeight(pharmacies);
        System.out.println("\n Отсортировано по концентрации основного компонента:\n****************************************************\n");
        sorter.sortByConcentration(pharmacies);
    }

//    private static void getPharmaciesSortedByInterPower(List<Pharmacy> pharmacies) {
//        Collections.sort(pharmacies);
//        System.out.println(pharmacies);
//    }
//
//    private static void getPharmaciesSortedByTotalPower(List<Pharmacy> pharmacies) {
////        pharmacies.sort((ph1, ph2) -> Integer.compare(ph1.getTotalPower(), ph2.getTotalPower()));
//        pharmacies.sort(Comparator.comparingInt(Pharmacy::getTotalPower));
//        System.out.println(pharmacies);
//    }
//
//    private static void getPharmaciesSortedByTotalWeight(List<Pharmacy> pharmacies, Comparator<Pharmacy> comparator) {
//        pharmacies.sort(comparator);
//        System.out.println(pharmacies);
//    }
}