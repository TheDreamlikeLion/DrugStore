package DrugStore;

import DrugStore.Components.Component;
import DrugStore.Components.MyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PharmacyIterable implements Iterable<Component>, Comparable<PharmacyIterable> {
    private List<Component> components;
    private int idx;
    private int size = 0;

    public PharmacyIterable() {
        this.components = new ArrayList<>();
        this.idx = 0;
    }

    public PharmacyIterable addComponent(Component item) {
        size++;
        components.add(item);
        return this;
    }

    public void setIndex(int idx) {
        this.idx = idx;
    }

    public int getSize() {
        return size;
    }

    public List<Component> getComponents() {
        return components;
    }

    public Component getComponent(int idx) {
        return components.get(idx);
    }

    @Override
    public Iterator<Component> iterator() {
//        return new Iterator<>() {
//            @Override
//            public boolean hasNext() {
//                return idx < components.size();
//            }
//
//            @Override
//            public Component next() {
//                return components.get(idx++);
//            }
//        };
        return new MyIterator(this);
    }

    public int getIndex() {
        return idx;
    }

    @Override
    public int compareTo(PharmacyIterable item) {
        return 0;
    }
}