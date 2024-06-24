package GenericExercises;

public class Book implements CatalogItem<Integer> {
    private Integer id;
    private String author;

    public Book(Integer id) {
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
