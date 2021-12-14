package com.company;

public class Main {

    private static final Book[] bookList = new Book[10];

    public static void main(String[] args) {
        System.out.println("\n\tMinimal level\n");

        new App().main();

        System.out.println("\n\tMiddle level\n");

        Book b1 = new Book(new Author("Ivan", "Ivanov"), "Book1", 1990);
        Book b2 = new Book(new Author("Peter", "Petrov"), "Book2", 2000);
        Book b3 = new Book(new Author("Sidor", "Sidorov"), "Book3", 2100);

        addBook(b1);
        addBook(b2);
        addBook(b3);

        addBook(b2);
        addBook(b2);
        addBook(b2);

        for(Book b : bookList) {
            printBookInfo(b);
        }

        System.out.println("\n\tHard level\n");

        Library lib = new Library(10, b1, b2, b3);
        lib.addBook(new Book(new Author("Stephen", "King"), "The Stand", 1978));
        System.out.print("printBookInfo() -> ");
            lib.printBookInfo("The Stand");
        lib.changeBookPublish("Book2", 9999);
        lib.printAllInfos();
    }

    public static boolean addBook(Book book) {
        int i = 0;
        while(i < bookList.length) {
            if(bookList[i] == null)
                break;

            if(bookList[i++].equals(book))
                return false;
        }

        if(i < bookList.length) {
            bookList[i] = book;
            return true;
        }
        return false;
    }

    public static void printBookInfo(Book book) {
        if(book == null)
            return;

        Author author = book.getAuthor();
        System.out.println(book.getName() + " by " + author.getFirstName() + " " + author.getLastName() + " was published in " + book.getYear());
    }
}
