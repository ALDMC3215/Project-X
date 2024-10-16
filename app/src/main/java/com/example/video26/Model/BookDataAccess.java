package com.example.video26.Model;

import java.util.ArrayList;
import java.util.List;

public class BookDataAccess {

    List<Book> books = new ArrayList<>();


    public void AddBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

}
