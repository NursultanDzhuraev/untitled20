package java16.service.impl;


import java16.dao.UserProfileDao;
import java16.dao.impl.UserProfileDaoImpl;
import java16.model.UserProfile;
import java16.service.UserProfileService;

import java.time.LocalDate;
import java.util.List;


public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileDao userProfileDao = new UserProfileDaoImpl();

    @Override
    public void createUserProfile(UserProfile userProfile) {
        try {
            userProfileDao.createUserProfile(userProfile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        try {
          return   userProfileDao.getUserProfileById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserProfileEmail(Long id, String email) {
        try {
            userProfileDao.updateUserProfileEmail(id, email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUserProfile(Long id) {
        try {
         return    userProfileDao.deleteUserProfile(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserProfile findUserByEmail(String email) {
        try {
           return userProfileDao.findUserByEmail(email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserProfile> getUserRegisteredAfterDate(LocalDate date) {
        try {
          return   userProfileDao.getUserRegisteredAfterDate(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
