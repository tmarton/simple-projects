package net.marton.trainingjournal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.marton.trainingjournal.entities.enums.TrainingSectionType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tmarton on 8/26/15.
 */
@Entity
@Table(name = "TRAINING_PART")
public class TrainingSection implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long Id;
    private TrainingSectionType type;
    private Training training;
    private List<Exercise> exercises;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    public TrainingSectionType getType() {
        return type;
    }

    public void setType(TrainingSectionType type) {
        this.type = type;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "TRAINING_ID")
    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(name = "TRAINING_SECTION_EXERCISES", joinColumns = @JoinColumn(name = "TRAINING_SECTION_ID"), inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
