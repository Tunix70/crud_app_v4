package com.tunix70.crudv4.repository.DAO;

import com.tunix70.crudv4.model.Region;
import com.tunix70.crudv4.repository.RegionRepository;
import com.tunix70.crudv4.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class RegionDAOImpl implements RegionRepository {

    @Override
    public List<Region> getAll() {
        Session session = null;
        List <Region> regionList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Region> criteriaQuery = builder.createQuery(Region.class);
            criteriaQuery.from(Region.class);

            regionList = session.createQuery(criteriaQuery).getResultList();
        }catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
            return regionList;
    }

    @Override
    public Region getById(Long id) {
        Session session = null;
        Region region = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            region = session.load(Region.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return region;
    }

    @Override
    public Region save(Region region) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(region);
            session.getTransaction().commit();
        }catch (Exception e){
            System.err.println(e);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

        return region;
    }

    @Override
    public Region update(Region region) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(region);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return region;
    }

    @Override
    public void deleteById(Long id) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Region region = session.load(Region.class, id);
            session.beginTransaction();
            session.delete(region);
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
