import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutilThread {

    public static class LibraryManager {
        private final ObseverPartterm.ObservableLibrary<Document> library = new ObseverPartterm.ObservableLibrary<>();

        public void addDocumentsConcurrently(List<Document> documents) {
            ExecutorService executor = Executors.newFixedThreadPool(5);

            for (Document doc : documents) {
                executor.execute(() -> library.addDocument(doc));
            }

            executor.shutdown();
        }

        public ObseverPartterm.ObservableLibrary<Document> getLibrary() {
            return library;
        }
    }

}
