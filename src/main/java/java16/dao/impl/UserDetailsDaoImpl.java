package java16.dao.impl;

import jakarta.persistence.EntityManager;
import java16.config.DBConfig;
import java16.dao.UserDetailsDao;
import java16.model.UserDetails;
import java16.model.UserProfile;

import java.util.List;

public class UserDetailsDaoImpl implements UserDetailsDao {
    private final EntityManager entityManager = DBConfig.getEntityManagerFactory().createEntityManager();

    @Override
    public void createUserDetails(Long userProfile_id, UserDetails userDetails) {
        try {
            entityManager.getTransaction().begin();
            UserProfile userProfile = entityManager.find(UserProfile.class, userProfile_id);
            userProfile.setUserDetails(userDetails);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public UserDetails getUserDetailsById(Long id) {
        try {
            return entityManager.find(UserDetails.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String updateUserDetailsAddress(Long id, String newAddress) {
        try {
            entityManager.getTransaction().begin();
            UserDetails userDetails = entityManager.find(UserDetails.class, id);
            userDetails.setAddress(newAddress);
            entityManager.getTransaction().commit();
            return "success";
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return "fail";
        }
    }

    @Override
    public boolean deleteUserDetails(Long userProfile_id) {
        try {
            entityManager.getTransaction().begin();
            UserProfile userProfile = entityManager.find(UserProfile.class, userProfile_id);
            UserDetails userDetails = entityManager.find(UserDetails.class, userProfile.getUserDetails().getId());
            userProfile.setUserDetails(null);
            entityManager.remove(userDetails);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public UserDetails getUserByAddress(String address) {

        try {
          return   entityManager.find(UserDetails.class, address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDetails> sortUserByDateOfBirth(String ascOrDesc) {
        if (!ascOrDesc.equalsIgnoreCase("desc") && !ascOrDesc.equalsIgnoreCase("asc")) {
            System.out.println("Enter asc or desc");
            return null;
        }else  if(ascOrDesc.equalsIgnoreCase("asc")){
           return entityManager.createQuery("select u from UserDetails u order by u.dateOfBirth asc ",
                    UserDetails.class).getResultList();
        }else {
          return   entityManager.createQuery("select u from UserDetails u order by u.dateOfBirth desc ",
                    UserDetails.class).getResultList();
        }
    }
}
