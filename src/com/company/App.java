package com.company;

public class App {

    public void main() {
        // Minimal level

        Book b1 = new Book(new Author("Ivan", "Ivanov"), "Book1", 1990);
        Book b2 = new Book(new Author("Peter", "Petrov"), "Book2", 2000);
        Book b3 = new Book(new Author("Sidor", "Sidorov"), "Book3", 2100);

        b3.setYear(2021);

        // Middle level

        Book[] bookList = { b1, b2, b3 };
        for(Book book : bookList) {
            System.out.println(book.toString());
        }

        // Hard level

        Book book = findBook(bookList, "Book2");
        if(book != null) {
            book.setYear(1900);
            System.out.println("Найдена книга:");
            System.out.println(book.toString());
        }
    }

    private Book findBook(Book[] bookList, String name) {
        for(Book book : bookList) {
            if(book.getName().equalsIgnoreCase(name))
                return book;
        }
        return null;
    }

}
