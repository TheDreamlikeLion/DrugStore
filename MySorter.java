package DrugStore;

import java.util.Comparator;
import java.util.List;
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