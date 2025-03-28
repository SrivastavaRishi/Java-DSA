package com.DesignPatterns.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book(24, "b1");
        Book b2 = new Book(33, "b2");
        Book b3 = new Book(89, "b3");

        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);

        Library library = new Library(bookList);

        MyIterator bookIterator = library.createIterator();

        while(bookIterator.hasNext()){
            Book b = (Book)bookIterator.next();
            System.out.println(b);
        }

    }
}
