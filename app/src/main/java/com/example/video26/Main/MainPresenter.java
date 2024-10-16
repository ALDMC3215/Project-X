package com.example.video26.Main;

import com.example.mvpproject.Model.Book;
import com.example.mvpproject.Model.BookDataAccess;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    BookDataAccess bookDataAccess;

    @Override
    public void onAttach(MainContract.View view) {
        this.view = view;
        bookDataAccess = new BookDataAccess();
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    @Override
    public void onAddBook(Book book) {
        bookDataAccess.AddBook(book);
        this.view.ShowAllBooks(bookDataAccess.getBooks());
        this.view.ShowMessage("Book added successfully");
    }

    @Override
    public void onShowAllBooks() {
        List<Book> books = bookDataAccess.getBooks();
        if (!books.isEmpty()){
            this.view.ShowAllBooks(books);
        }else{
            this.view.ShowMessage("No books found");
        }
    }

    @Override
    public void onDeleteBook(int bookId) {
        List<Book> books = bookDataAccess.getBooks();
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                bookDataAccess.getBooks().remove(book);
                this.view.ShowAllBooks(bookDataAccess.getBooks());
                this.view.ShowMessage("Book deleted successfully");
                return;
            }
        }
        this.view.ShowMessage("Book not found");
    }


}
