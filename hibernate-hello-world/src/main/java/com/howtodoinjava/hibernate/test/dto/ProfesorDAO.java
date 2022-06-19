package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class ProfesorDAO {

    public void insertOrUpdateProfesori (Profesor profesor, Session session){
        session.beginTransaction();
        session.persist(profesor);
        session.getTransaction().commit();
    }

    public void deleteProfesor(Profesor profesor,Session session){
        session.beginTransaction();
        session.delete(profesor);
        session.getTransaction().commit();
    }

    public List<Profesor> printProfesori(Session session){
        session.beginTransaction();
        Query query = session.createQuery("from Profesor");
        session.getTransaction().commit();
        return query.getResultList();

    }

    public Profesor findByNameAndSurname(String nume, String prenume,Session session){
        session.beginTransaction();
        Query query = session.createQuery("from Profesor p where p.nume =:x and p.prenume =:y");
        query.setParameter("x",nume);
        query.setParameter("y",prenume);
        session.getTransaction().commit();
       List <Profesor> profesor = query.getResultList();
       if(!profesor.isEmpty()) {
           return profesor.get(0);
       }else {
           System.out.println("Profesorul nu a fost gasit.");
       }
       return null;
    }


}
