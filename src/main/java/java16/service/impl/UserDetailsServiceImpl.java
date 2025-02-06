package java16.service.impl;

import java16.dao.UserDetailsDao;
import java16.dao.impl.UserDetailsDaoImpl;
import java16.model.UserDetails;
import java16.service.UserDetailsService;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsDao userDetailsDao = new UserDetailsDaoImpl();
    @Override
    public void createUserDetails(Long userProfile_id, UserDetails userDetails) {
        try {
            userDetailsDao.createUserDetails(userProfile_id, userDetails);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDetails getUserDetailsById(Long id) {
        try {
         return    userDetailsDao.getUserDetailsById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String updateUserDetailsAddress(Long id, String newAddress) {
        try {
         return    userDetailsDao.updateUserDetailsAddress(id, newAddress);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUserDetails(Long userProfile_id) {
        try {
       return      userDetailsDao.deleteUserDetails(userProfile_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDetails getUserByAddress(String address) {
        try {
         return    userDetailsDao.getUserByAddress(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDetails> sortUserByDateOfBirth(String ascOrDesc) {
        try {
          return   userDetailsDao.sortUserByDateOfBirth(ascOrDesc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
