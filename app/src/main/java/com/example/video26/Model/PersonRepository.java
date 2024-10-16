package com.example.video26.Model;

import androidx.annotation.NonNull;

import java.util.List;

public class PersonRepository {

    private final PersonDao personDao;

    public PersonRepository(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAllPersons() {
        return personDao.selectAll();
    }

    public void addPerson(Person person) {
        personDao.add(person);
    }

    public void updatePerson(@NonNull Person person) {
        personDao.updateById(person.getPersonId(), person.getName(), person.getFamily(), person.getPhoneNumber());
    }

    public void deletePerson(@NonNull Person person) {
        personDao.deleteById(person.getPersonId());
    }

    public List<Person> searchPerson(String query) {
        return personDao.search(query);
    }


}
