package com.tunix70.crudv4.repository.DAO;


import com.tunix70.crudv4.model.Post;
import com.tunix70.crudv4.repository.PostRepository;
import com.tunix70.crudv4.util.SessionUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Date;
import java.util.List;

public class PostDAOImpl implements PostRepository {
    private SessionUtil sessionUtil = new SessionUtil();
    @Override
    public List<Post> getAll() {
        List <Post> postList = null;
        try(Session session = sessionUtil.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
            criteriaQuery.from(Post.class);
            postList = session.createQuery(criteriaQuery).getResultList();
        }
        return postList;
    }

    @Override
    public Post getById(Long id) {
        Post post = null;
        try (Session session = sessionUtil.openSession()){
            post = session.load(Post.class, id);
        }
        return post;
    }

    @Override
    public Post save(Post post) {
        try (Session session = sessionUtil.openTransactionSession()) {
            post.setCreated(new Date().getTime());
            post.setUpdated(new Date().getTime());
            session.save(post);
            session.getTransaction().commit();
        }
        return post;
    }

    @Override
    public Post update(Post post) {
        try (Session session = sessionUtil.openTransactionSession()) {
            post.setUpdated(new Date().getTime());
            session.update(post);
            session.getTransaction().commit();
        }
        return post;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionUtil.openTransactionSession()) {
            Post post = session.load(Post.class, id);
            session.delete(post);
            session.getTransaction().commit();
        }
    }
}

