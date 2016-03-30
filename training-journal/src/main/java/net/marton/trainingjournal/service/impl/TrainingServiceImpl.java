package net.marton.trainingjournal.service.impl;

import net.marton.trainingjournal.dao.ExerciseDao;
import net.marton.trainingjournal.dao.TrainingDao;
import net.marton.trainingjournal.dao.TrainingSectionDao;
import net.marton.trainingjournal.entities.Exercise;
import net.marton.trainingjournal.entities.Training;
import net.marton.trainingjournal.entities.TrainingSection;
import net.marton.trainingjournal.service.TrainingService;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tmarton on 8/30/15.
 */
@Named(value = "trainingService")
@Stateless
public class TrainingServiceImpl implements TrainingService {

    @Inject
    private TrainingDao trainingDao;

    @Inject
    private TrainingSectionDao trainingSectionDao;

    @Inject
    private ExerciseDao exerciseDao;

    @Override
    public void createTraining(Training training) {
        trainingDao.create(training);
    }

    @Override
    public List<Training> listTrainings() {
        return trainingDao.listAll();
    }

    @Override
    public Training getTrainingById(Long id) {
        return trainingDao.getByID(id);
    }

    @Override
    public void updateTraining(Training training) {
        trainingDao.update(training);
    }

    @Override
    public void deleteTraining(Training training) { trainingDao.delete(training);}

    @Override
    public void createTrainingSection(Training training, TrainingSection trainingSection) {
        training.getSections().add(trainingSection);
        trainingSection.setTraining(training);
        trainingSectionDao.create(trainingSection);
        trainingDao.update(training);
    }

    @Override
    public TrainingSection getTrainingSectionById(Long id){
        return trainingSectionDao.getByID(id);
    }

    @Override
    public void updateTrainingSection(TrainingSection trainingSection) {
        trainingSectionDao.update(trainingSection);
    }

    @Override
    public void deleteTrainingSection(TrainingSection trainingSection) {
        trainingSectionDao.delete(trainingSection);
    }

    @Override
    public void createExercise(TrainingSection trainingSection, Exercise exercise){
        trainingSection.getExercises().add(exercise);
        exerciseDao.create(exercise);
        trainingSectionDao.update(trainingSection);
    }

    @Override
    public Exercise getExercideById(Long id){
        return exerciseDao.getByID(id);
    }

    @Override
    public void updateExerciseg(Exercise exercise) {
        exerciseDao.update(exercise);
    }

    @Override
    public void deleteExercise(TrainingSection trainingSection, Exercise exercise){
        exerciseDao.delete(exercise);
        trainingSectionDao.update(trainingSection);
    }
}
