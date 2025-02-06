package java16;

import jakarta.persistence.EntityManagerFactory;
import java16.config.DBConfig;
import java16.dao.UserDetailsDao;
import java16.dao.UserProfileDao;
import java16.dao.impl.UserDetailsDaoImpl;
import java16.dao.impl.UserProfileDaoImpl;
import java16.model.UserDetails;
import java16.model.UserProfile;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = DBConfig.getEntityManagerFactory();
        System.out.println(entityManagerFactory);
        UserProfileDao userProfileDao = new UserProfileDaoImpl();
        UserDetailsDao userDetailsDao = new UserDetailsDaoImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    0 Exit
                    1 create User Profile
                    2 get User Profile By Id
                    3 update User Profile Email
                    4 delete User Profile
                    5 find User By Email
                    6 get User Registered After Date
                    7 createUserDetails
                    8 getUserDetailsById
                    9 updateUserDetailsAddress
                    10 deleteUserDetails
                    11 getUserByAddress
                    12 sortUserByDateOfBirth
                    """);
            switch (scanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    userProfileDao.createUserProfile(new UserProfile("Aibek", "aibek@gmail.com", LocalDate.of(2020, 10, 10)));
                    userProfileDao.createUserProfile(new UserProfile("Aibek1", "aibek1@gmail.com", LocalDate.of(2020, 10, 10)));
                    userProfileDao.createUserProfile(new UserProfile("Aibek2", "aibek2@gmail.com", LocalDate.of(2022, 10, 10)));
                    userProfileDao.createUserProfile(new UserProfile("Aibek3", "aibek3@gmail.com", LocalDate.of(2023, 10, 10)));
                }
                case 2 -> {
                    UserProfile userProfileById = userProfileDao.getUserProfileById(1L);
                    System.out.println(userProfileById);
                }
                case 3 -> {
                    userProfileDao.updateUserProfileEmail(2L, "aibek111@gmail.com");
                }
                case 4 -> {
                    boolean b = userProfileDao.deleteUserProfile(2L);
                    System.out.println(b);
                }
                case 5 -> {
                    UserProfile userByEmail = userProfileDao.findUserByEmail("aibek111@gmail.com");
                    System.out.println(userByEmail);
                }
                case 6 -> {
                    List<UserProfile> userRegisteredAfterDate = userProfileDao
                            .getUserRegisteredAfterDate(LocalDate.of(2020, 10, 10));
                    System.out.println(userRegisteredAfterDate);
                }
                case 7 -> {
                    userDetailsDao.createUserDetails(1L, new UserDetails("Baiel1", LocalDate.of(2025, 1, 1), "test1"));
                    userDetailsDao.createUserDetails(1L, new UserDetails("Baiel2", LocalDate.of(2025, 1, 1), "test2"));
                    userDetailsDao.createUserDetails(1L, new UserDetails("Baiel3", LocalDate.of(2025, 1, 1), "test3"));
                }
                case 8 -> {
                    UserDetails test1 = userDetailsDao.getUserByAddress("test1");
                    System.out.println(test1);
                }
                case 9 -> {
                    String s = userDetailsDao.updateUserDetailsAddress(1L, "test33");
                    System.out.println(s);
                }
                case 10 -> {
                    boolean b = userDetailsDao.deleteUserDetails(3L);
                    System.out.println(b);
                }
                case 11 -> {
                    userDetailsDao.getUserByAddress("test2");
                }
                case 12 -> {
                    List<UserDetails> desc = userDetailsDao.sortUserByDateOfBirth("desc");
                    System.out.println(desc);
                }
            }
        }
    }
}
