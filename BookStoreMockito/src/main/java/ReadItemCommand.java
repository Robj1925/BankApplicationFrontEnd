import java.util.List;

public interface ReadItemCommand {
	public List<Book> readAll();
	public Book getItem(String id);
}
