/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.dao;

import com.uptc.figueredo.rutinasdeportivas.util.RutinasDeportivasHibernateUtil;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlo
 */
public abstract class GenericDao<T, D> {

    protected Session session;
    protected Transaction transaction;

    public void initTransaction() {
        session = RutinasDeportivasHibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public void save(T entity) throws Exception {
        try {
            initTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }

    }

    public T findById(Class classObject, D id) throws Exception {
        try {
            initTransaction();
            T object = (T) session.get(classObject, (Serializable) id);
            session.clear();
            return object;
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }
    }
    
    public Integer maxValueInteger(Class classObject, String namePrimaryKey) throws Exception{
        try {
            initTransaction();
        Integer maxValue = (Integer) Optional.ofNullable(session
                .createQuery("SELECT MAX("+ namePrimaryKey +") FROM " + classObject.getSimpleName()))
                .map(query -> query.uniqueResult())
                .orElse(0);
        return Optional.of(maxValue).orElse(0);
        }
        catch(Exception ex) {
            throw ex;
        }
        finally {
            session.close();
        }
    }

    public List<T> entiyList(Class classObject) throws Exception {
        List<T> objectsList;
        try {
            initTransaction();
            objectsList = session.createQuery("from " + classObject.getSimpleName()).list();

        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }
        return objectsList;
    }

    public void update(T entity) throws Exception {
        try {
            initTransaction();
            session.update(entity);
            transaction.commit();
            session.clear();
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }
    }

    public void delete(T entity) throws Exception {
        try {
            initTransaction();
            session.delete(entity);
            transaction.commit();
            session.clear();
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }
    }

}
