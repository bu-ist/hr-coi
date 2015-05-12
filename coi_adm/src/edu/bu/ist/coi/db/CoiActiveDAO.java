package edu.bu.ist.coi.db;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoiActive entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.bu.ist.coi.db.CoiActive
 * @author MyEclipse Persistence Tools
 */

public class CoiActiveDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CoiActiveDAO.class);
	// property constants
	public static final String IS_SENIOR_ADMIN = "isSeniorAdmin";

	public void save(CoiActive transientInstance) {
		log.debug("saving CoiActive instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoiActive persistentInstance) {
		log.debug("deleting CoiActive instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoiActive findById(edu.bu.ist.coi.db.CoiActiveId id) {
		log.debug("getting CoiActive instance with id: " + id);
		try {
			CoiActive instance = (CoiActive) getSession().get(
					"edu.bu.ist.coi.db.CoiActive", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoiActive instance) {
		log.debug("finding CoiActive instance by example");
		try {
			List results = getSession().createCriteria(
					"edu.bu.ist.coi.db.CoiActive")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CoiActive instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CoiActive as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIsSeniorAdmin(Object isSeniorAdmin) {
		return findByProperty(IS_SENIOR_ADMIN, isSeniorAdmin);
	}

	public List findAll() {
		log.debug("finding all CoiActive instances");
		try {
			String queryString = "from CoiActive";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoiActive merge(CoiActive detachedInstance) {
		log.debug("merging CoiActive instance");
		try {
			CoiActive result = (CoiActive) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoiActive instance) {
		log.debug("attaching dirty CoiActive instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoiActive instance) {
		log.debug("attaching clean CoiActive instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}