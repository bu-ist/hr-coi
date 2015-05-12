package edu.bu.ist.coi.db;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoiFinRel entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.bu.ist.coi.db.CoiFinRel
 * @author MyEclipse Persistence Tools
 */

public class CoiFinRelDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CoiFinRelDAO.class);
	// property constants
	public static final String FIN_REL_FIRST = "finRelFirst";
	public static final String FIN_REL_LAST = "finRelLast";
	public static final String FIN_REL_RELATIONSHIP = "finRelRelationship";
	public static final String FIN_REL_ENTITY_NAME = "finRelEntityName";
	public static final String FIN_REL_ENTITY_RELATION = "finRelEntityRelation";
	public static final String FIN_REL_VALUE = "finRelValue";
	public static final String FIN_REL_MONITOR = "finRelMonitor";
	public static final String FIN_REL_ESTABLISHED = "finRelEstablished";
	public static final String FIN_REL_INTEREST = "finRelInterest";

	public void save(CoiFinRel transientInstance) {
		log.debug("saving CoiFinRel instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoiFinRel persistentInstance) {
		log.debug("deleting CoiFinRel instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoiFinRel findById(java.lang.Integer id) {
		log.debug("getting CoiFinRel instance with id: " + id);
		try {
			CoiFinRel instance = (CoiFinRel) getSession().get(
					"edu.bu.ist.coi.db.CoiFinRel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoiFinRel instance) {
		log.debug("finding CoiFinRel instance by example");
		try {
			List results = getSession().createCriteria(
					"edu.bu.ist.coi.db.CoiFinRel")
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
		log.debug("finding CoiFinRel instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CoiFinRel as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFinRelFirst(Object finRelFirst) {
		return findByProperty(FIN_REL_FIRST, finRelFirst);
	}

	public List findByFinRelLast(Object finRelLast) {
		return findByProperty(FIN_REL_LAST, finRelLast);
	}

	public List findByFinRelRelationship(Object finRelRelationship) {
		return findByProperty(FIN_REL_RELATIONSHIP, finRelRelationship);
	}

	public List findByFinRelEntityName(Object finRelEntityName) {
		return findByProperty(FIN_REL_ENTITY_NAME, finRelEntityName);
	}

	public List findByFinRelEntityRelation(Object finRelEntityRelation) {
		return findByProperty(FIN_REL_ENTITY_RELATION, finRelEntityRelation);
	}

	public List findByFinRelValue(Object finRelValue) {
		return findByProperty(FIN_REL_VALUE, finRelValue);
	}

	public List findByFinRelMonitor(Object finRelMonitor) {
		return findByProperty(FIN_REL_MONITOR, finRelMonitor);
	}

	public List findByFinRelEstablished(Object finRelEstablished) {
		return findByProperty(FIN_REL_ESTABLISHED, finRelEstablished);
	}

	public List findByFinRelInterest(Object finRelInterest) {
		return findByProperty(FIN_REL_INTEREST, finRelInterest);
	}

	public List findAll() {
		log.debug("finding all CoiFinRel instances");
		try {
			String queryString = "from CoiFinRel";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoiFinRel merge(CoiFinRel detachedInstance) {
		log.debug("merging CoiFinRel instance");
		try {
			CoiFinRel result = (CoiFinRel) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoiFinRel instance) {
		log.debug("attaching dirty CoiFinRel instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoiFinRel instance) {
		log.debug("attaching clean CoiFinRel instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}