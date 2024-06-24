package GenericExercises;

public class Borrower implements CatalogItem<Integer> {
    private Integer id;

    public Borrower(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}

