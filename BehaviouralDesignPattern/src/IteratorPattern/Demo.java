package IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Iterator Design Pattern");
        Book b1 = new Book(30, "The secret seven");
        Book b2 = new Book(50, "Goosebumps");
        Book b3 = new Book(200, "Five Point Someone");
        List<Book>bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);

        Library library = new Library(bookList);
        Iterator iterator = (Iterator) library.createIterator();
        System.out.println("Iterating over Books List present in Library: ");
        while(iterator.hasNext()) {
            Book book = (Book)iterator.next();
            System.out.println("Book:  | " + book.getBookName()+ " | price Rs."+book.getPrice());
;        }
    }
}
