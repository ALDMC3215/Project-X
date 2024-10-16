package com.example.video26.Main;

import com.example.mvpproject.Model.Person;
import com.example.mvpproject.Model.PersonRepository;

import java.util.List;

public class SecondPresenter implements SecondContract.Presenter {

    private final PersonRepository repository;
    private SecondContract.View view;

    public SecondPresenter(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onAttach(SecondContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    @Override
    public void onAddPerson(Person person) {
        repository.addPerson(person);
        this.view.showMessage("User added successfully");
    }

    @Override
    public void onDeletePerson(Person person) {
        repository.deletePerson(person);
        this.view.showMessage("User deleted successfully");
    }

    @Override
    public void onUpdatePerson(Person person) {
        repository.updatePerson(person);
        this.view.showMessage("User updated successfully");
    }

    @Override
    public void onSearchPerson(Person person) {

        List<Person> persons = repository.searchPerson(person.getName());
        if(view != null) {
            view.showAllContacts(persons);
        }

    }

    @Override
    public void onShowAllContacts() {

        List<Person> persons = repository.getAllPersons(); // Get updated list from repository
        if(view != null) {
            view.showAllContacts(persons); // Updatethe view
        }

    }

    @Override
    public List<Person> getPersons() {
        return repository.getAllPersons();
    }
}
