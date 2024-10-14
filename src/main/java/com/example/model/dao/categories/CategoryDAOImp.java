package com.example.model.dao.categories;

import com.example.model.entity.categories.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImp implements CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        List<Category> categories = new ArrayList<>();
        try{
            categories = session.createQuery("from Category", Category.class).getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return categories;
    }

    @Override
    public boolean add(Category category) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        Session session = sessionFactory.openSession();
        try{
            return session.get(Category.class, id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Category category) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        return false;
    }
}
