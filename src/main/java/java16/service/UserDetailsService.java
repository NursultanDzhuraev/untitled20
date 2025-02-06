package java16.service;

import java16.model.UserDetails;


import java.util.List;

public interface UserDetailsService {
    void createUserDetails(Long userProfile_id, UserDetails userDetails);
    UserDetails getUserDetailsById(Long id);
    String updateUserDetailsAddress(Long id, String newAddress);
    boolean deleteUserDetails(Long userProfile_id);
    UserDetails getUserByAddress(String address);
    List<UserDetails> sortUserByDateOfBirth(String ascOrDesc);
}
