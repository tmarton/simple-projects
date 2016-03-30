package net.marton.trainingjournal.dao.impl;

import net.marton.trainingjournal.dao.ExerciseDao;
import net.marton.trainingjournal.entities.Exercise;

import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Created by tmarton on 8/26/15.
 */
@Stateless
@Named(value = "exerciseDao")
public class ExcerciseDaoImpl extends BaseDaoImpl<Exercise, Long> implements ExerciseDao {
}
