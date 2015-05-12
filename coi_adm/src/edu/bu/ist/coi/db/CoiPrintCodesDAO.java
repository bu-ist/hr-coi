package edu.bu.ist.coi.db;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoiPrintCodes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.bu.ist.coi.db.CoiPrintCodes
 * @author MyEclipse Persistence Tools
 */

public class CoiPrintCodesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CoiPrintCodesDAO.class);
	// property constants
	public static final String IS_EXPIRED = "isExpired";

	public void save(CoiPrintCodes transientInstance) {
		log.debug("saving CoiPrintCodes instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoiPrintCodes persistentInstance) {
		log.debug("deleting CoiPrintCodes instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoiPrintCodes findById(java.lang.String id) {
		log.debug("getting CoiPrintCodes instance with id: " + id);
		try {
			CoiPrintCodes instance = (CoiPrintCodes) getSession().get(
					"edu.bu.ist.coi.db.CoiPrintCodes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoiPrintCodes instance) {
		log.debug("finding CoiPrintCodes instance by example");
		try {
			List results = getSession().createCriteria(
					"edu.bu.ist.coi.db.CoiPrintCodes").add(
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
		log.debug("finding CoiPrintCodes instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CoiPrintCodes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIsExpired(Object isExpired) {
		return findByProperty(IS_EXPIRED, isExpired);
	}

	public List findAll() {
		log.debug("finding all CoiPrintCodes instances");
		try {
			String queryString = "from CoiPrintCodes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoiPrintCodes merge(CoiPrintCodes detachedInstance) {
		log.debug("merging CoiPrintCodes instance");
		try {
			CoiPrintCodes result = (CoiPrintCodes) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoiPrintCodes instance) {
		log.debug("attaching dirty CoiPrintCodes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoiPrintCodes instance) {
		log.debug("attaching clean CoiPrintCodes instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}