package com.tunix70.crudv4.repository.DAO;

import com.tunix70.crudv4.model.Writer;
import com.tunix70.crudv4.repository.WriterRepository;
import com.tunix70.crudv4.util.SessionUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class WriterDAOImpl implements WriterRepository {
    private SessionUtil sessionUtil = new SessionUtil();

    @Override
    public List<Writer> getAll() {
        List <Writer> writerList = null;
        try(Session session = sessionUtil.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Writer> criteriaQuery = builder.createQuery(Writer.class);
            criteriaQuery.from(Writer.class);
            writerList = session.createQuery(criteriaQuery).getResultList();
        }
        return writerList;
    }

    @Override
    public Writer getById(Long id) {
        Writer writer = null;
        try (Session session = sessionUtil.openSession()){
            writer = session.load(Writer.class, id);
        }
        return writer;
    }

    @Override
    public Writer save(Writer writer) {
        try (Session session = sessionUtil.openTransactionSession()) {
            session.save(writer);
            session.getTransaction().commit();
        }
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
            try (Session session = sessionUtil.openTransactionSession()) {
            session.update(writer);
            session.getTransaction().commit();
        }
        return writer;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionUtil.openTransactionSession()) {
            Writer writer = session.load(Writer.class, id);
            session.delete(writer);
            session.getTransaction().commit();
        }
    }
}
