package net.marton.trainingjournal.producers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tmarton on 8/27/15.
 */
public class PersistenceProducer {

    @SuppressWarnings("unused")
    @Produces
    @PersistenceContext
    private EntityManager em;
}
