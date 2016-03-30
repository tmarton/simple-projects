package net.marton.trainingjournal.service;

import net.marton.trainingjournal.entities.Exercise;
import net.marton.trainingjournal.entities.Training;
import net.marton.trainingjournal.entities.TrainingSection;

import java.util.List;

/**
 * Created by tmarton on 8/30/15.
 */
public interface TrainingService {

    public void createTraining(Training training);

    public List<Training> listTrainings();

    public Training getTrainingById(Long id);

    public void updateTraining(Training training);

    public void deleteTraining(Training training);

    public void createTrainingSection(Training training, TrainingSection trainingSection);

    public TrainingSection getTrainingSectionById(Long id);

    public void updateTrainingSection(TrainingSection trainingSection);

    public void deleteTrainingSection(TrainingSection trainingSection);

    public void createExercise(TrainingSection trainingSection, Exercise exercise);

    public Exercise getExercideById(Long id);

    public void updateExerciseg(Exercise exercise);

    public void deleteExercise(TrainingSection trainingSection, Exercise exercise);

}
