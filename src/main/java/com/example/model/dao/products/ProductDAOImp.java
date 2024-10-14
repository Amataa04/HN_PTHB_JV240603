package com.example.model.dao.products;

import com.example.model.entity.categories.Category;
import com.example.model.entity.products.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImp implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        List<Product> products = new ArrayList<>();
        try{
            products = session.createQuery("from Product",Product.class).getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return products;
    }

    @Override
    public boolean add(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Product.class, id);
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
    public boolean update(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
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
            session.remove(findById(id));
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return false;
    }
}
