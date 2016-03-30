package net.marton.trainingjournal.dao.impl;


import net.marton.trainingjournal.dao.BaseDao;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by tmarton on 8/26/15.
 */
@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Named(value = "baseDao")
public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

	@Inject
	protected EntityManager entityManager;

	protected Class<T> persistentClass;

	@Override
	public T getByID(ID id) {
		return entityManager.find(getPersistentClass(), id);
	}

	@Override
	public void create(T entity) {
		entityManager.persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<T> getPersistentClass() {
		if (persistentClass == null) {
			persistentClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return persistentClass;
	}

	@Override
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		return (List<T>) entityManager.createQuery(
				"FROM " + getPersistentClass().getName()).getResultList();
	}

	@Override
	public void update(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity
				: entityManager.merge(entity));
	}
}
