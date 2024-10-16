package com.example.video26.Main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpproject.Model.Book;
import com.example.mvpproject.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    EditText id, name;
    Button add, show, delete;
    TextView result;

    MainContract.Presenter presenter = new MainPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
        presenter.onAttach(this);

        add.setOnClickListener(view -> {
            int ID = Integer.parseInt(id.getText().toString());
            String bookname = name.getText().toString();
            Book book = new Book(ID, bookname);
            presenter.onAddBook(book);
        });

        show.setOnClickListener(view -> {
            presenter.onShowAllBooks();
        });

        add.setOnLongClickListener(view -> {
            result.setText("");
            return true;
        });

        delete.setOnClickListener(view -> {
            presenter.onDeleteBook(Integer.parseInt(id.getText().toString()));
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    public void setup() {
        id = findViewById(R.id.edt_id);
        name = findViewById(R.id.edt_username);
        add = findViewById(R.id.btn_add);
        show = findViewById(R.id.btn_show);
        result = findViewById(R.id.txtView);
        delete = findViewById(R.id.btn_delete);
    }

    @Override
    public void ShowAllBooks(List<Book> books) {
        StringBuilder temp = new StringBuilder();
        for(Book book : books) {
            temp.append(book.getBookId()).append(" - ").append(book.getBookName()).append("\n");
        }
        result.setText(temp);
    }

    @Override
    public void ShowMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}