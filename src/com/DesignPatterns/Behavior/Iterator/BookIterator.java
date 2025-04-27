package com.DesignPatterns.Behavior.Iterator;

import java.util.List;

public class BookIterator implements MyIterator {
    List<Book> bookList;
    private int index;

    public BookIterator(List<Book>bookList){
        this.bookList = bookList;
    }

    public boolean hasNext(){
        return index < bookList.size();
    }

    public Object next(){
        if(this.hasNext()){
            return bookList.get(index++);
        }
        return null;
    }
}
