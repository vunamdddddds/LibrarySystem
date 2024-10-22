import java.util.*;

public class StrategyPartterm {
    interface SortStrategy<T> {
        void sort(List<T> documents);
    }

    static class SortByTitle implements SortStrategy<Document> {
        @Override
        public void sort(List<Document> documents) {
            documents.sort(Comparator.comparing(Document::getTitle));
        }
    }

    class SortByAuthor implements SortStrategy<Document> {
        @Override
        public void sort(List<Document> documents) {
            documents.sort(Comparator.comparing(Document::getAuthor));
        }
    }

    class SortByYear implements SortStrategy<Document> {
        @Override
        public void sort(List<Document> documents) {
            documents.sort(Comparator.comparingInt(Document::getYear));
        }
    }
}
