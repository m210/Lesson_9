package com.company;

public class Library {

    private final Book[] bookList;

    public Library(int capacity, Book... initialBooks) {
        this.bookList = new Book[capacity];
        System.arraycopy(initialBooks, 0, bookList, 0, initialBooks.length);
    }

    public boolean addBook(Book book) {
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

    public void printBookInfo(String name) {
        Book book = findBook(name);
        if(book != null)
            printBookInfo(book);
        else
            System.out.println("The book is not found!");
    }

    public void changeBookPublish(String name, int year) {
        Book book = findBook(name);
        if(book != null) {
            book.setYear(year);
        } else
            System.out.println("The book is not found!");
    }
    public void printAllInfos() {
        for(Book b : bookList) {
            printBookInfo(b);
        }
    }

    private Book findBook(String name) {
        for(Book book : bookList) {
            if(book == null)
                continue;

            if(book.getName().equalsIgnoreCase(name))
                return book;
        }
        return null;
    }

    private void printBookInfo(Book book) {
        if(book == null)
            return;

        Author author = book.getAuthor();
        System.out.println(book.getName() + " by " + author.getFirstName() + " " + author.getLastName() + " was published in " + book.getYear());
    }

}
