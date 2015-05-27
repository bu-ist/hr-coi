package edu.bu.ist.coi.db;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoiInvitations entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.bu.ist.coi.db.CoiInvitations
 * @author MyEclipse Persistence Tools
 */

public class CoiInvitationsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CoiInvitationsDAO.class);
	// property constants
	public static final String INV_SINGLE_USE = "invSingleUse";
	public static final String INV_EXPIRED = "invExpired";
	public static final String DIS_PERIOD = "disPeriod";
	public static final String INV_URL = "invUrl";

	public void save(CoiInvitations transientInstance) {
		log.debug("saving CoiInvitations instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoiInvitations persistentInstance) {
		log.debug("deleting CoiInvitations instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoiInvitations findById(java.lang.String id) {
		log.debug("getting CoiInvitations instance with id: " + id);
		try {
			CoiInvitations instance = (CoiInvitations) getSession().get(
					"edu.bu.ist.coi.db.CoiInvitations", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoiInvitations instance) {
		log.debug("finding CoiInvitations instance by example");
		try {
			List results = getSession().createCriteria(
					"edu.bu.ist.coi.db.CoiInvitations").add(
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
		log.debug("finding CoiInvitations instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CoiInvitations as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInvSingleUse(Object invSingleUse) {
		return findByProperty(INV_SINGLE_USE, invSingleUse);
	}

	public List findByInvExpired(Object invExpired) {
		return findByProperty(INV_EXPIRED, invExpired);
	}

	public List findByDisPeriod(Object disPeriod) {
		return findByProperty(DIS_PERIOD, disPeriod);
	}

	public List findByInvUrl(Object invUrl) {
		return findByProperty(INV_URL, invUrl);
	}

	public List findAll() {
		log.debug("finding all CoiInvitations instances");
		try {
			String queryString = "from CoiInvitations";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoiInvitations merge(CoiInvitations detachedInstance) {
		log.debug("merging CoiInvitations instance");
		try {
			CoiInvitations result = (CoiInvitations) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoiInvitations instance) {
		log.debug("attaching dirty CoiInvitations instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoiInvitations instance) {
		log.debug("attaching clean CoiInvitations instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}