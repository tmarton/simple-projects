package net.marton.trainingjournal.dao.impl;

import net.marton.trainingjournal.dao.TrainingDao;
import net.marton.trainingjournal.dao.TrainingSectionDao;
import net.marton.trainingjournal.entities.TrainingSection;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Created by tmarton on 8/27/15.
 */
@Stateless
@Named(value = "trainingSectionDao")
public class TrainingSectionDaoImpl extends BaseDaoImpl<TrainingSection, Long> implements TrainingSectionDao {
}
