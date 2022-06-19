package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class ClasaDAO {
    public void insertORUpdateClasa (Clasa clasa,Session session){
        session.beginTransaction();
        session.persist(clasa);
        session.getTransaction().commit();
    }

    public void deleteClasa( Clasa clasa,Session session){
        session.beginTransaction();
        session.delete(clasa);
        session.getTransaction().commit();
    }

    public List<Clasa> printClasa(Session session){
        session.beginTransaction();
        Query query = session.createQuery("from Clasa");
        session.getTransaction().commit();
        return query.getResultList();
    }

    public Clasa findByName(String numeClasa,Session session){
        session.beginTransaction();
        Query query = session.createQuery("from Clasa i where i.numeClasa=:x");
        query.setParameter("x",numeClasa);
        session.getTransaction().commit();
        List <Clasa> clasa = query.getResultList();
        if(!clasa.isEmpty()){
            return clasa.get(0);
        }else{
            System.out.println("Clasa nu a fost gasita.");
        }
        return  null;
    }
}
