package net.marton.trainingjournal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.marton.trainingjournal.entities.converters.LocalDateTimeDeserializer;
import net.marton.trainingjournal.entities.converters.LocalDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmarton on 8/26/15.
 */
@Entity
@Table(name = "TRAININGS")
public class Training implements Serializable {

    private Long id;
    private String name;
    private LocalDateTime time;
    private List<TrainingSection> sections = new ArrayList<>();
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "TIME")
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "training", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public List<TrainingSection> getSections() {
        return sections;
    }

    public void setSections(List<TrainingSection> sections) {
        this.sections = sections;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
