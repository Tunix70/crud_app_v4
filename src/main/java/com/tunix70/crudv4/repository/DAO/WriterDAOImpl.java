package com.tunix70.crudv4.repository.DAO;

import com.tunix70.crudv4.model.Writer;
import com.tunix70.crudv4.repository.WriterRepository;
import com.tunix70.crudv4.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class WriterDAOImpl implements WriterRepository {
    @Override
    public List<Writer> getAll() {
        Session session = null;
        List <Writer> writerList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Writer> criteriaQuery = builder.createQuery(Writer.class);
            criteriaQuery.from(Writer.class);

            writerList = session.createQuery(criteriaQuery).getResultList();
        }catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return writerList;
    }

    @Override
    public Writer getById(Long id) {
        Session session = null;
        Writer writer = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            writer = session.load(Writer.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return writer;
    }

    @Override
    public Writer save(Writer writer) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(writer);
            session.getTransaction().commit();
        }catch (Exception e){
            System.err.println(e);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(writer);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return writer;
    }

    @Override
    public void deleteById(Long id) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Writer writer = session.load(Writer.class, id);
            session.beginTransaction();
            session.delete(writer);
            session.getTransaction().commit();
        }catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
