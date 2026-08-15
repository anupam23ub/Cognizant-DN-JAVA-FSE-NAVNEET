package WEEK1.AlgorithmsDS.exercise6;

class Book {
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

class LibrarySearch {
    public Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearchByTitle(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].title.compareTo(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Book[] books = {
                new Book("B1", "1984", "tash"),
                new Book("B2", "Dune", "Nav"),
                new Book("B3", "Foundation", "Harin")
        };

        LibrarySearch library = new LibrarySearch();

        Book b1 = library.linearSearchByTitle(books, "Dune");
        System.out.println(b1 != null ? b1.author : "Not Found");

        Book b2 = library.binarySearchByTitle(books, "Foundation");
        System.out.println(b2 != null ? b2.author : "Not Found");
    }
}
