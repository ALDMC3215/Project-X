package com.example.video26;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.video26.Model.Person;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView TV;
    ArrayList<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View();


        InputStream inputStream = OpenXmlFile();
        if(inputStream != null) {
            personList = MyXmlPullParser(inputStream);
            ShowPersonList(personList);
        }


    }

    private InputStream OpenXmlFile() {
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("xmlfile.xml");
        } catch(IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }


    @NonNull
    private ArrayList<Person> MyXmlPullParser(InputStream inputStream) {
        ArrayList<Person> list1 = new ArrayList<>();
        Person person = null;
        try {
            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);

            String tag = "", text = "";
            int event = parser.getEventType();
            while(event != XmlPullParser.END_DOCUMENT) {
                tag = parser.getName();
                if(event == XmlPullParser.START_TAG) {
                    if(tag.equals("person")) {
                        person = new Person();
                    }
                } else if(event == XmlPullParser.TEXT) {
                    text = parser.getText();
                } else if(event == XmlPullParser.END_TAG) {
                    if(tag.equals("id")) {
                        person.setId(Integer.parseInt(text));
                    } else if(tag.equals("name")) {
                        person.setName(text);
                    } else if(tag.equals("family")) {
                        person.setFamily(text);
                    } else if(tag.equals("person")) {
                        if(person != null) {
                            list1.add(person);
                        }
                    }
                }
                event = parser.next();
            }
            event = parser.next();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list1;
    }

    private void ShowPersonList(@NonNull ArrayList<Person> personList) {
        String str = "";
        for(Person person : personList) {
            str += person.toString() + "\n";
        }
        TV.setText(str);
    }


    private void View() {
        TV = findViewById(R.id.TV);
    }
}