package com.example.video26.Main;

import com.example.mvpproject.Model.Book;

import java.util.List;

public interface MainContract {

    interface View {
        void ShowAllBooks(List<Book> books);

        void ShowMessage(String message);

    }

    interface Presenter {

        void onAttach(View view);

        void onDetach();

        void onAddBook(Book book);

        void onShowAllBooks();

        void onDeleteBook(int bookId);

    }


}