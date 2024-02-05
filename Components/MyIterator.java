package DrugStore.Components;

import DrugStore.PharmacyIterable;

import java.util.Iterator;

public class MyIterator implements Iterator<Component> {
    private PharmacyIterable pharmacyIterable;
    private int idx;

    public MyIterator(PharmacyIterable pharmacyIterable) {
        this.pharmacyIterable = pharmacyIterable;
        this.idx = pharmacyIterable.getIndex();
    }

    @Override
    public boolean hasNext() {
        return pharmacyIterable.getIndex() < pharmacyIterable.getSize() - 1;
    }

    @Override
    public Component next() {
        idx++;
        pharmacyIterable.setIndex(idx);
        return pharmacyIterable.getComponents().get(idx);
    }
}