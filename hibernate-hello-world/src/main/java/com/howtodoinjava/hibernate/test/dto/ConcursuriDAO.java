package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class ConcursuriDAO {

    public void insertOrUpdateConcursuri(Concursuri concursuri, Session session){
        session.beginTransaction();
        session.persist(concursuri);
        session.getTransaction().commit();
    }

    public void deleteConcurs(Concursuri concursuri,Session session){
        session.beginTransaction();
        session.delete(concursuri);
        session.getTransaction().commit();
    }

    public List<Concursuri> afisareConcursuri( Session session){
        session.beginTransaction();
        Query query = session.createQuery("from Concursuri");
        session.getTransaction().commit();
        return query.getResultList();
    }

    public Concursuri findByName(String nume,Session session){
        session.beginTransaction();
        Query query = session.createQuery("from Concursuri c where c.nume =:nume");
        query.setParameter("nume",nume);
        session.getTransaction().commit();
       List<Concursuri> concursuriList = query.getResultList();
       if(!concursuriList.isEmpty()){
           return concursuriList.get(0);

       }else {
           System.out.println("Concursul nu a fost gasit");
       }
       return  null;
    }

}
