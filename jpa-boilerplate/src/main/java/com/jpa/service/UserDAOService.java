package com.jpa.service;

import com.jpa.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOService {

    //Has all the DAO functions
    @PersistenceContext
    private EntityManager entityManager;

    public long insert(User user)
    {
        entityManager.persist(user);
        return user.getId();
    }

    public User getUserById(long id)
    {
        return entityManager.find(User.class,id);
    }

    public void updateUser(User user)
    {
        User new_user = getUserById(user.getId());
        new_user.setName("Nidhi");
        new_user.setRole("admin");
        entityManager.flush();
    }

    public void deleteUser(long userid)
    {
        entityManager.remove(getUserById(userid));
    }
}
