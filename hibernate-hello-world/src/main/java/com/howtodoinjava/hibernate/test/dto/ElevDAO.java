package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class ElevDAO {
    public void insertorupdateElevi (Elev elevi, Session session){
        session.beginTransaction();
        session.persist(elevi);
        session.getTransaction().commit();
    }

    public void deleteElevi(Elev elevi, Session session ){
        session.beginTransaction();
        session.delete(elevi);
        session.getTransaction().commit();
    }

    public List<Elev> showElevi( Session session){
        session.beginTransaction();
        Query query=session.createQuery("from Elev");
        session.getTransaction().commit();
        return query.getResultList();
    }

    public Elev findbynameandsurname (String nume, String prenume , Session session){
        session.beginTransaction();
        Query query=session.createQuery("from Elev e where e.nume =:x and e.prenume =:y");
        query.setParameter("x", nume);
        query.setParameter("y", prenume);
        session.getTransaction().commit();
        List<Elev> elev = query.getResultList();
        if(!elev.isEmpty()){
            return elev.get(0);
        }else {
            System.out.println("Elevul nu fost gasit");
        }
        return null;

    }
    public List <Elev> overAverage (double medie,Session session){
        session.beginTransaction();
        Query query=session.createQuery("from Elev e where e.medie >:x");
        query.setParameter("x",medie);
        session.getTransaction().commit();
        return query.getResultList();

    }



}