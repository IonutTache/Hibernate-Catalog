package com.howtodoinjava.hibernate.test;

import com.howtodoinjava.hibernate.test.dto.EmployeeEntity;
import com.howtodoinjava.hibernate.test.dto.EmployeeEntityDAO;
import org.hibernate.Session;

public class TestHibernate {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        EmployeeEntity employeeEntity1 = new EmployeeEntity();
        employeeEntity1.setEmail("ceva@gmail.com");
        employeeEntity1.setFirstName("Ion");
        employeeEntity1.setLastName("Mihai");

        EmployeeEntity employeeEntity2 = new EmployeeEntity();
        employeeEntity2.setEmail("ceva2@gmail.com");
        employeeEntity2.setFirstName("Ion2");
        employeeEntity2.setLastName("Mihai2");

        EmployeeEntityDAO employeeEntityDAO = new EmployeeEntityDAO();
        employeeEntityDAO.insertEmployee(employeeEntity1, session);
        employeeEntityDAO.insertEmployee(employeeEntity2, session);

        HibernateUtil.shutdown();




    }

}
