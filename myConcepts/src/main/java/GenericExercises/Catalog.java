package GenericExercises;

import java.util.ArrayList;
import java.util.List;

public class Catalog<T extends CatalogItem<ID>, ID extends Number> {
    private List<T> items;

    public Catalog() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T findItem(ID id) {
        for (T item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}
