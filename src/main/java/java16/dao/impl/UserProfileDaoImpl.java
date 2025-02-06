package java16.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java16.config.DBConfig;
import java16.dao.UserProfileDao;
import java16.model.UserProfile;

import java.time.LocalDate;
import java.util.List;

public class UserProfileDaoImpl implements UserProfileDao {
    private final EntityManager entityManager = DBConfig.getEntityManagerFactory().createEntityManager();

    @Override
    public void createUserProfile(UserProfile userProfile) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userProfile);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        try {
            return entityManager.find(UserProfile.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateUserProfileEmail(Long id, String email) {
        try {
            entityManager.getTransaction().begin();

            UserProfile userProfile = getUserProfileById(id);
            userProfile.setEmail(email);
            entityManager.merge(userProfile);
            entityManager.getTransaction().commit();

        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean deleteUserProfile(Long id) {
        try {
            entityManager.getTransaction().begin();
            UserProfile userProfile = getUserProfileById(id);
            entityManager.remove(userProfile);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public UserProfile findUserByEmail(String email) {
        try {
            return entityManager.find(UserProfile.class, email);
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserProfile> getUserRegisteredAfterDate(LocalDate date) {
        try {
            TypedQuery<UserProfile> query = entityManager.createQuery
                    ("SELECT u FROM UserProfile u WHERE u.registration_date = :date", UserProfile.class);
            query.setParameter("date", date);
            return query.getResultList();

        }catch (Exception e) {
            return null;
        }
    }


}
