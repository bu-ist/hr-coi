package edu.bu.ist.coi.db;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoiFamRel entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.bu.ist.coi.db.CoiFamRel
 * @author MyEclipse Persistence Tools
 */

public class CoiFamRelDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CoiFamRelDAO.class);
	// property constants
	public static final String FAM_REL_FIRST = "famRelFirst";
	public static final String FAM_REL_LAST = "famRelLast";
	public static final String FAM_REL_RELATIONSHIP = "famRelRelationship";
	public static final String FAM_REL_TITLE = "famRelTitle";
	public static final String FAM_REL_DEPARTMENT = "famRelDepartment";

	public void save(CoiFamRel transientInstance) {
		log.debug("saving CoiFamRel instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoiFamRel persistentInstance) {
		log.debug("deleting CoiFamRel instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoiFamRel findById(java.lang.Integer id) {
		log.debug("getting CoiFamRel instance with id: " + id);
		try {
			CoiFamRel instance = (CoiFamRel) getSession().get(
					"edu.bu.ist.coi.db.CoiFamRel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoiFamRel instance) {
		log.debug("finding CoiFamRel instance by example");
		try {
			List results = getSession().createCriteria(
					"edu.bu.ist.coi.db.CoiFamRel")
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
		log.debug("finding CoiFamRel instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CoiFamRel as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFamRelFirst(Object famRelFirst) {
		return findByProperty(FAM_REL_FIRST, famRelFirst);
	}

	public List findByFamRelLast(Object famRelLast) {
		return findByProperty(FAM_REL_LAST, famRelLast);
	}

	public List findByFamRelRelationship(Object famRelRelationship) {
		return findByProperty(FAM_REL_RELATIONSHIP, famRelRelationship);
	}

	public List findByFamRelTitle(Object famRelTitle) {
		return findByProperty(FAM_REL_TITLE, famRelTitle);
	}

	public List findByFamRelDepartment(Object famRelDepartment) {
		return findByProperty(FAM_REL_DEPARTMENT, famRelDepartment);
	}

	public List findAll() {
		log.debug("finding all CoiFamRel instances");
		try {
			String queryString = "from CoiFamRel";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoiFamRel merge(CoiFamRel detachedInstance) {
		log.debug("merging CoiFamRel instance");
		try {
			CoiFamRel result = (CoiFamRel) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoiFamRel instance) {
		log.debug("attaching dirty CoiFamRel instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoiFamRel instance) {
		log.debug("attaching clean CoiFamRel instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}