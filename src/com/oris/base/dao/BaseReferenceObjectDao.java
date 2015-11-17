package com.oris.base.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oris.base.BaseDaoHibernate;

@Repository("baseReferenceObjectDao")
public class BaseReferenceObjectDao extends BaseDaoHibernate {
	static Logger logger = Logger.getLogger(BaseReferenceObjectDao.class);
	private static final String DEFAULT_ENUM_PACKAGE = "com.oris.enums";

	@Autowired
	public BaseReferenceObjectDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
