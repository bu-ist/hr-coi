package edu.bu.ist.coi.db;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoiOrgs entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.bu.ist.coi.db.CoiOrgs
 * @author MyEclipse Persistence Tools
 */

public class CoiOrgsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CoiOrgsDAO.class);
	// property constants
	public static final String ORG_NAME = "orgName";
	public static final String ORG_POSITION = "orgPosition";
	public static final String ORG_COMPENSATION = "orgCompensation";

	public void save(CoiOrgs transientInstance) {
		log.debug("saving CoiOrgs instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoiOrgs persistentInstance) {
		log.debug("deleting CoiOrgs instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoiOrgs findById(java.lang.Integer id) {
		log.debug("getting CoiOrgs instance with id: " + id);
		try {
			CoiOrgs instance = (CoiOrgs) getSession().get(
					"edu.bu.ist.coi.db.CoiOrgs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoiOrgs instance) {
		log.debug("finding CoiOrgs instance by example");
		try {
			List results = getSession().createCriteria(
					"edu.bu.ist.coi.db.CoiOrgs").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CoiOrgs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CoiOrgs as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOrgName(Object orgName) {
		return findByProperty(ORG_NAME, orgName);
	}

	public List findByOrgPosition(Object orgPosition) {
		return findByProperty(ORG_POSITION, orgPosition);
	}

	public List findByOrgCompensation(Object orgCompensation) {
		return findByProperty(ORG_COMPENSATION, orgCompensation);
	}

	public List findAll() {
		log.debug("finding all CoiOrgs instances");
		try {
			String queryString = "from CoiOrgs";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoiOrgs merge(CoiOrgs detachedInstance) {
		log.debug("merging CoiOrgs instance");
		try {
			CoiOrgs result = (CoiOrgs) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoiOrgs instance) {
		log.debug("attaching dirty CoiOrgs instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoiOrgs instance) {
		log.debug("attaching clean CoiOrgs instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}