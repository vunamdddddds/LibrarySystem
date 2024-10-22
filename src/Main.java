import java.util.List;

public class Main {

    public static class Book extends Document {
        public Book(String title, String author, int year) {
            super(title, author, year);
        }
    }
    public static class Magazine extends Document {
        public Magazine(String title, String author, int year) {
            super(title, author, year);
        }
    }

    public static void main(String[] args) {

        ObseverPartterm.ObservableLibrary<Document> library = new ObseverPartterm.ObservableLibrary<>();
        ObseverPartterm.Member member=new ObseverPartterm.Member("Vuthenam");
        ObseverPartterm.Member member2=new ObseverPartterm.Member("HoangXuanNguyen");
        ObseverPartterm.Member member3=new ObseverPartterm.Member("NguyenHoaiNhan");

        library.addObserver(member);
        library.addObserver(member2);
        library.addObserver(member3);


Document book1=new Book("JavaTutorial","Nam",2018);
Document book2=new Book("C#","Vu",2019);
Document book3=new Magazine("C++","Nguyen",2020);

library.addDocument(book1);
library.addDocument(book2);
library.addDocument(book3);

        LibraryIterator<Document> iterator = new LibraryIterator<>(library.getDocuments());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        StrategyPartterm.SortStrategy<Document> sortByTitle = new StrategyPartterm.SortByTitle();
sortByTitle.sort(library.getDocuments());
        for (Document doc : library.getDocuments()) {
            System.out.println(doc);
        }
   MutilThread.LibraryManager manager = new MutilThread.LibraryManager();
        manager.addDocumentsConcurrently(List.of(book1, book2,book3));

    }
}
