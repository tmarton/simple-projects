package net.marton.trainingjournal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by tmarton on 9/2/15.
 */
@Entity
@Table(name = "PERSONS")
public class Person implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Exercise> personalRecords;
    private List<Training> trainings;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonIgnore
    @OneToMany
    @JoinTable(name = "PERSONAL_RECORDS", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
    public List<Exercise> getPersonalRecords() {
        return personalRecords;
    }

    public void setPersonalRecords(List<Exercise> personalRecords) {
        this.personalRecords = personalRecords;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
