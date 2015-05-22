package edu.bu.ist.coi.db;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoiDisclosure entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.bu.ist.coi.db.CoiDisclosure
 * @author stetelba & MyEclipse Persistence Tools
 */

public class CoiDisclosureDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CoiDisclosureDAO.class);
	// property constants
	public static final String DIS_IS_EMP = "disIsEmp";
	public static final String DIS_IS_FAM_EMPLOYED = "disIsFamEmployed";
	public static final String DIS_IS_FIN_REL = "disIsFinRel";
	public static final String DIS_IS_ORG_AGENT = "disIsOrgAgent";
	public static final String DIS_CERTIFIED = "disCertified";
	public static final String DIS_PERIOD = "disPeriod";
	public static final String DIS_SIG_FNAME = "disSigFname";
	public static final String DIS_SIG_LNAME = "disSigLname";
	public static final String DIS_IS_PAPER = "disIsPaper";

	public void save(CoiDisclosure transientInstance) {
		log.debug("saving CoiDisclosure instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoiDisclosure persistentInstance) {
		log.debug("deleting CoiDisclosure instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoiDisclosure findById(java.lang.Integer id) {
		log.debug("getting CoiDisclosure instance with id: " + id);
		try {
			CoiDisclosure instance = (CoiDisclosure) getSession().get(
					"edu.bu.ist.coi.db.CoiDisclosure", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoiDisclosure instance) {
		log.debug("finding CoiDisclosure instance by example");
		try {
			List results = getSession().createCriteria(
					"edu.bu.ist.coi.db.CoiDisclosure").add(
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
		log.debug("finding CoiDisclosure instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CoiDisclosure as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDisIsEmp(Object disIsEmp) {
		return findByProperty(DIS_IS_EMP, disIsEmp);
	}

	public List findByDisIsFamEmployed(Object disIsFamEmployed) {
		return findByProperty(DIS_IS_FAM_EMPLOYED, disIsFamEmployed);
	}

	public List findByDisIsFinRel(Object disIsFinRel) {
		return findByProperty(DIS_IS_FIN_REL, disIsFinRel);
	}

	public List findByDisIsOrgAgent(Object disIsOrgAgent) {
		return findByProperty(DIS_IS_ORG_AGENT, disIsOrgAgent);
	}

	public List findByDisCertified(Object disCertified) {
		return findByProperty(DIS_CERTIFIED, disCertified);
	}

	public List findByDisPeriod(Object disPeriod) {
		return findByProperty(DIS_PERIOD, disPeriod);
	}

	public List findByDisSigFname(Object disSigFname) {
		return findByProperty(DIS_SIG_FNAME, disSigFname);
	}

	public List findByDisSigLname(Object disSigLname) {
		return findByProperty(DIS_SIG_LNAME, disSigLname);
	}

	public List findByDisIsPaper(Object disIsPaper) {
		return findByProperty(DIS_IS_PAPER, disIsPaper);
	}

	public List findAll() {
		log.debug("finding all CoiDisclosure instances");
		try {
			String queryString = "from CoiDisclosure";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoiDisclosure merge(CoiDisclosure detachedInstance) {
		log.debug("merging CoiDisclosure instance");
		try {
			CoiDisclosure result = (CoiDisclosure) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoiDisclosure instance) {
		log.debug("attaching dirty CoiDisclosure instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoiDisclosure instance) {
		log.debug("attaching clean CoiDisclosure instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}