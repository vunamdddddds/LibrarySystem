import java.util.*;

public class ObseverPartterm {
    interface LibraryObserver {
        void update(String message);
    }

    public static class Member implements ObseverPartterm.LibraryObserver {
        private String name;

        public Member(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println("Notifi " + name + ": " + message);
        }
    }

    static class ObservableLibrary<T> extends Library<T> {
        private List<LibraryObserver> observers = new ArrayList<>();

        public void addObserver(LibraryObserver observer) {
            observers.add(observer);
        }

        public void removeObserver(LibraryObserver observer) {
            observers.remove(observer);
        }

        @Override
        public void addDocument(T document) {
            super.addDocument(document);
            notifyObservers("New document added: " + document.toString());
        }

        private void notifyObservers(String message) {
            for (LibraryObserver observer : observers) {
                observer.update(message);
            }
        }
    }

}
