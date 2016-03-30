package net.marton.trainingjournal.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tmarton on 8/26/15.
 */
@Entity
@Table(name = "EXERCISES")
public class Exercise implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;
    private String name;
    private int repetitions;
    private MeasurableUnit measurableUnit;


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
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

    @Column(name = "REPETIONS")
    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    @OneToOne
    @JoinColumn(name = "MEASURABLE_UNIT_ID")
    public MeasurableUnit getMeasurableUnit() {
        return measurableUnit;
    }

    public void setMeasurableUnit(MeasurableUnit measurableUnit) {
        this.measurableUnit = measurableUnit;
    }
}
