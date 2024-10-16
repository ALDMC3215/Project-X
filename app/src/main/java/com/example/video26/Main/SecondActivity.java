    package com.example.video26.Main;

    import android.annotation.SuppressLint;
    import android.os.Bundle;

    import androidx.appcompat.app.AppCompatActivity;

    import com.example.mvpproject.R;

    public class SecondActivity extends AppCompatActivity {

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            set();


        }


        public void set() {
        }

    }
