package java16.dao;

import java16.model.UserProfile;

import java.time.LocalDate;
import java.util.List;

public interface UserProfileDao {
    void createUserProfile(UserProfile userProfile);
    UserProfile getUserProfileById(Long id);
    void updateUserProfileEmail(Long id, String email);
    boolean deleteUserProfile(Long id);
    UserProfile findUserByEmail(String email);
    List<UserProfile> getUserRegisteredAfterDate(LocalDate date);
}
