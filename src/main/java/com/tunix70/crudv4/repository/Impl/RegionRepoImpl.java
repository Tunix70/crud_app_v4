package com.tunix70.crudv4.repository.Impl;

import com.tunix70.crudv4.model.Region;
import com.tunix70.crudv4.repository.RegionRepository;
import com.tunix70.crudv4.util.SessionUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class RegionRepoImpl implements RegionRepository {
    private SessionUtil sessionUtil = new SessionUtil();
    @Override
    public List<Region> getAll() {
        List <Region> regionList = null;
        try(Session session = sessionUtil.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Region> criteriaQuery = builder.createQuery(Region.class);
            criteriaQuery.from(Region.class);
            regionList = session.createQuery(criteriaQuery).getResultList();
        }
            return regionList;
    }

    @Override
    public Region getById(Long id) {
        Region region = null;
        try (Session session = sessionUtil.openSession()){
            region = session.load(Region.class, id);
        }
        return region;
    }

    @Override
    public Region save(Region region) {
        try (Session session = sessionUtil.openTransactionSession()) {
            session.save(region);
            session.getTransaction().commit();
            return region;
        }
    }

    @Override
    public Region update(Region region) {
        try (Session session = sessionUtil.openTransactionSession()) {
            session.update(region);
            session.getTransaction().commit();
        }
        return region;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionUtil.openTransactionSession()) {
            Region region = session.load(Region.class, id);
            session.delete(region);
            session.getTransaction().commit();
        }

    }
}
