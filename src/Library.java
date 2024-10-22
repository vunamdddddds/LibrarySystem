import java.util.*;
public class Library<T> {
    private List<T> documents;
    public Library() {
        documents = new ArrayList<>();
    }
    public void addDocument(T document) {
        documents.add(document);
    }

    public void removeDocument(T document) {
        documents.remove(document);
    }
    public T findDocumentByTitle(String title) {
        for (T document : documents) {
            if (document instanceof Document) {
                Document doc = (Document) document;
                if (doc.getTitle().equals(title)) {
                    return document;
                }
            }
        }
        return null;
    }
    public List<T> getDocuments() {
        return documents;
    }
}
