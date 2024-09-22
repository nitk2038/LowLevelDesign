package IteratorPattern;

import java.util.List;

public class BookIterator implements Iterator {
    private List<Book>books;
    private int index = 0;
    public BookIterator(List<Book> bookList) {
        this.books = bookList;
    }

    @Override
    public boolean hasNext() {
        if(index < books.size()) return true;
        return false;
    }

    @Override
    public Object next() {
        if(this.hasNext()) {
            return books.get(index++);
        }
        return null;
    }
}
