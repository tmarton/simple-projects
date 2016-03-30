package net.marton.trainingjournal.dao.impl;

import net.marton.trainingjournal.dao.PersonDao;
import net.marton.trainingjournal.entities.Person;

import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Created by tmarton on 9/2/15.
 */
@Stateless
@Named(value = "personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person, Long> implements PersonDao {
}
