package pe.prodriverperu.beprodriverperu.entities;


import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "rol", nullable = false, length = 16)
    private String rol;
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Column(name = "lastname", nullable = false, length = 32)
    private String lastName;
    @Column(name = "email", nullable = false, length = 32)
    private String email;
    @Column(name = "password", nullable = false, length = 32)
    private String password;
    @Column(name = "dateofbirth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "plan", nullable = false, length = 16)
    private String plan;
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "image", nullable = false)
    private Long imageProfile;

}
