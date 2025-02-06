package java16.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "User_Profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen",sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private LocalDate registration_date;

    public UserProfile(String username, String email, LocalDate registration_date) {
        this.username = username;
        this.email = email;
        this.registration_date = registration_date;
    }
    @OneToOne(mappedBy = "userProfile")
    private UserDetails userDetails;
}
