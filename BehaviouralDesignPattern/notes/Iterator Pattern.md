- Traverse a container, without exposing the underlying structure.
- eg: Iterating List of Books in Library
UML Diagram![](attachements/Pasted%20image%2020240922133416.png)


## Code

Demo Class
```
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
```

Aggregator Interface
```
package IteratorPattern;  
  
public interface Aggregator {  
    Iterator createIterator();  
}
```

Library(Aggregator)
```
package IteratorPattern;  
  
import java.util.List;  
import IteratorPattern.Iterator;  
  
public class Library implements  Aggregator {  
    private List<Book> booksList;  
    public Library(List<Book>booksList) {  
        this.booksList = booksList;  
    }  
  
    @Override  
    public Iterator createIterator() {  
        return (Iterator) new BookIterator(booksList);  
    }  
}
```

Iterator interface
```
package IteratorPattern;  
  
public interface Iterator {  
    public boolean hasNext();  
    public Object next();  
}
```

BooksIterator
```
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
```

Book Class
```
package IteratorPattern;  
  
public class Book {  
    private int price;  
    private String bookName;  
  
    public Book(int price, String bookName) {  
        this.price = price;  
        this.bookName = bookName;  
    }  
  
    public int getPrice() {  
        return price;  
    }  
  
    public String getBookName() {  
        return bookName;  
    }  
}
```

Output
``
```
Iterator Design Pattern
Iterating over Books List present in Library: 
Book:  | The secret seven | price Rs.30
Book:  | Goosebumps | price Rs.50
Book:  | Five Point Someone | price Rs.200
```

