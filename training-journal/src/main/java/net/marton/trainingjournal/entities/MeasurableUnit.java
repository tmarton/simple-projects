package net.marton.trainingjournal.entities;

import net.marton.trainingjournal.entities.enums.UnitType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tmarton on 8/26/15.
 */
@Entity
@Table(name = "MEASURABLE_UNITS")
public class MeasurableUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private int amount;
    private UnitType unit;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "AMOUNT")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Column(name = "UNIT")
    @Enumerated(EnumType.STRING)
    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }
}
