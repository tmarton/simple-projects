package net.marton.trainingjournal.service;

import net.marton.trainingjournal.entities.Person;

import java.util.List;

/**
 * Created by tmarton on 9/2/15.
 */
public interface PersonService {

    public void createUser(Person person);

    public List<Person> listPersons();

    public Person getPersonById(Long id);

    public void updatePerson(Person person);

    public void deletePerson(Person person);

}
