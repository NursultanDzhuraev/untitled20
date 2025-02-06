package java16.service;

import java16.model.UserProfile;

import java.time.LocalDate;
import java.util.List;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);
    UserProfile getUserProfileById(Long id);
    void updateUserProfileEmail(Long id , String email);
    boolean deleteUserProfile(Long id);
    UserProfile findUserByEmail(String email);
    List<UserProfile> getUserRegisteredAfterDate(LocalDate date);
}
