package net.marton.trainingjournal.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tmarton on 8/26/15.
 */
public interface BaseDao<T, ID extends Serializable> {
    public T getByID(ID id);

    public void create(T entity);

    public List<T> listAll();

    public Class<T> getPersistentClass();

    public void setPersistentClass(Class<T> persistentClass);

    public void delete(T entity);

    public void update(T entity);
}
