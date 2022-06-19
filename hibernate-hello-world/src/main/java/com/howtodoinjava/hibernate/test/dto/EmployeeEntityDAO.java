package com.howtodoinjava.hibernate.test.dto;

import com.howtodoinjava.hibernate.test.HibernateUtil;
import org.hibernate.Session;

public class EmployeeEntityDAO {
    public void insertEmployee(EmployeeEntity employeeEntity,Session session) {

        session.beginTransaction();
        session.persist(employeeEntity);
        session.getTransaction().commit();

    }
}
