package com.codegym.repository.customer;

import com.codegym.model.Customer;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class CustomerRepository implements ICustomerRepro {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery = entityManager.createQuery("select c from Customer c", Customer.class);
        return typedQuery.getResultList();

    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> typedQuery=entityManager.createQuery("select c from Customer c where c.id=:id",Customer.class);
        typedQuery.setParameter("id",id);
        try{
            return typedQuery.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void remove(Long id) {
        Customer customer=findById(id);
        if(customer!=null){
            entityManager.remove(customer);
        }
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

}
