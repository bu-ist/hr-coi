package edu.bu.ist.coi.db;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoiEmployee entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.bu.ist.coi.db.CoiEmployee
 * @author MyEclipse Persistence Tools
 */

public class CoiEmployeeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CoiEmployeeDAO.class);
	// property constants
	public static final String EMP_ID = "empId";
	public static final String EMP_LNAME = "empLname";
	public static final String EMP_FNAME = "empFname";
	public static final String EMP_MINITIAL = "empMinitial";
	public static final String EMP_PAYROLL_FILE = "empPayrollFile";
	public static final String EMP_F5 = "empF5";
	public static final String EMP_GRADE = "empGrade";
	public static final String EMP_F7 = "empF7";
	public static final String EMP_F8 = "empF8";
	public static final String EMP_DEPT = "empDept";
	public static final String EMP_TITLE = "empTitle";
	public static final String EMP_ADDRESS = "empAddress";
	public static final String EMP_MAIL_CODE = "empMailCode";
	public static final String EMP_ALIAS = "empAlias";
	public static final String EMP_ACTIVE = "empActive";
	public static final String EMP_DISPLAY_NAME = "empDisplayName";

	public void save(CoiEmployee transientInstance) {
		log.debug("saving CoiEmployee instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoiEmployee persistentInstance) {
		log.debug("deleting CoiEmployee instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoiEmployee findById(java.lang.String id) {
		log.debug("getting CoiEmployee instance with id: " + id);
		try {
			CoiEmployee instance = (CoiEmployee) getSession().get(
					"edu.bu.ist.coi.db.CoiEmployee", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoiEmployee instance) {
		log.debug("finding CoiEmployee instance by example");
		try {
			List results = getSession().createCriteria(
					"edu.bu.ist.coi.db.CoiEmployee").add(
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
		log.debug("finding CoiEmployee instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CoiEmployee as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEmpId(Object empId) {
		return findByProperty(EMP_ID, empId);
	}

	public List findByEmpLname(Object empLname) {
		return findByProperty(EMP_LNAME, empLname);
	}

	public List findByEmpFname(Object empFname) {
		return findByProperty(EMP_FNAME, empFname);
	}

	public List findByEmpMinitial(Object empMinitial) {
		return findByProperty(EMP_MINITIAL, empMinitial);
	}

	public List findByEmpPayrollFile(Object empPayrollFile) {
		return findByProperty(EMP_PAYROLL_FILE, empPayrollFile);
	}

	public List findByEmpF5(Object empF5) {
		return findByProperty(EMP_F5, empF5);
	}

	public List findByEmpGrade(Object empGrade) {
		return findByProperty(EMP_GRADE, empGrade);
	}

	public List findByEmpF7(Object empF7) {
		return findByProperty(EMP_F7, empF7);
	}

	public List findByEmpF8(Object empF8) {
		return findByProperty(EMP_F8, empF8);
	}

	public List findByEmpDept(Object empDept) {
		return findByProperty(EMP_DEPT, empDept);
	}

	public List findByEmpTitle(Object empTitle) {
		return findByProperty(EMP_TITLE, empTitle);
	}

	public List findByEmpAddress(Object empAddress) {
		return findByProperty(EMP_ADDRESS, empAddress);
	}

	public List findByEmpMailCode(Object empMailCode) {
		return findByProperty(EMP_MAIL_CODE, empMailCode);
	}

	public List findByEmpAlias(Object empAlias) {
		return findByProperty(EMP_ALIAS, empAlias);
	}

	public List findByEmpActive(Object empActive) {
		return findByProperty(EMP_ACTIVE, empActive);
	}

	public List findByEmpDisplayName(Object empDisplayName) {
		return findByProperty(EMP_DISPLAY_NAME, empDisplayName);
	}

	public List findAll() {
		log.debug("finding all CoiEmployee instances");
		try {
			String queryString = "from CoiEmployee";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoiEmployee merge(CoiEmployee detachedInstance) {
		log.debug("merging CoiEmployee instance");
		try {
			CoiEmployee result = (CoiEmployee) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoiEmployee instance) {
		log.debug("attaching dirty CoiEmployee instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoiEmployee instance) {
		log.debug("attaching clean CoiEmployee instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}