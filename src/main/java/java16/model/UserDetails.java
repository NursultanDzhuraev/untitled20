package java16.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User_Details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "profile_gen")
    @SequenceGenerator(name = "profile_gen", sequenceName = "profile_seq", allocationSize = 1)
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String address;

    public UserDetails(String fullName, LocalDate dateOfBirth, String address) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;

    }

    @OneToOne
    private UserProfile userProfile;
}
