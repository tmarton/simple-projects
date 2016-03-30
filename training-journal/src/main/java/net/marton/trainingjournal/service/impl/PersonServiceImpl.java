package net.marton.trainingjournal.service.impl;

import net.marton.trainingjournal.dao.PersonDao;
import net.marton.trainingjournal.entities.Person;
import net.marton.trainingjournal.service.PersonService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tmarton on 9/2/15.
 */
@Stateless
@Named(value = "personService")
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonDao personDao;


    @Override
    public void createUser(Person person) {
        personDao.create(person);
    }

    @Override
    public List<Person> listPersons() {
        return personDao.listAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personDao.getByID(id);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.update(person);
    }

    @Override
    public void deletePerson(Person person){
        personDao.delete(person);
    }
}
