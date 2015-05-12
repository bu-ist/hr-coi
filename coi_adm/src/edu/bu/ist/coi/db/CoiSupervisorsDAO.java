package edu.bu.ist.coi.db;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoiSupervisors entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.bu.ist.coi.db.CoiSupervisors
 * @author MyEclipse Persistence Tools
 */

public class CoiSupervisorsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CoiSupervisorsDAO.class);
	// property constants
	public static final String SUPERVISOR_FIRST = "supervisorFirst";
	public static final String SUPERVISOR_LAST = "supervisorLast";
	public static final String SUPERVISOR_TITLE = "supervisorTitle";

	public void save(CoiSupervisors transientInstance) {
		log.debug("saving CoiSupervisors instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoiSupervisors persistentInstance) {
		log.debug("deleting CoiSupervisors instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoiSupervisors findById(java.lang.Integer id) {
		log.debug("getting CoiSupervisors instance with id: " + id);
		try {
			CoiSupervisors instance = (CoiSupervisors) getSession().get(
					"edu.bu.ist.coi.db.CoiSupervisors", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoiSupervisors instance) {
		log.debug("finding CoiSupervisors instance by example");
		try {
			List results = getSession().createCriteria(
					"edu.bu.ist.coi.db.CoiSupervisors").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CoiSupervisors instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CoiSupervisors as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySupervisorFirst(Object supervisorFirst) {
		return findByProperty(SUPERVISOR_FIRST, supervisorFirst);
	}

	public List findBySupervisorLast(Object supervisorLast) {
		return findByProperty(SUPERVISOR_LAST, supervisorLast);
	}

	public List findBySupervisorTitle(Object supervisorTitle) {
		return findByProperty(SUPERVISOR_TITLE, supervisorTitle);
	}

	public List findAll() {
		log.debug("finding all CoiSupervisors instances");
		try {
			String queryString = "from CoiSupervisors";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoiSupervisors merge(CoiSupervisors detachedInstance) {
		log.debug("merging CoiSupervisors instance");
		try {
			CoiSupervisors result = (CoiSupervisors) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoiSupervisors instance) {
		log.debug("attaching dirty CoiSupervisors instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoiSupervisors instance) {
		log.debug("attaching clean CoiSupervisors instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}