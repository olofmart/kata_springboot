package ru.olmart.kata_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.olmart.kata_springboot.model.User;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User newUser) {
        User oldUser = getUserById(id);
        oldUser.setName(newUser.getName());
        oldUser.setLastname(newUser.getLastname());
        oldUser.setEmail(newUser.getEmail());
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getUserById(id));
    }
}
