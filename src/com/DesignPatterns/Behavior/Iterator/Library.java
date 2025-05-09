package com.DesignPatterns.Behavior.Iterator;

import java.util.List;

public class Library {
    List<Book> bookList;
    public Library(List<Book>bookList){
        this.bookList = bookList;
    }
    public MyIterator createIterator(){
        return new BookIterator(this.bookList);
    }
}
