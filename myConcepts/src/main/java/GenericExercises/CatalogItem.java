package GenericExercises;

public interface CatalogItem<ID extends Number> {
    ID getId();
    void setId(ID id);
}
