import java.util.Iterator;
import java.util.List;

// LibraryIterator class to iterate over the library's documents
public class LibraryIterator<T> implements Iterator<T> {
    private List<T> documents;
    private int position = 0;

    public LibraryIterator(List<T> documents) {
        this.documents = documents;
    }

    @Override
    public boolean hasNext() {
        return position < documents.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        return documents.get(position++);
    }
}
