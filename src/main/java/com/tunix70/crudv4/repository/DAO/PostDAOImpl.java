package com.tunix70.crudv4.repository.DAO;


import com.tunix70.crudv4.model.Post;
import com.tunix70.crudv4.repository.PostRepository;
import com.tunix70.crudv4.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.TimeZone;

public class PostDAOImpl implements PostRepository {
    @Override
    public List<Post> getAll() {
        Session session = null;
        List <Post> postList = null;
        try {
            session = HibernateUtil.getSessionFactory().withOptions().
                    jdbcTimeZone(TimeZone.getTimeZone("UTC")).openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
            criteriaQuery.from(Post.class);

            postList = session.createQuery(criteriaQuery).getResultList();
        }catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return postList;
    }

    @Override
    public Post getById(Long id) {
        Session session = null;
        Post post = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            post = session.load(Post.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return post;
    }

    @Override
    public Post save(Post post) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(post);
            session.getTransaction().commit();
        }catch (Exception e){
            System.err.println(e);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

        return post;
    }

    @Override
    public Post update(Post post) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(post);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return post;
    }

    @Override
    public void deleteById(Long id) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Post post = session.load(Post.class, id);
            session.beginTransaction();
            session.delete(post);
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
