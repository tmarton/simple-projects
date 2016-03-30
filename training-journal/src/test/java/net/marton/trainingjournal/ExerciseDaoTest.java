package net.marton.trainingjournal;

import net.marton.trainingjournal.dao.ExerciseDao;
import net.marton.trainingjournal.entities.Exercise;
import net.marton.trainingjournal.entities.MeasurableUnit;
import net.marton.trainingjournal.entities.enums.UnitType;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;

/**
 * Created by tmarton on 8/30/15.
 */
@RunWith(Arquillian.class)
public class ExerciseDaoTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap
                .create(WebArchive.class, "exercise.war")
                .addPackage("net.marton.trainingjournal.entities")
                .addPackage("net.marton.trainingjournal.entities.enums")
                .addPackage("net.marton.trainingjournal.entities.converters")
                .addPackage("net.marton.trainingjournal.dao")
                .addPackage("net.marton.trainingjournal.dao.impl")
                .addPackage("net.marton.trainingjournal.producers")
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    ExerciseDao exerciseDao;

    @Test
    public void createTest() {
        Exercise exercise = new Exercise();
        exercise.setName("Thrusters");
        exercise.setRepetitions(15);

        MeasurableUnit unit = new MeasurableUnit();
        unit.setAmount(40);
        unit.setUnit(UnitType.KG);

        exercise.setMeasurableUnit(unit);
        exerciseDao.create(exercise);
        assertTrue(true);
    }

}
