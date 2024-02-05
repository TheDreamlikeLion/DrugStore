package DrugStore;

import java.util.Comparator;

public class PharmacyComparator implements Comparator<Pharmacy> {

    @Override
    public int compare(Pharmacy pharmacy1, Pharmacy pharmacy2) {
        return Integer.compare(pharmacy1.getTotalWeight(), pharmacy2.getTotalWeight());
    }
}