package net.marton.trainingjournal.dao.impl;

import net.marton.trainingjournal.dao.TrainingDao;
import net.marton.trainingjournal.entities.Training;

import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Created by tmarton on 8/27/15.
 */
@Stateless
@Named(value = "trainingDao")
public class TrainingDaoImpl extends BaseDaoImpl<Training, Long> implements TrainingDao {
}
