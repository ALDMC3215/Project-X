package com.example.video26.Main;

import com.example.mvpproject.Model.Person;

import java.util.List;

public interface SecondContract {

    interface View {
        void showAllContacts(List<Person> personList);

        void showMessage(String message);
    }

    interface Presenter {
        void onAttach(View view);

        void onDetach();

        void onAddPerson(Person person);

        void onDeletePerson(Person person);

        void onUpdatePerson(Person person);

        void onSearchPerson(Person person);

        void onShowAllContacts();

        List<Person> getPersons();
    }

}
